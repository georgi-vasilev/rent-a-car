package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.entity.VerificationToken;
import com.group.carrentalserver.service.base.IBaseService;

import java.util.Optional;

/**
 * Interface to a {@link VerificationToken} service.
 */
public interface IVerificationTokenService extends IBaseService<VerificationToken> {
    void createVerificationToken(User user, String token);

    Optional<VerificationToken> getVerificationToken(String token);
}
