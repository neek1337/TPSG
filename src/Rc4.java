import java.util.ArrayList;
import java.util.Collections;

public class Rc4 extends Gen {
    ArrayList<Integer> list, key;
    int current, j;

    Rc4(String vector) {
        String[] v = vector.split(":");
        String[] mas = v[1].split(",");
        key = new ArrayList<Integer>();
        for (int i = 0; i < mas.length; i++) {
            key.add(Integer.valueOf(mas[i]));
        }

        list = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            list.add(i);
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + list.get(i) + key.get(i)) % 256;
            Collections.swap(list, i, j);
        }

        current = 0;
        j = 0;

    }

    @Override
    int next() {
        current = (current + 1) % 256;
        j = (j + list.get(current)) % 256;
        Collections.swap(list, current, j);
        int t = (list.get(current) + list.get(j)) % 256;
        int k = list.get(t);
        return k;
    }

    static String help() {
        return "/i:256 значений ключа (например /i:1,2...,256)";
    }
}
