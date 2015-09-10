import java.util.Arrays;
import java.util.Scanner;
/*Write a program that enters an array of strings and finds in it the largest sequence of equal elements. If several sequences have the same longest length, print the leftmost of them. The input strings are given as a single line, separated by a space.
 */
public class Problem03LargesSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = (scan.nextLine()).split(" ");
        Arrays.sort(input);

        Integer lenghtMaxSequence=1;
        Integer lenghtCuurentSequence =1;

        String maxWord=input[0];

        for (int i = 1; i < input.length; i++) {
            if (input[i].equals(input[i-1])) {
                lenghtCuurentSequence++;
                if (lenghtCuurentSequence>lenghtMaxSequence){
                    lenghtMaxSequence=lenghtCuurentSequence;
                    maxWord=input[i-1];
                }
            }else {
                lenghtCuurentSequence=1;
            }

        }
        for (int i = 0; i < lenghtMaxSequence; i++) {
            System.out.print(maxWord+" ");
        }
    }
}
