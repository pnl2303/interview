import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số nguyên n:");
        String s = String.valueOf(input.nextInt());
        System.out.println(ChuyenSoThanhChu.readNumber(s));
    }
}

class ChuyenSoThanhChu {

    static String[] one_digit = {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
    static String[] units = {"", " mốt", " hai", " ba", " bốn", " lăm", " sáu", " bảy", " tám", " chín"};
    static String[] tens = {"linh", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi",
            "tám mươi", "chín mươi"};
    static String[] hundreds = {"không trăm", "một trăm", "hai trăm", "ba trăm", "bốn trăm", "năm trăm", "sáu trăm",
            "bảy trăm", "tám trăm", "chín trăm"};
    static String[] bigger = {"", " nghìn", " triệu", " tỉ", " nghìn tỉ", " triệu tỉ", " tỉ tỉ"};

    static String read_class(String s) {
        int n = Integer.parseInt(s);
        String _hundreds = hundreds[n / 100];
        String _tens = tens[(n / 10) % 10];
        String _units = units[n % 10];
        if (s.length() == 1)
            return one_digit[n];
        else if (s.length() == 2)
            return tens[n / 10] + _units;
        else {
            if (s == "000")
                return "";
            else if ((n / 10) % 10 == 0) {
                if (n % 10 == 0)
                    return _hundreds;
                else
                    return _hundreds + " " + _tens + " " + one_digit[n % 10];
            } else
                return _hundreds + " " + _tens + _units;
        }

    }

    public static String readNumber(String s) {
        ArrayList<String> classes = new ArrayList<String>();

        for (int i = s.length() - 1; i > 1; i = i - 3)
            classes.add(s.substring(i - 2, i + 1));

        if (s.length() % 3 != 0)
            classes.add(s.substring(0, s.length() % 3));

        String res = "";
        for (int i = 0; i < classes.size(); i++) {
            String named_class = read_class(classes.get(i));
            if (named_class != "")
                res = named_class + bigger[i] + " " + res;
        }
        return res;
    }
}