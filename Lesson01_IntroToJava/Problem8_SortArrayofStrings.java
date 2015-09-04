package Intro;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Problem8_SortArrayofStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number for the length of array:");
        int n = scanner.nextInt();
        String[] words = new String[n];
        System.out.printf("Enter %d words:" , n);
        for (int i = 0; i < n; i++) {
            words[i]=scanner.next();
        }
        Arrays.sort(words);
        for (int i = 0; i <n ; i++) {
            System.out.println(words[i]);
        }
    }
}
