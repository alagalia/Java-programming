package problem06RandomHandsOf5Cards;
/*
Write a program to generate n random hands of 5 different cards form a standard suit of 52 cards
 */
import java.util.Random;
import java.util.Scanner;

public class problem06 {
    public static void main(String[] args) {
        String[] faces = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        char[] suits = new char[]{'\u2663','\u2660','\u2665','\u2666'};
        Scanner scan = new Scanner(System.in);
        int loop = scan.nextInt();
        for (int i = 0; i < loop; i++) {
            System.out.println(produceString(faces,suits));
        }
    }

    private static String produceString(String[] faces, char[] suits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(faces[fsR()]+suits[ssR()] +" ");
        }
        return sb.toString();
    }

    private static int ssR() {
        Random rnd = new Random();
        return rnd.nextInt(4);
    }

    private static int fsR() {
        Random rnd = new Random();
        return rnd.nextInt(13);
    }
}
