package JavaSyntax;

import java.util.Scanner;

public class P08CountOFEqualBitPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int counter1=0;
        int counter0=0;
        while (num!=0){
            int numForCheck = num & 3;
            if (numForCheck == 3){
                counter1++;
            }
            if (numForCheck ==0){
                counter0++;
            }
            num = num >> 1;
        }
        System.out.printf("Equal zero-bit pairs are: %d", counter0);
        System.out.println();
        System.out.printf("Equal one-bit pairs are: %d", counter1);
        System.out.println();
        System.out.println("Total: " + (counter0+counter1));
    }
}
