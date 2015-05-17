import java.util.ArrayList;

public class Add extends Gen {
    int m;
    int k, j;
    ArrayList<Integer> x;

    public Add(String vector) {
        String[] v = vector.split(":");
        this.m = Integer.valueOf(v[1]);
        this.k = Integer.valueOf(v[2]);
        this.j = Integer.valueOf(v[3]);
        String[] mas = v[4].split(",");
        x = new ArrayList<Integer>();
        for (int i = 0; i < mas.length; i++) {
            x.add(Integer.valueOf(mas[i]));
        }

    }

    @Override
    public int next() {
        int next = (x.get(x.size() - k) + x.get(x.size() - j)) % m;
        x.add(next);
        return next;
    }

    public static String help() {
        return "/i:m:k:j:массив значений " + "(например /i:23:13:19:1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16," +
                "17,18,19,20,21,22,23)";
    }
}
