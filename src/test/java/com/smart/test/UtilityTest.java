package com.smart.test;

import com.smart.test.dto.PasswordDto;
import com.smart.test.utility.Utility;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UtilityTest {
    private static final String PASSWORD = "password";
    private static final String SALT = "salt";

    @MockBean
    private Utility utility;


    public void verifyPassword() {
        PasswordDto hashedPassword = utility.generatePassword(PASSWORD, SALT);
        PasswordDto passwordRecord = new PasswordDto(PASSWORD, hashedPassword.salt());
        Assertions.assertTrue(utility.verifyPassword(passwordRecord, hashedPassword.password()));
    }
}
