package com.sandbox.springcloud.configclient.defaultoauth;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository("com.sandbox.demo.defaultoauth.UserRepository")
public class UserRepository {
    private final static Set<User> users = new HashSet<User>();

    static {
        users.add(new User("user1", "1", AuthorityUtils.createAuthorityList("admin", "guest")));
        users.add(new User("user2", "2", AuthorityUtils.createAuthorityList("admin", "guest")));
        users.add(new User("user3", "3", AuthorityUtils.createAuthorityList("admin", "guest")));
        users.add(new User("user4", "4", AuthorityUtils.createAuthorityList("admin", "guest")));
    }

    public Optional<User> query(String userName) {
        return users.stream().filter(c -> c.getUsername().equals(userName)).findFirst();
    }
}
