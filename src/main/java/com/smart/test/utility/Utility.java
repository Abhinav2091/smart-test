package com.smart.test.utility;

import com.smart.test.dto.PasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utility {


    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public PasswordDto generatePassword(String password, String salt) {
        salt = passwordEncoder.encode(salt);
        password = passwordEncoder.encode(password.concat(salt));
        return new PasswordDto(password, salt);

    }

    public boolean verifyPassword(PasswordDto passwordRecord, String hashedPassword) {
        return PASSWORD_ENCODER.matches(passwordRecord.password().concat(passwordRecord.salt()), hashedPassword);

    }
}
