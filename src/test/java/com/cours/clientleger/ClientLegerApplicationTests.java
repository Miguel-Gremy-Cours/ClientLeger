package com.cours.clientleger;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import com.cours.clientleger.Application.Offres.Get.OffresGetInstance;
import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.Database.Offres;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.security.MessageDigest;

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
