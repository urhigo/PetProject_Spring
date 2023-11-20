package com.example.petproject.configuration;

import com.example.petproject.models.UserModel;
import com.example.petproject.repositorys.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRep userRep;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRep.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user name not found");
        } else {
            return new CustomUser(user);
        }
    }
}
