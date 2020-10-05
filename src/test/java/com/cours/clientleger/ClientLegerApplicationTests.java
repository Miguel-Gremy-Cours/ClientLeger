package com.cours.clientleger;

import com.cours.clientleger.Model.Enum.ProblemEnum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
class ClientLegerApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(
                LocalDate.now()
        );
    }

}
