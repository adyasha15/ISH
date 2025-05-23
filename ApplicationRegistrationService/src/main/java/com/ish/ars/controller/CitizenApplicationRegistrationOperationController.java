package com.ish.ars.controller;

import com.ish.ars.binding.CitizenAppRegistrationInput;
import com.ish.ars.repository.IApplicationRegistrationRepository;
import com.ish.ars.service.ICitizenApplicationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CitizenAR-api")
public class CitizenApplicationRegistrationOperationController {

    @Autowired
    private ICitizenApplicationRegistrationService registrationService;
    @PostMapping("/save")
    public ResponseEntity<String> saveCitizenApplication(@RequestBody CitizenAppRegistrationInput inputs){

        try {
            int appId = registrationService.registerCitizenApplication(inputs);
            if (appId>0)
                return new ResponseEntity<String>("Citizen application is register with Id::" + appId, HttpStatus.CREATED);
            else
                return new ResponseEntity<String>("Invalid SSN or Citizen must belong to california state::",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
