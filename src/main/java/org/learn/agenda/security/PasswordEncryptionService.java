package org.learn.agenda.security;

import com.google.common.hash.Hashing;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Teodora Bobirneci
 */
@Service
public final class PasswordEncryptionService implements PasswordEncoder {

    @Override
    public String encodePassword(String rawPass, Object salt) {
        return Hashing.sha512().hashString(salt + rawPass, UTF_8).toString();
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        return encPass.equals(encodePassword(rawPass, salt));
    }

    public static String generateRandomSalt() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }
}
