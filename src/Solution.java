import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        if (args[0].equals("/h")){
                System.out.println("/g: - method (valid values:lc,add,5p,Lfsr,nfsr,mt,rc4,rsa,bbs) \n /i: - inicial vector \n /n: - number of gen digits \n /f: - filename \n /h - help");
            }
            if (args[0].equals("/g:lc")) {
                String[] v = new String[6];
                int n = 10000;
                int m = 7;
                int a = 2;
                int c = 4;
                int x0 = 1;
                String filename = "rnd.dat";
                boolean flag = false;

                for (int i = 1; i < args.length; i++) {
                    String[] local = args[i].split(":");
                    if (local[0].equals("/i")) {
                        v = local;
                        flag = true;
                    }
                    if (local[0].equals("/n")) {
                        n = Integer.valueOf(local[1]);
                    }
                    if (local[0].equals("/f")) {
                        filename = local[1];
                    }
                    if (args[i].equals("/h")) {
                        System.out.println("/i:m:a:c:x0");
                    }
                }
                PrintWriter printWriter = new PrintWriter(filename);
                if (flag) {
                    m = Integer.valueOf(v[1]);
                    a = Integer.valueOf(v[2]);
                    c = Integer.valueOf(v[3]);
                    x0 = Integer.valueOf(v[4]);
                }
                System.out.println("Processing..");
                for (int i = 0; i < n; i++) {
                    printWriter.write(x0 + " ");
                    printWriter.flush();
                    int x = generator1(m, x0, a, c);
                    x0 = x;
                }

            }


            if (args[0].equals("/g:add")) {
                String[] v = new String[6];
                int n = 10000;
                int m = 7;
                int x0 = 0;
                int x1 = 1;
                String filename = "rnd.dat";
                boolean flag = false;

                for (int i = 1; i < args.length; i++) {
                    String[] local = args[i].split(":");
                    if (local[0].equals("/i")) {
                        v = local;
                        flag = true;
                    }
                    if (local[0].equals("/n")) {
                        n = Integer.valueOf(local[1]);
                    }
                    if (local[0].equals("/f")) {
                        filename = local[1];
                    }
                    if (args[i].equals("/h")) {
                        System.out.println("/i:m:x0:x1");
                    }
                }
                PrintWriter printWriter = new PrintWriter(filename);
                if (flag) {
                    m = Integer.valueOf(v[1]);
                    x0 = Integer.valueOf(v[2]);
                    x1 = Integer.valueOf(v[3]);
                }
                System.out.println("Processing..");
                for (int i = 0; i < n; i++) {
                    printWriter.write(x0 + " " + x1 + " ");
                    printWriter.flush();
                    int x = generator2(m, x1, x0);
                    x1 = x;
                    x0 = x1;

                }
            }


            if (args[0].equals("/g:5p")) {
                String filename = "rnd.dat";
                boolean flag = false;
                String[] v = new String[6];
                int p = 10;
                int q1 = 2;
                int q2 = 4;
                int q3 = 6;
                int w = 4;
                int n = 10000;
                List<Integer> listX = Arrays.asList(5, 6, 7, 8, 17, 23, 67, 38, 88, 99);
                for (int i = 1; i < args.length; i++) {
                    String[] local = args[i].split(":");
                    if (local[0].equals("/i")) {
                        v = local;
                        flag = true;
                    }
                    if (local[0].equals("/n")) {
                        n = Integer.valueOf(local[1]);
                    }
                    if (local[0].equals("/f")) {
                        filename = local[1];
                    }
                    if (args[i].equals("/h")) {
                        System.out.println("/i:q:q1:q2:q3:w:x0,x1,...,xn");
                    }
                }
                PrintWriter printWriter = new PrintWriter(filename);
                if (flag) {
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

                System.out.println("Processing..");

                for (int i = 0; i < 100; i++) {
                    int result = xor(listX.get(i), listX.get(i + q1), listX.get(i + q2), listX.get(i + q3));
                    listX.add(i + p, result);
                    if (result > Math.pow(2, w - 1) && result < Math.pow(2, w)) {
                        printWriter.write(result + " ");
                        printWriter.flush();
                    } else {
                        List<Integer> local = convert(result);
                        for (int j = 0; j < w - local.size() + 1; j++) {
                            local.add(0, 0);
                        }
                        local = local.subList(local.size() - w, local.size());
                        int c = 1;
                        result = 0;
                        for (int j = 0; j < w; j++) {
                            result += local.get(j) * c;
                            c *= 2;
                        }
                        printWriter.write(result + " ");
                        printWriter.flush();
                    }

                }
            }



            if (args[0].equals("/g:Lfsr")) {
                String filename = "rnd.dat";
                int n = 1000;
                boolean flag = false;
                String[] v = new String[6];
                int p = 4;
                int[] c = {1, 0, 1};
                List<Integer> listX = Arrays.asList(0, 1, 0);
                for (int i = 1; i < args.length; i++) {
                    String[] local = args[i].split(":");
                    if (local[0].equals("/i")) {
                        v = local;
                        flag = true;
                    }
                    if (local[0].equals("/n")) {
                        n = Integer.valueOf(local[1]);
                    }
                    if (local[0].equals("/f")) {
                        filename = local[1];
                    }
                    if (args[i].equals("/h")) {
                        System.out.println("/i:c0,c1,...cn:x1,...,xn (all values are binary)");
                    }
                }
                PrintWriter printWriter = new PrintWriter(filename);
                if (flag) {
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
                }

                for (int i = 0; i < 100; i++) {
                    int result = 0;
                    for (int j = 0; j < p - 1; j++) {
                        result = xor(result, (c[j] * listX.get(j + i)));
                    }
                    System.out.println(result);
                    printWriter.write(result + " ");
                    printWriter.flush();
                    listX.add(result);
                }
            }


        }

    public static int generator1(int m, int x0, int a, int c) {
        return (a * x0 + c) % m;
    }

    public static int generator2(int m, int xi, int xi1) {
        return (xi + xi1) % m;
    }

    public static int xor(int a, int b) {
        return (a | b) - (a & b);
    }

    public static int xor(int a, int b, int c, int d) {
        return xor(xor(a, b), xor(c, d));
    }

    public static byte xor(byte a, byte b) {
        return (byte) ((a | b) - (a & b));
    }

    public static ArrayList<Integer> convert(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (a != 0) {
            result.add(a % 10 % 2);
            a = a / 2;
        }
        Collections.reverse(result);
        return result;
    }
}