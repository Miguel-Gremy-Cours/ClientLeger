package com.cours.clientleger;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

@SpringBootTest
@Controller
class ClientLegerApplicationTests {
    @Test
    void contextLoads() {
        System.out.println(
                EmailValidator.getInstance().isValid("miguel.gremy@azerty")
        );
    }

}
