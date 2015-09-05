package problem03FullHouse;

/*
In most Poker games, the "full house" hand is defined as three cards of the same face + two cards of the same face, other than the first, regardless of the card's suits. The cards faces are "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" and "A". The card suits are "♣", "♦", "♥" and "♠". Write a program to generate and print all full houses and print their number.
 */
public class problem03 {
    public static void main(String[] args) {
        generateFullHouse();
    }

    private static void generateFullHouse() {
        int counter = 0;
        String[] faces = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        char[] suits = new char[]{'\u2663','\u2660','\u2665','\u2666'};
        for (int i = 0; i < 13; i++) {
            for (int j = i+1; j < 13; j++) {

                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            for (int n = 0; n < 4; n++) {
                                for (int o = 0; o <4 ; o++) {
                                    StringBuilder output = new StringBuilder();
                                    output.append("("+
                                            faces[i]+suits[k] + " " +
                                            faces[i]+suits[l] + " " +
                                            faces[i]+suits[m] + " " +
                                            faces[j]+suits[n] + " " +
                                            faces[j]+suits[o] + ")");
                                    System.out.println(output);
                                    counter++;
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }

}
