import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem05CountAllWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter some text:");
        String text =scan.nextLine();
        Pattern word = Pattern.compile("\\w+");
        Matcher matcher = word.matcher(text);
        Integer counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println(counter);

    }

}
