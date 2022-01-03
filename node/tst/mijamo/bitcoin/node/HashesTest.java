package mijamo.bitcoin.node;

import com.google.common.io.BaseEncoding;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.Security;

import static org.junit.Assert.assertEquals;

public class HashesTest {
    @BeforeClass
    public static void beforeClass() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void doubleSha256Hello() {
        byte[] hello = "hello".getBytes(StandardCharsets.UTF_8);
        byte[] hash = Hashes.doubleSha256(hello);
        assertEquals(
                "9595c9df90075148eb06860365df33584b75bff782a510c6cd4883a419833d50",
                BaseEncoding.base16().encode(hash).toLowerCase());
    }

    @Test
    public void sha256Ripemd160Hello() {
        byte[] hello = "hello".getBytes(StandardCharsets.UTF_8);
        byte[] hash = Hashes.sha256Ripemd160(hello);
        assertEquals(
                "b6a9c8c230722b7c748331a8b450f05566dc7d0f",
                BaseEncoding.base16().encode(hash).toLowerCase());
    }
}
