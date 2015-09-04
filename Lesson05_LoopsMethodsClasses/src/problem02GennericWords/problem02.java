package problem02GennericWords;

import java.util.Scanner;

/*Write a program to generate and print all 3-letter words consisting of given set of characters.
For example if we have the characters 'a' and 'b', all possible words will be "aaa", "aab", "aba", "abb", "baa", "bab", "bba" and "bbb".
The input characters are given as string at the first line of the input.
Input characters are unique (there are no repeating characters)./*
 */
public class problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        for (int i = 0; i < line.length(); i++) {
            for (int j = 0; j < line.length(); j++) {
                for (int k = 0; k < line.length(); k++) {
                     System.out.println(
                             Character.toString(line.charAt(i)) +
                             Character.toString(line.charAt(j)) +
                             Character.toString( line.charAt(k)));
                }
            }
        }
    }
}
