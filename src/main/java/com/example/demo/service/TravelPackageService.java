package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TravelPackageService {

    private final TravelPackageRepo travelPackageRepo;

    @Autowired
    public TravelPackageService (TravelPackageRepo travelPackageRepo)
    {
        super();
        this.travelPackageRepo = travelPackageRepo;
    }

    public ResponseEntity<List<TravelPackage>> getAllTravelPackage ()
    {
        List<TravelPackage> lsTravelPackage = new ArrayList<>();
        lsTravelPackage.addAll(travelPackageRepo.findAll());
        return new ResponseEntity<>(lsTravelPackage, HttpStatus.OK);
    }

    public ResponseEntity<TravelPackage> findById (int id)
    {
        TravelPackage travelPackage = travelPackageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found travelPackage id = " + id));
        return new ResponseEntity<>(travelPackage, HttpStatus.OK);
    }

    public TravelPackage postTravelPackage (TravelPackage travelPackage)
    {
        return travelPackageRepo.save(travelPackage);
    }

    public TravelPackage patchTravelPackage (int id, TravelPackage patch)
    {
        TravelPackage travelPackage = findById(id).getBody();
        if (patch == null)
            return null;
        else {
            if (patch.getTpName() != null)
                travelPackage.setTpName(patch.getTpName());
            if (patch.getTpPrice() != 0)
                travelPackage.setTpPrice(patch.getTpPrice());
            return travelPackageRepo.save(travelPackage);
        }
    }

    public void deleteTravelPackage(int id){
        try{
            travelPackageRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.DESC;
    }

    private List<Sort.Order> getSortOrder(String[] sort){
        //Sorting part
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        //sort=[field, direction]
        orders.add(new Sort.Order(getSortDirection(sort[1]),sort[0]));
        return orders;
    }



    private Page<TravelPackage> paging(String name, int page, int size, List<Sort.Order> sortOrders){
        Pageable paging = PageRequest.of(page, size, Sort.by(sortOrders));
        if (name == null) {
            return travelPackageRepo.findAll(paging);
        } else {
            return travelPackageRepo.findAllByTpNameContaining(name, paging);
        }

    }
    public ResponseEntity<Map<String, Object>> getPageAndSort(String tpName, int page, int size, String[]sort) {

        List<Sort.Order> sortOrder = getSortOrder(sort);
        //Paging
        Page<TravelPackage>pageTp = paging(tpName,page,size,sortOrder);
        List<TravelPackage> travelPackages = pageTp.getContent();
        if (travelPackages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("travelPackages", travelPackages);
        response.put("currentPage", pageTp.getNumber());
        response.put("totalItems", pageTp.getTotalElements());
        response.put("totalPage", pageTp.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}

