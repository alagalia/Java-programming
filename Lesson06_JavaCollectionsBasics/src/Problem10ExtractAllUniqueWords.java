import java.util.*;
/*
At the first line at the console you are given a piece of text. Extract all words from it and print them in alphabetical order. Consider each non-letter character as word separator. Take the repeating words only once. Ignore the character casing. Print the result words in a single line, separated by spaces.
 */
public class Problem10ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine().toLowerCase();

        List<String> words = new ArrayList<>(Arrays.asList(text.split("\\W")));
        Set<String> orderedWords = new TreeSet<>(words);

        System.out.println(String.join(" ", orderedWords));

    }
}


