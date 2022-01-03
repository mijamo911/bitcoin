package mijamo.bitcoin.node;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Hashes {
    private Hashes() {}

    public static byte[] sha256Ripemd160(byte[] b) {
        MessageDigest sha256 = MessageDigests.getInstanceQuietly(Algorithms.SHA_256);
        MessageDigest ripemd160 = MessageDigests.getInstanceQuietly(Algorithms.RIPEMD_160);
        byte[] first = sha256.digest(b);
        byte[] second = ripemd160.digest(first);
        return second;
    }

    public static byte[] doubleSha256(byte[] b) {
        MessageDigest sha256 = MessageDigests.getInstanceQuietly(Algorithms.SHA_256);
        byte[] first = sha256.digest(b);
        byte[] second = sha256.digest(first);
        return second;
    }

    private static final class Algorithms {
        // https://docs.oracle.com/javase/9/docs/specs/security/standard-names.html#messagedigest-algorithms
        public static final String SHA_256 = "SHA-256";
        public static final String RIPEMD_160 = "RipeMD160";
    }

    private static final class MessageDigests {
        public static MessageDigest getInstanceQuietly(String algorithm) {
            try {
                return MessageDigest.getInstance(algorithm);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
