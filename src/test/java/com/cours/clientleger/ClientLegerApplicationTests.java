package com.cours.clientleger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
@Controller
class ClientLegerApplicationTests {
    @Autowired
    OffresRepository offresRepository;

    @Test
    void contextLoads() throws NoSuchAlgorithmException {
        String text = "miguel";
        System.out.println(
                Hashing.sha256()
                        .hashString(text, StandardCharsets.UTF_8)
                        .toString()
        );

    }

}
