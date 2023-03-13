package com.wildcodeschool.doctor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wildcodeschool.doctor.model.Doctor;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @RequestMapping(value = "/{number}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getDoctor(@PathVariable("number") int number) {

        if(number == 13) {
            Doctor doctor = new Doctor(13, "Jodie Whittaker");
            return new ResponseEntity<Object>(doctor, HttpStatus.OK);
        } else if(number >= 1 && number <= 12) {
            String message = "303 see other";
            return new ResponseEntity<Object>(message, HttpStatus.SEE_OTHER);
        } else {
            String message = "404 error: File not found. Impossible de récupérer l'incarnation " + number + ".";
            return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
        }
    }
}



