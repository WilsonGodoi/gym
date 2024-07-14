package com.will.gym.utils.security;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class JwtUtils {

    @ConfigProperty(name = "JWT_ISSUER")
    String jwtIssuer;

    public String generateToken(String firstName, String email) {
        return Jwt.issuer(jwtIssuer)
                .subject(email)
                .preferredUserName(firstName)
                .expiresAt(33266026003L)
                .sign();
    }
}
