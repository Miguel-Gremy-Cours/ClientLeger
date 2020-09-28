package com.cours.clientleger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ClientLegerApplication {
    @Autowired
    private static Environment env;

    public static void main(String[] args) {
        SpringApplication.run(ClientLegerApplication.class, args);
    }


}
