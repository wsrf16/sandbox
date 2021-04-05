package com.sandbox.springcloud.configclient.customoauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

public class User implements UserDetails, Serializable {
    public User(String username, String password, String... roles){
        setUsername(username);
        setPassword(password);
//        setRoles(roles);
        setAuthorities(AuthorityUtils.createAuthorityList(roles));
    }

    public User(String username, String password, GrantedAuthority... grantedAuthorities){
        setUsername(username);
        setPassword(password);
//        setRoles(roles);
        setAuthorities(Arrays.asList(grantedAuthorities));
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

//    public String[] getRoles() {
//        return roles;
//    }

//    private void setRoles(String[] roles) {
//        this.roles = roles;
//    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    private Integer id;
    private String username;
    private String email;
    private String password;
//    private String[] roles;
    private List<GrantedAuthority> authorities;




}
