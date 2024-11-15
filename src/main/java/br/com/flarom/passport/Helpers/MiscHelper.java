package br.com.flarom.passport.Helpers;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class MiscHelper {

    private static final SecureRandom random = new SecureRandom();

    public static String getRandomPassword(int length, boolean useLowerCase, boolean useUpperCase, boolean useNumbers, boolean useSpecial) {
        StringBuilder passwordPool = new StringBuilder();

        if (useLowerCase) {
            passwordPool.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (useUpperCase) {
            passwordPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (useNumbers) {
            passwordPool.append("1234567890");
        }
        if (useSpecial) {
            passwordPool.append("!@#$%&*-_");
        }

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

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 10000;
    private static final int KEY_SIZE = 256;
    private static final int IV_SIZE = 16;
    private static final String defaultpassword = "772528088";

    private static SecretKeySpec generateAESKey(String password) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), password.getBytes(), ITERATIONS, KEY_SIZE);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(HASH_ALGORITHM);
        byte[] derivedKey = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(derivedKey, "AES");
    }

    public static String encryptPassword(String text) throws Exception {
        SecretKeySpec aesKey = generateAESKey(defaultpassword);

        byte[] iv = new byte[IV_SIZE];
        Arrays.fill(iv, (byte) 0);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivParameterSpec);

        byte[] encryptedText = cipher.doFinal(text.getBytes("UTF-8"));

        String textWithIV = Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(encryptedText);
        return textWithIV;
    }

    public static String decryptPassword(String encryptedText) throws Exception {
        String[] parts = encryptedText.split(":");
        byte[] iv = Base64.getDecoder().decode(parts[0]);
        byte[] encryptedData = Base64.getDecoder().decode(parts[1]);

        SecretKeySpec aesKey = generateAESKey(defaultpassword);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);

        byte[] decryptedText = cipher.doFinal(encryptedData);
        return new String(decryptedText, "UTF-8");
    }

    public static Color stringToColor(String colorString) {
        if (colorString != null && colorString.startsWith("#") && colorString.length() == 7) {
            try {
                int rgb = Integer.parseInt(colorString.substring(1), 16);
                return new Color(rgb);
            } catch (NumberFormatException e) {
                System.err.println("Error converting string to color: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Invalid color format: " + colorString);
            return null;
        }
    }

    public static String colorToString(Color color) {
        if (color == null) {
            return null;
        }
        int rgb = color.getRGB() & 0xFFFFFF;
        return String.format("#%06X", rgb);
    }
}
