import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
/*
We are given a sequence of N playing cards from a standard deck. The input consists of several cards (face + suit), separated by a space. Write a program to calculate and print at the console the frequency of each card face in format "card_face -> frequency". The frequency is calculated by the formula appearances / N and is expressed in percentages with exactly 2 digits after the decimal point. The card faces with their frequency should be printed in the order of the card face's first appearance in the input. The same card can appear multiple times in the input, but it's face should be listed only once in the output.
 */
public class Problem12CardsFrequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] cards = text.split(" ");

        Map<String, Integer> map = new LinkedHashMap< >();
        for (String card : cards) {
            String  keyFace = card.substring(0,card.length()-1);
            if (map.keySet().contains(keyFace)){
                int quantity = map.get(keyFace);
                map.put(keyFace, quantity+1);
            } else {
                map.put(keyFace, 1);
            }
        }
        for (String key : map.keySet()) {
            double appearances = map.get(key);
            double frequency = appearances/cards.length*100;
            System.out.printf(key + " -> %.2f%%", frequency).println();
        }
    }
}
