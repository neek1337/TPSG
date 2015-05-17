import java.util.ArrayList;
import java.util.List;

public class p5 extends Gen {
    int p;
    int q1;
    int q2;
    int q3;
    int w;
    int current = 0;
    List<Integer> listX;

    public p5(String vector) {
        String[] v = vector.split(":");
        p = Integer.valueOf(v[1]);
        q1 = Integer.valueOf(v[2]);
        q2 = Integer.valueOf(v[3]);
        q3 = Integer.valueOf(v[4]);
        w = Integer.valueOf(v[5]);
        listX = new ArrayList<Integer>();
        String[] mas = v[6].split(",");
        for (int i = 0; i < mas.length; i++) {
            listX.add(Integer.valueOf(mas[i]));
        }

    }

    @Override
    int next() {
        int result = xor(listX.get(current), listX.get(current + q1), listX.get(current + q2), listX.get(current + q3));
        result = (int) (result & ((1L << w) - 1L));
        listX.add(current + p, result);
        current++;
        return result;
    }

    static String help(){
        return "/i:p,q1,,q2,q3,w,массив значений (например /i:10:2:4:6:4:5,6,7,8,17,23,67,38,88,99)";
    }
    public static byte xor(int a, int b) {
        return (byte) ((a | b) - (a & b));
    }

    public static int xor(int a, int b, int c, int d) {
        return xor(xor(a, b), xor(c, d));
    }


}
