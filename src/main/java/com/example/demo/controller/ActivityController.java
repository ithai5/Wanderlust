package com.example.demo.controller;


import com.example.demo.model.Activity;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/activity")
    public ResponseEntity <List<Activity>> getAllActivity(){
        return activityService.getAllActivity();
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> findById(@PathVariable("id")  int id){
        return activityService.findById(id);
    }

    @PostMapping(value = "/activity" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity){
        return activityService.postActivity(activity);
    }

    @PatchMapping(path = "/activity/{id}", consumes =  "application/json")
    public Activity patchActivity (@PathVariable("id") int id , @RequestBody Activity patch){
        return activityService.patchActivity(id, patch);
    }

    //Consider adding EmptyResultDataAccessException to the ExceptionHandler
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/activity/{id}")
    public void deleteActivity(@PathVariable("id")  int id){
        activityService.deleteActivity(id);
    }
}
