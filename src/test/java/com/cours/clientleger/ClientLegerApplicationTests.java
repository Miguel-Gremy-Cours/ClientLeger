package com.cours.clientleger;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Controller
class ClientLegerApplicationTests {
    @Test
    void contextLoads() {
        Map<String, String> data = new HashMap<>();

        data.put("key1", "value1");

        System.out.println((data.get("key1")));
    }

}
