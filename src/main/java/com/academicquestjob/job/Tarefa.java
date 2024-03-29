package com.academicquestjob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    private String urlJob = "https://ms-academicquest.herokuapp.com/tarefa/grupo/job";

    @Autowired
    private RestTemplate restTemplate;


    @Scheduled(cron = "0 0 23 * * *")
    public void taskExecutada() {

        System.out.println("Executando job...");
        ResponseEntity<String> entity = restTemplate.getForEntity(urlJob, String.class);
        if (entity.getStatusCodeValue() == 200) {
            System.out.println("Job executado com sucesso");
        } else {
            System.out.println("Job nao executado");
        }

    }




}