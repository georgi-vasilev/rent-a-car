package com.group.carrentalserver.util;

import lombok.experimental.UtilityClass;

import java.util.Calendar;
import java.util.Date;

@UtilityClass
public final class VerificationTokenUtil {

    private static final int TOKEN_EXPIRATION_MINUTES = 60 * 24;

    private VerificationTokenUtil() {
        // static content only
    }

    public static Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, TOKEN_EXPIRATION_MINUTES);
        return new Date(cal.getTime().getTime());
    }
}
