package com.example.webclient.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LocalClient {

    public void callAPI(String url){
        WebClient client = WebClient.create();

        WebClient.ResponseSpec response = client.get().uri(url).retrieve();
        System.out.println(response.bodyToMono(String.class).block());
    }

}
