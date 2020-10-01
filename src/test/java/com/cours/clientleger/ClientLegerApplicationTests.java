package com.cours.clientleger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@SpringBootTest
class ClientLegerApplicationTests {

    @Test
    void contextLoads() {
        //TODO Put that in main code and in classes
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate myDateObj = LocalDate.parse("01/10/2020".replace("/", "-"), myFormatObj);
        System.out.println("After formatting: " + myDateObj);
    }

}
