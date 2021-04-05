package com.sandbox.springcloud.configclient.defaultoauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("com.sandbox.demo.defaultoauth.UserService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("com.sandbox.demo.defaultoauth.UserRepository")
    UserRepository userRepository;

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.query(userName);
        if (!user.isPresent())
            throw new UsernameNotFoundException("there's no user founded!");
        else
            return user.get();
    }


}
