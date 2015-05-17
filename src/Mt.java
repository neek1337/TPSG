import java.util.ArrayList;
import java.util.Collections;

public class Mt extends Gen {
    int q, p, r, a, current;
    ArrayList<Integer> list;

    Mt(String vector) {
        String[] v = vector.split(":");
        current = 0;
        q = Integer.valueOf(v[1]);
        p = Integer.valueOf(v[2]);
        r = Integer.valueOf(v[3]);
        a = Integer.valueOf(v[4]);
        String[] mas = v[5].split(",");
        list = new ArrayList<Integer>();
        for (int i = 0; i < mas.length; i++) {
            list.add(Integer.valueOf(mas[i]));
        }
    }

    public static int shift(int a) {
        ArrayList<Byte> listA = convert(a);
        ArrayList<Byte> result = new ArrayList<Byte>();
        for (int i = listA.size() - 2; i >= 0; i--) {
            result.add(listA.get(i));
        }
        result.add(0, (byte) 0);
        return deconvert(result);
    }


    public static ArrayList<Byte> convert(int a) {
        ArrayList<Byte> result = new ArrayList<Byte>();
        while (a != 0) {
            result.add((byte) (a % 10 % 2));
            a = a / 2;
        }
        Collections.reverse(result);
        return result;
    }

    public static int deconvert(ArrayList<Byte> list) {
        int result = 0, v = 1;

        for (int i = 0; i < list.size(); i++) {
            result += v * list.get(list.size() - i - 1);
            v *= 2;
        }
        return result;
    }

    public static ArrayList<Byte> firstN(int a, int b, int r, int w) {
        ArrayList<Byte> bytesA = convert(a);
        bytesA = checkLength(bytesA, w);
        ArrayList<Byte> bytesB = convert(b);
        bytesB = checkLength(bytesB, w);
        ArrayList<Byte> result = new ArrayList<Byte>();
        int wr = bytesA.size() - r;

        for (int i = 0; i < wr; i++) {
            result.add(bytesA.get(i));
        }
        for (int i = wr; i < bytesB.size(); i++) {
            result.add(bytesB.get(i));
        }
        return result;
    }

    public static int xor(int a, int b) {
        return ((a | b) - (a & b));
    }

    public static ArrayList<Byte> checkLength(ArrayList<Byte> list, int w) {
        while (list.size() < w) {
            list.add(0, (byte) 0);
        }
        return list;
    }

    @Override
    int next() {
        int w = convert(list.get(0)).size();

        int local = xor(list.get(current + q), xor(shift(deconvert(firstN(list.get(current), list.get(current + 1), r, w))), a));

        list.add(current + p, local);
        current++;
        return local;
    }
    static String help(){
        return "/i:q,p,r,a,массив  (например /i:2:3:2:25:21,13,17,12,21,31)";
    }
}
