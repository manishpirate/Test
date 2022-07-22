package com.crypto.example.cryptoboot.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CryptoApiClient {

    @Value("${crypto.api.key}")
    private String apiKey;

    WebClient client;

    public void callAPI(String uri){
        System.out.println("Request started");
        WebClient client = WebClient.create();

        WebClient.ResponseSpec respone = client.get().uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("X-API-Key", apiKey)
                .retrieve();

        System.out.println(respone.bodyToMono(String.class).block());

        System.out.println("This is the end of the program");
    }

}
