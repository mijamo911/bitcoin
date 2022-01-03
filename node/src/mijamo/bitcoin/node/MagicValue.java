package mijamo.bitcoin.node;

import org.bouncycastle.util.Bytes;

import java.io.IOException;
import java.io.OutputStream;

public enum MagicValue {
    MAIN(0xD9B4BEF9),
    TESTNET(0xDAB5BFFA),
    TESTNET3(0x0709110B),
    SIGNET(0x40CF030A),
    NAMECOIN(0xFEB4BEF9);

    private final int magicValue;

    MagicValue(int magicValue) {
        this.magicValue = magicValue;
    }

    public int intValue() {
        return magicValue;
    }

    public void toBytes(OutputStream s) {
        try {
            s.write(magicValue & 0xFF);
            s.write((magicValue >> 8) & 0xFF);
            s.write((magicValue >> 16) & 0xFF);
            s.write((magicValue >> 24) & 0xFF);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
