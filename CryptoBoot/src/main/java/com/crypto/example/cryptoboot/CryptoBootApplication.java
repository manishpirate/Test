package com.crypto.example.cryptoboot;

import com.crypto.example.cryptoboot.webclient.CryptoApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CryptoBootApplication {

    @Autowired
    CryptoApiClient client;

    public static void main(String[] args) {
        SpringApplication.run(CryptoBootApplication.class, args);
    }

    @PostConstruct
    public void callAfterInit(){
        client.callAPI("https://rest.cryptoapis.io/v2/wallet-as-a-service/wallets/62da5c07e9f2c800078e1237/bitcoin/testnet/addresses");
        //client.callAPI("http://localhost:8080/test");
    }

}
