public class Info {
    private String method;
    private String vector;
    private int n;
    private String fileName;
    private boolean help;

    Info() {
        method = Main.nullString;
        vector = Main.nullString;
        n = 1000;
        help = false;
        fileName = "rnd.dat";
    }

    public String getMethod() {
        return method;
    }

    public String getVector() {
        return vector;
    }

    public int getN() {
        return n;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isHelp() {
        return help;
    }

    public Info(String[] args) {
        this();
        try {
            for (int i = 0; i < args.length; i++) {
                String[] local = args[i].split(":");
                if (local[0].equals("/g")) {
                    method = local[1];
                } else {
                    if (local[0].equals("/i")) {
                        this.vector = args[i];

                    } else {
                        if (local[0].equals("/n")) {
                            n = Integer.valueOf(local[1]);

                        } else {
                            if (local[0].equals("/f")) {
                                fileName = local[1];

                            } else {
                                if (args[i].equals("/h")) {
                                    help = true;

                                }else{
                                    throw new IllegalArgumentException("Введены неверные данные");
                                }
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
