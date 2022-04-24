package com.sandbox.springcloud.configclient.customoauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service//("com.sandbox.demo.customoauth.UserService")
class UserService implements UserDetailsService {

    @Autowired
    //@Qualifier("com.sandbox.demo.customoauth.UserRepository")
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        Optional<UserDetails> user = userRepository.query(username);
        if (!user.isPresent())
            throw new UsernameNotFoundException("there's no user founded!");
        else
            return user.get();
    }
}
