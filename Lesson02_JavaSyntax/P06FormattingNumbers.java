package JavaSyntax;

import java.util.Locale;
import java.util.Scanner;

public class P06FormattingNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();
        String aAsHex = Integer.toHexString(a).toUpperCase();
        int aAsBin = Integer.parseInt(Integer.toBinaryString(a));
        System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", a, aAsBin, b, c);
    }
}
