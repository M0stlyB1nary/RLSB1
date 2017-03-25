package tech.lander.Util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;


/**
 * Created by rory on 3/24/17.
 */

public class DCUtil {

    private Cipher cipher;

    public DCUtil() throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.cipher = Cipher.getInstance("RSA");
    }

    public String decryptText(String msg, String publicKeyLocation)
            throws InvalidKeyException, UnsupportedEncodingException,
            IllegalBlockSizeException, BadPaddingException {
        try {
            PublicKey key = getPublic(publicKeyLocation);
            this.cipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(cipher.doFinal(Base64.decodeBase64(msg)), "UTF-8");
    }

    private PublicKey getPublic(String publicKeyLocation) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(publicKeyLocation).toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
}

