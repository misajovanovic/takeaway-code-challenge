package com.takeaway.playerseurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PlayersEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayersEurekaServiceApplication.class, args);
    }

}
