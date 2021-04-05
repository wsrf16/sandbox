package com.sandbox.springcloud.configclient.defaultoauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service("defaultAuthenticationProvider")
public class DefaultAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    @Qualifier("com.sandbox.demo.defaultoauth.UserService")
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.loadUserByUsername(name);
        if (user == null || !user.getPassword().equals(password)) {
            throw new AuthenticationCredentialsNotFoundException("invalid username or password.");
        }

        return new UsernamePasswordAuthenticationToken(name, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
