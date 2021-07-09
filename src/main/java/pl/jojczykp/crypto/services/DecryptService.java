package pl.jojczykp.crypto.services;

import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Singleton
public class DecryptService {

    public String decrypt(String encryptedString) {
        byte[] decryptedBytes = Base64.getDecoder().decode(encryptedString);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
