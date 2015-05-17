import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
    static final String nullString = "";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Info info = new Info(args);
        if (info.isHelp()) {
            System.out.println(new Helper(info.getMethod()));
            return;
        }
        Gen generator = null;
        if (info.getMethod().equals("add")) {
            generator = new Add(info.getVector());
        } else if (info.getMethod().equals("bbs")) {
            generator = new Bbs(info.getVector());
        } else if (info.getMethod().equals("lc")) {
            generator = new Lc(info.getVector());
        } else if (info.getMethod().equals("lfsr")) {
            generator = new Lfsr(info.getVector());
        } else if (info.getMethod().equals("mt")) {
            generator = new Mt(info.getVector());
        } else if (info.getMethod().equals("nfsr")) {
            generator = new Nfsr(info.getVector());
        } else if (info.getMethod().equals("5p")) {
            generator = new p5(info.getVector());
        } else if (info.getMethod().equals("rc4")) {
            generator = new Rc4(info.getVector());
        } else if (info.getMethod().equals("rsa")) {
            generator = new Rsa(info.getVector());
        }
        PrintWriter printWriter = new PrintWriter(info.getFileName());
        for (int i = 0; i < info.getN(); i++) {
            printWriter.print(generator.next() + " ");
            printWriter.flush();
        }

    }

}


