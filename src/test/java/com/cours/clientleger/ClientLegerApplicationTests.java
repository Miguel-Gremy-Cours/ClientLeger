package com.cours.clientleger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;

@SpringBootTest
@Controller
class ClientLegerApplicationTests {
    @Autowired
    OffresRepository offresRepository;

    @Test
    void contextLoads() {
        System.out.println(offresRepository.findAll().getClass());

    }

}
