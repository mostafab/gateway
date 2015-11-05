package controller.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Mostafa on 9/30/2015.
 * Class responsible for taking in strings and encoding them
 * and taking in ciphers and decoding them. Uses a DES algorithm
 * and BASE64 encoding with a key to create the cipher.
 */

public class Encoder {

    private static final String secret = "There's Always Money In The Banana Stand";
    private static Encoder instance = new Encoder();

    private DESKeySpec keySpec;
    private SecretKeyFactory keyFactory;
    private SecretKey key;
    private Cipher cipher;
    private BASE64Encoder encoder;
    private BASE64Decoder decoder;

    /**
     * Creates an Encoder object using the static secret field
     * and instantiates the needed instance variables.
     */
    private Encoder() {
        try {
            keySpec = new DESKeySpec(secret.getBytes("UTF8"));
            keyFactory = SecretKeyFactory.getInstance("DES");
            key = keyFactory.generateSecret(keySpec);
            encoder = new BASE64Encoder();
            decoder = new BASE64Decoder();
            cipher = Cipher.getInstance("DES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the static Encoder instance
     * @return Encoder object
     */
    public static Encoder getInstance() {
        return instance;
    }

    /**
     * Method reponsible for taking in a plaintext string and
     * encoding it into a BASE64 cipher
     * @param plaintext text to be encoded
     * @return String representation of the ciphertext
     */
    public String encode(String plaintext) {
        try {
            byte[] ptArr = plaintext.getBytes("UTF8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return encoder.encode(cipher.doFinal(ptArr));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method responsible for taking in a encoded ciphertext and
     * decoding into an understandable String
     * @param ciphertext text to be decoded
     * @return String representation of the original plaintext
     */
    public String decode(String ciphertext) {
        try {
            byte[] ctArr = decoder.decodeBuffer(ciphertext);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainTextBytes = cipher.doFinal(ctArr);
            String plaintext = new String(plainTextBytes, "UTF-8");
            return plaintext;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }



}
