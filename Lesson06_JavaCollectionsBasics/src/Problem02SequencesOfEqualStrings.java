import java.util.Scanner;
/*
Write a program that enters an array of strings and finds in it all sequences of equal elements. The input strings are given as a single line, separated by a space.
 */
public class Problem02SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = (scan.nextLine()).split(" ");
        System.out.print(input[0]);

        for (int i = 1; i < input.length; i++) {

            if (input[i].equals(input[i - 1])) {

                System.out.print(" " + input[i]);

            } else {

                System.out.println();
                System.out.print(input[i]);

            }
        }
    }

}
