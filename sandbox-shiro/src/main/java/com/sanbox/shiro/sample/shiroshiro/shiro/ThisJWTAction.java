package com.sanbox.shiro.sample.shiroshiro.shiro;

import com.aio.portable.swiss.autoconfigure.properties.JWTClaims;
import com.aio.portable.swiss.suite.security.authentication.jwt.JWTAction;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ThisJWTAction implements JWTAction {
    @Override
    public JWTClaims toJWTClaims() {
        return null;
    }

    @Override
    public String sign(JWTCreator.Builder builder) {
        return null;
    }

    @Override
    public DecodedJWT parse(String token) {
        return new DecodedJWT() {
            @Override
            public String getIssuer() {
                return token.substring(0, 1);
            }

            @Override
            public String getSubject() {
                return null;
            }

            @Override
            public List<String> getAudience() {
                return null;
            }

            @Override
            public Date getExpiresAt() {
                return null;
            }

            @Override
            public Date getNotBefore() {
                return null;
            }

            @Override
            public Date getIssuedAt() {
                return null;
            }

            @Override
            public String getId() {
                return null;
            }

            @Override
            public Claim getClaim(String s) {
                return null;
            }

            @Override
            public Map<String, Claim> getClaims() {
                return null;
            }

            @Override
            public String getAlgorithm() {
                return null;
            }

            @Override
            public String getType() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public String getKeyId() {
                return null;
            }

            @Override
            public Claim getHeaderClaim(String s) {
                return null;
            }

            @Override
            public String getToken() {
                return null;
            }

            @Override
            public String getHeader() {
                return null;
            }

            @Override
            public String getPayload() {
                return null;
            }

            @Override
            public String getSignature() {
                return null;
            }
        };

    }

    @Override
    public Boolean verify(String token) {
        return this.parse(token) != null;
    }
}
