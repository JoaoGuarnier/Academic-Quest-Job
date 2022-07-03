package com.academicquestjob.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
@EnableScheduling
public class Tarefa {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;


    @Scheduled(fixedDelay = MINUTO)
    public void taskExecutada() {

        System.out.println("Executando taskExecutada...");

    }

}
