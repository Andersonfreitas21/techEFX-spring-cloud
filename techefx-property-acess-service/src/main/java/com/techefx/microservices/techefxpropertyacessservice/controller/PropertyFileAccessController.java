package com.techefx.microservices.techefxpropertyacessservice.controller;

import com.techefx.microservices.techefxpropertyacessservice.beans.PropertyAccessBean;
import com.techefx.microservices.techefxpropertyacessservice.beans.PropertyAccessValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/access")
public class PropertyFileAccessController {

    @Autowired
    PropertyAccessBean propertyAccessBean;

    @GetMapping("accessPropertyFile")
    public PropertyAccessValue accessPropertyFile() {
        refreshActuator();
        return PropertyAccessValue.builder()
                .name(propertyAccessBean.getName())
                .description(propertyAccessBean.getDescription())
                .build();
    }

    public void refreshActuator() {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8100/actuator/refresh";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application-json");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, entity, String.class);
    }

}
