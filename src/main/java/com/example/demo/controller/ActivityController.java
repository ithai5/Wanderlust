package com.example.demo.controller;


import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Activity> findById(@PathVariable long id){
        if(activityRepo.findById(id).isPresent()){
            return activityRepo.findById(id);
        }
        else{
            return null;
        }
    }

    @PostMapping(value = "/activity" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity){
        return activityRepo.save(activity);
    }

    @PatchMapping(path = "/activity/{id}", consumes =  "application/json")
    public Activity patchActivity (@PathVariable long id , @RequestBody Activity patch){
        Activity activity = activityRepo.findById(id).get();
        if(patch == null)
            return null;
        else {
            if (patch.getaName() != null)
                activity.setaName(patch.getaName());

            if (patch.getaDescription() != null)
                activity.setaDescription(patch.getaDescription());

        }
        return activityRepo.save(activity);
    }

    @PutMapping("/activity/{id}")
    public Activity putActivity(@RequestBody Activity activity){
        return activityRepo.save(activity);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/activity/{id}")
    public void deleteActivity(@PathVariable long id){
        try{
            activityRepo.deleteById(id);
        }
        catch(EmptyResultDataAccessException ex){}
    }
}
