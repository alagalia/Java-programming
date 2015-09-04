package JavaSyntax;

import java.util.Scanner;

public class P07CountOfBitsOne {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int a = scanner.nextInt();
        int result = Integer.bitCount(a);
        System.out.println(result);
    }
}
