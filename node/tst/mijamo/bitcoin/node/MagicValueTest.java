package mijamo.bitcoin.node;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertArrayEquals;

public class MagicValueTest {
    @Test
    public void writesInLittleEndian() {
        ByteArrayOutputStream s = new ByteArrayOutputStream(4);
        MagicValue.MAIN.toBytes(s);
        assertArrayEquals(s.toByteArray(), bytes(0xF9, 0xBE, 0xB4, 0xD9));
    }

    private static byte[] bytes(int... bytes) {
        byte[] b = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            b[i] = (byte) (bytes[i] & 0xFF);
        }
        return b;
    }
}
