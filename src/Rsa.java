import java.math.BigInteger;

public class Rsa extends Gen {
    BigInteger p, q, n, e, x;

    Rsa(String vector) {
        String[] v = vector.split(":");
        p = new BigInteger(v[1]);
        q = new BigInteger(v[2]);
        e = new BigInteger(v[3]);
        x = new BigInteger(v[4]);
        n = p.multiply(q);
    }

    public byte lastBite() {
        x = x.modPow(e, n);
        if (x.testBit(0)) {
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    int next() {
        int result = 0;
        for (int i = 0; i < 16; i++) {
            result = (result << 1) | lastBite();
        }
        return result;
    }

    static String help() {
        return "/i:p:q:e:x";
    }
}
