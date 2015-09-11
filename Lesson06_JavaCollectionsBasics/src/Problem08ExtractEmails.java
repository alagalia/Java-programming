/*
Write a program to extract all email addresses from given text. The text comes at the first input line. Print the emails in the output, each at a separate line. Emails are considered to be in format <user>@<host>
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem08ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<=\\s|^)([a-z0-9]+(?:[_.-][a-z0-9]+)*@[a-z]+\\-?[a-z]+(?:\\.[a-z]+)+)\\b");
        Matcher matcher=pattern.matcher(inputText);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
