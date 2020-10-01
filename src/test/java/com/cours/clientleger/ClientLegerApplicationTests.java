package com.cours.clientleger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.cours.clientleger.Controller.Utils.DateUtils.stringToLocalDate;

@SpringBootTest
class ClientLegerApplicationTests {

    @Test
    void contextLoads() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

}
