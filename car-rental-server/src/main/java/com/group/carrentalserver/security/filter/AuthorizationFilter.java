package com.group.carrentalserver.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.group.carrentalserver.security.SecurityConstants.*;

public class AuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (authHeader == null || !authHeader.startsWith(TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.replace(TOKEN_PREFIX, "");

        Algorithm algorithm = Algorithm.HMAC256(SECRET.getBytes());
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        String username = decodedJWT.getSubject();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        decodedJWT.getClaim("roles").asList(String.class)
                .forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

        var authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
