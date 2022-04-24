package com.sandbox.springcloud.configclient.common;

public interface AuthorizedGrantTypeEnum {
    String AUTHORIZATION_CODE = "authorization_code";
    String REFRESH_TOKEN = "refresh_token";
    String PASSWORD = "password";
    String IMPLICIT = "implicit";
}
