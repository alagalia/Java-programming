import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
Write a program to find the most frequent word in a text and print it, as well as how many times it appears in format "word -> count". Consider any non-letter character as a word separator. Ignore the character casing. If several words have the same maximal frequency, print all of them in alphabetical order.
 */
public class Problem11MostFrequentWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        String[] words = text.split("\\W+");

        Map<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer value = map.get(word) + 1;
                map.put(word, value);
            } else {
                map.put(word, 1);
            }
        }

        int maxValueInMap=(Collections.max(map.values()));

        for (String s : map.keySet()) {
            if (map.get(s)== maxValueInMap) {
                System.out.println(s + " -> " + map.get(s));
            }
        }
    }
}
