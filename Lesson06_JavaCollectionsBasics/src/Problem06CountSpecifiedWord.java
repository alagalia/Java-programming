import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Write a program to find how many times a word appears in given text. The text is given at the first input line. The target word is given at the second input line. The output is an integer number. Please ignore the character casing. Consider that any non-letter character is a word separator.
 */
public class Problem06CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String patternString = "("+scan.nextLine()+")\\W";

        Pattern word = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

        Matcher matcher = word.matcher(input);

        Integer counter =0;
        while (matcher.find()){
            if(matcher.group(1)!=null){
                counter++;
            }
        }
        System.out.println(counter);
    }
}