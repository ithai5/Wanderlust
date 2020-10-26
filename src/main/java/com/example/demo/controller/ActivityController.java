package com.example.demo.controller;


import com.example.demo.exeption.ResourceNotFoundException;
import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivityController {

    @Autowired
    ActivityRepo activityRepo;

    @GetMapping("/activity")
    public ResponseEntity <List<Activity>> getAllActivity(){
        try{
            List<Activity> lsActivity = new ArrayList<>();
            lsActivity.addAll(activityRepo.findAll());
            return new ResponseEntity<>(lsActivity, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> findById(@PathVariable("id")  int id){
        Activity activity = activityRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found activity with id = " + id));
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PostMapping(value = "/activity" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity){
        return activityRepo.save(activity);
    }

    @PatchMapping(path = "/activity/{id}", consumes =  "application/json")
    public Activity patchActivity (@PathVariable("id") int id , @RequestBody Activity patch){
        Activity activity = activityRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found activity with id" + id));
            if (patch.getaName() != null)
                activity.setaName(patch.getaName());

            if (patch.getaDescription() != null)
                activity.setaDescription(patch.getaDescription());
        return activityRepo.save(activity);
    }

    @PutMapping("/activity/{id}")
    public Activity putActivity(@RequestBody Activity activity){
        return activityRepo.save(activity);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/activity/{id}")
    public void deleteActivity(@PathVariable("id")  int id){
        try{
            activityRepo.deleteById(id);
        }
        catch(EmptyResultDataAccessException ex){}
    }
}
