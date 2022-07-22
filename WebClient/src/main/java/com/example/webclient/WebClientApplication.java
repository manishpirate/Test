package com.example.webclient;

import com.example.webclient.client.LocalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebClientApplication {

    @Autowired
    LocalClient client;

    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
    }

    @PostConstruct
    public void callAPIo(){
        client.callAPI("http://localhost:8080/test");
    }

}
