package com.ish.ars.service;

import com.ish.ars.binding.CitizenAppRegistrationInput;
import com.ish.ars.entity.CitizenApplicationEntity;
import com.ish.ars.repository.IApplicationRegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CitizenApplicationRegistrationServiceImpl implements ICitizenApplicationRegistrationService {
    @Autowired
    private IApplicationRegistrationRepository citizenRepo;

    @Autowired
    private RestTemplate template;

    @Value("${ar.ssa-web.url:http://localhost:9090/ssa-web-api/find/{ssn}}")
    private  String endpointUrl;

    @Value("${ar.state:california}")
    private String targetState;


    @Override
    public Integer registerCitizenApplication(CitizenAppRegistrationInput inputs) {
//        String SSAWebUrl="http://localhost:9090/ssa-web-api/find/{ssn}";

//        HttpHeaders headers=new HttpHeaders();
//        headers.set("accept", "application/json");
//        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = template.exchange(endpointUrl, HttpMethod.GET,null, String.class,inputs.getSsn());

        String stateName = response.getBody();

        if (stateName.equalsIgnoreCase(targetState)){
            CitizenApplicationEntity entity = new CitizenApplicationEntity();
            BeanUtils.copyProperties(inputs,entity);
            entity.setStateName(stateName);

            int appid = citizenRepo.save(entity).getAppId();
            return appid;
        }
        return 0;
    }
}
