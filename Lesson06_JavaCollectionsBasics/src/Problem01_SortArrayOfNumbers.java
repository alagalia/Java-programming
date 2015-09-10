import java.util.Arrays;
import java.util.Scanner;
/*
Write a program to enter a number n and n integer numbers and sort and print them. Keep the numbers in array of integers: int[].
 */
public class Problem01_SortArrayOfNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            Integer num = scan.nextInt();
            numbers[i]=num;
        }
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
