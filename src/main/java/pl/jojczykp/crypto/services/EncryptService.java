package pl.jojczykp.crypto.services;

import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Singleton
public class EncryptService {

    public String encrypt(String decryptedString) {
        byte[] dataBytes = decryptedString.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(dataBytes);
    }
}
