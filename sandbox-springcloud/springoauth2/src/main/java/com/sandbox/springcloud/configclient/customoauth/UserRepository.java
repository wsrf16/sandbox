package com.sandbox.springcloud.configclient.customoauth;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository//("com.sandbox.demo.customoauth.UserRepository")
public class UserRepository {
    private final static Set<UserDetails> users = new HashSet<UserDetails>();

    //@Select("select id, user_name as userName, email, password, role_string as roleString from account where user_name=#{user_name}")
    public UserRepository() {
        customUsers();
//        originUsers();
    }

    private void customUsers() {
        users.add(new com.sandbox.springcloud.configclient.customoauth.User("user1", "1", "admin", "guest"));
        users.add(new com.sandbox.springcloud.configclient.customoauth.User("user2", "2", "admin", "guest"));
        users.add(new com.sandbox.springcloud.configclient.customoauth.User("user3", "3", "admin", "guest"));
        users.add(new com.sandbox.springcloud.configclient.customoauth.User("user4", "4", "admin", "guest"));
    }

    private void originUsers() {
        users.add(new org.springframework.security.core.userdetails.User("user1", "1", AuthorityUtils.createAuthorityList("admin", "guest")));
        users.add(new org.springframework.security.core.userdetails.User("user2", "2", AuthorityUtils.createAuthorityList("admin", "guest")));
        users.add(new org.springframework.security.core.userdetails.User("user3", "3", AuthorityUtils.createAuthorityList("admin", "guest")));
        users.add(new org.springframework.security.core.userdetails.User("user4", "4", AuthorityUtils.createAuthorityList("admin", "guest")));
    }

    public Optional<UserDetails> query(String userName) {
        return users.stream().filter(c -> c.getUsername().equals(userName)).findFirst();
    }
}
