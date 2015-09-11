import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Write a program to find how many times given string appears in given text as substring.
 */

public class Problem07CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        //Positive Lookahead is needed in regex to overlapp matches
        String patternString = "(?=("+scan.nextLine()+"))";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Integer counter = 0;
        while (matcher.find()){
            counter++;
        }

        System.out.println(counter);
    }
}
