package com.smart.test.utility;

import com.smart.test.dto.PasswordDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Utility {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static PasswordDto generatePassword(String password, String salt) {
        salt = PASSWORD_ENCODER.encode(salt);
        password = PASSWORD_ENCODER.encode(password.concat(salt));
        return new PasswordDto(password, salt);

    }

    public static boolean verifyPassword(PasswordDto passwordRecord, String hashedPassword) {
        return PASSWORD_ENCODER.matches(passwordRecord.password().concat(passwordRecord.salt()), hashedPassword);

    }

    public static Supplier<Double> generateRandomNumber = () ->
    {
        return new SecureRandom().nextDouble();
    };
}
