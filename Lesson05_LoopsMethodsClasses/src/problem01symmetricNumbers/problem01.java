package problem01symmetricNumbers;
import org.apache.commons.lang.StringUtils;
/*
Write a program to generate and print all symmetric numbers in given range [start…end] (0 ? start ? end ? 999). A number is symmetric if its digits are symmetric toward its middle. For example, the numbers 101, 33, 989 and 5 are symmetric, but 102, 34 and 997 are not symmetric.
 */
import java.util.Scanner;

public class problem01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startFromInt = scan.nextInt();
        int endInt = scan.nextInt();
        for (int i = startFromInt; i <=endInt; i++) {
            String numAsString = Integer.toString(i);
            int stringSize= numAsString.length();
            int startIndexForRightSize = stringSize/2+stringSize%2;
            String leftSide = numAsString.substring(0, stringSize/2);
            String rightSide = numAsString.substring(startIndexForRightSize, numAsString.length());
            leftSide = reverseWords(leftSide);
            if (rightSide.equals(leftSide)){
                System.out.print(i+" ");
            }
        }
    }

    private static String reverseWords(String sentence) {
        return StringUtils.reverse(sentence);
    }
}
