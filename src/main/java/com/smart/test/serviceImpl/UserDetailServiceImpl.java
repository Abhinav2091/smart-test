package com.smart.test.serviceImpl;

import com.smart.test.dao.UserRepo;
import com.smart.test.dto.UserInfoForJWT;
import com.smart.test.model.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findById(Long.parseLong(username));

        return user.map(UserInfoForJWT::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "));

    }
}
