package br.com.flarom.passport.classes;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MiscTools {
    private static final SecureRandom random = new SecureRandom();
    public String getRandomPassword(int length, boolean useLowerCase, boolean useUpperCase, boolean useNumbers, boolean useSpecial) {
        StringBuilder passwordPool = new StringBuilder();
        
        if (useLowerCase) passwordPool.append("abcdefghijklmnopqrstuvwxyz");
        if (useUpperCase) passwordPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (useNumbers) passwordPool.append("1234567890");
        if (useSpecial) passwordPool.append("!@#$%&*-_");

        if (passwordPool.length() == 0) {
            return null;
        }

        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordPool.length());
            password.append(passwordPool.charAt(index));
        }

        return password.toString();
    }
    
    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }
    
    public static String encryptPassword(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedText = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }
    
    public static String decryptPassword(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedText);
    }
}
