package JavaSyntax;

import java.util.Scanner;

public class P05DecimalToHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scanner.nextInt();
        String hex = Integer.toHexString(num).toUpperCase();
        System.out.println(hex);
    }
}
