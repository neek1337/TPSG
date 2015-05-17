public class Helper {
    public String method;

    public Helper(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        if (method.equals("")) {
            return "Допустимые ключи:\n" +
                    "   /g:<Код метода> - метод генерации. Один из следующих:\n" +
                    "      -lc - линейный конгруэнтный метод;\n" +
                    "      -add - аддитивный метод;\n" +
                    "      -5p - пятипараметрический метод;\n" +
                    "      -Lfsr - РСЛОС;\n" +
                    "      -nfsr - нелинейная комбинация РСЛОС;\n" +
                    "      -mt - вихрь Мерсенна;\n" +
                    "      -rc4 - RC4;\n" +
                    "      -rsa - ГПСЧ на основе RSA;\n" +
                    "      -bbs - алгоритм Блюма-Блюма-Шуба;\n\n" +
                    "   /i:<числа, вводимые через : или ,> - инициализационный вектор. Формат" +
                    " инициализационного вектора для конкретного метода можно узнать следующим образом;" +
                    "/g:<Имя интересующего метода> /h;\n\n" +
                    "   /n:<Число> - количество генерируемых чисел (по умолчанию 10000);\n\n" +
                    "   /f:<Полное имя файла> - полное имя файла, в который будут выводиться данные (по " +
                    "умолчанию rnd.dat);\n\n" +
                    "   /h - информация о допустимых значениях.\n";
        } else if (method.equals("lc")) {
            return Lc.help();
        } else if (method.equals("add")) {
            return Add.help();
        } else if (method.equals("5p")) {
            return p5.help();
        } else if (method.equals("lfar")) {
            return Lfsr.help();
        } else if (method.equals("nfsr")) {
            return Nfsr.help();
        } else if (method.equals("mt")) {
            return Mt.help();
        } else if (method.equals("rc4")) {
            return Rc4.help();
        } else if (method.equals("rsa")) {
            return Rsa.help();
        } else if (method.equals("bbs")) {

        }
        return "";
    }
}
