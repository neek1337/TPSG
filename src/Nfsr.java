public class Nfsr extends Gen {
    Lfsr g1, g2, g3;

    Nfsr(String vector) {
        String[] v = vector.split(":");
        g1 = new Lfsr(" :" + v[1] + ":" + v[2]);
        g2 = new Lfsr(" :" + v[3] + ":" + v[4]);
        g3 = new Lfsr(" :" + v[5] + ":" + v[6]);

    }

    @Override
    int next() {
        int x1 = g1.next();
        int x2 = g2.next();
        int x3 = g3.next();
        int result = (x1 & x2) ^ (x2 & x3) ^ x3;
        return result;
    }

    static String help() {
        return "/i:инициализационный масси для первого lfsr:инициализационный масси для второго lfsr:инициализационный масси для третьего lfsr  /i:0,0,1:0,1,0:1,1,1:0,1,1:1,0,0:1,1,0)";
    }
}
