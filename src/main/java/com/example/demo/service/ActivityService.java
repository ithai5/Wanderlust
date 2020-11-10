package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepo activityRepo;

    public ResponseEntity<List<Activity>> getAllActivity(){
        List<Activity> lsActivity = new ArrayList<>();
        lsActivity.addAll(activityRepo.findAll());
        return new ResponseEntity<>(lsActivity, HttpStatus.OK);
    }

    public ResponseEntity<Activity> findById(int id){
        Activity activity = activityRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found activity with id = " + id));
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    public Activity postActivity(Activity activity){
        return activityRepo.save(activity);
    }

    public Activity patchActivity (int id , Activity patch){
        Activity activity = activityRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found activity with id" + id));
        if (patch.getaName() != null)
            activity.setaName(patch.getaName());

        if (patch.getaDescription() != null)
            activity.setaDescription(patch.getaDescription());
        return activityRepo.save(activity);
    }

    //Consider adding EmptyResultDataAccessException to the ExceptionHandler
    public void deleteActivity(int id){
        try{
            activityRepo.deleteById(id);
        }
        catch(EmptyResultDataAccessException ex){}
    }
}
