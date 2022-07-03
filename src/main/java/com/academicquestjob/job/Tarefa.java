package com.academicquestjob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@EnableScheduling
public class Tarefa {

    private final long SEGUNDO = 5000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    private String url = "https://ms-academicquest.herokuapp.com/teste";


    @Autowired
    private RestTemplate restTemplate;


    @Scheduled(fixedDelay = SEGUNDO)
    public void taskExecutada() {

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        System.out.println(entity.getStatusCodeValue());


    }

}