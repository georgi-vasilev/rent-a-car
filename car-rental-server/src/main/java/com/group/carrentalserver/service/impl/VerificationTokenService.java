package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.entity.VerificationToken;
import com.group.carrentalserver.repository.VerificationTokenRepository;
import com.group.carrentalserver.service.IVerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class VerificationTokenService implements IVerificationTokenService {
    private final VerificationTokenRepository tokenRepository;

    public VerificationTokenService(VerificationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void createVerificationToken(User user, String token) {
        this.save(new VerificationToken(user, token));
    }

    @Override
    public Optional<VerificationToken> getVerificationToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public JpaRepository<VerificationToken, Integer> getJpaRepository() {
        return tokenRepository;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public Class<?> getType() {
        return VerificationToken.class;
    }
}
