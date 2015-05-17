import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lfsr extends Gen {
    int[] c = {1, 0, 1};
    List<Integer> listX = Arrays.asList(0, 1, 0);
    int p, current;

    public Lfsr(String vector) {
        String[] v = vector.split(":");
        String[] mas = v[1].split(",");
        c = new int[mas.length];
        p = mas.length;
        for (int i = 0; i < mas.length; i++) {
            c[i] = Integer.valueOf(mas[i]);
        }
        mas = v[2].split(",");
        listX = new ArrayList<Integer>();
        for (int i = 0; i < mas.length; i++) {
            listX.add(Integer.valueOf(mas[i]));
        }
        current = 0;
    }


    int nextBit() {
        int result = 0;
        for (int j = 0; j < p - 1; j++) {
            result = xor(result, (c[j] * listX.get(j + current)));
        }
        listX.add(result);
        current++;
        return result;
    }

    public int next() {
        int result = 0;
        for (int i = 0; i < 16; i++) {
            result = (result << 1) | (int) nextBit();
        }
        return result;
    }




    static String help() {
        return "/i:массив c,массив x(оба бинарные) (например /i:1,0,1:0,1,0)";
    }


    public static byte xor(int a, int b) {
        return (byte) ((a | b) - (a & b));
    }
}
