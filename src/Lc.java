public class Lc extends Gen {
    int m, a, c, x0;

    public Lc(String vector) {
        String[] v = vector.split(":");
        this.m = Integer.valueOf(v[1]);
        this.a = Integer.valueOf(v[2]);
        this.c = Integer.valueOf(v[3]);
        this.x0 = Integer.valueOf(v[4]);
    }

    public int next() {
        x0 = (a * x0 + c) % m;
        return x0;
    }
    public static String help(){
        return "/i:m:a:c:x0 "+"(например /i:55:13:19:5)";
    }
}
