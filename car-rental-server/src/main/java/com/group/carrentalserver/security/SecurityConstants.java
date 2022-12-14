package com.group.carrentalserver.security;

/**
 * Class containing security constants.
 */
public final class SecurityConstants {

    private SecurityConstants() {
        // Static content only
    }

    public static final String SECRET = "mySecretKey";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER = "Authorization";
}
