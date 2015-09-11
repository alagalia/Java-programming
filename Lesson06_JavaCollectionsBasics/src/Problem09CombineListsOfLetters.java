import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Write a program that reads two lists of letters l1 and l2 and combines them: appends all letters c from l2 to the end of l1, but only when c does not appear in l1. Print the obtained combined list. All lists are given as sequence of letters separated by a single space, each at a separate line. Use ArrayList<Character> of chars to keep the input and output lists.
 */
public class Problem09CombineListsOfLetters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String l1String = scanner.nextLine();
        String l2String = scanner.nextLine();

        List<Character> l1 = convertStringToArraylist(l1String);
        List<Character> l2 = convertStringToArraylist(l2String);
        List<Character> temp = new ArrayList<>();
        for (Character ch : l2 ) {
            if (!l1.contains(ch)){
                temp.add(' ');
                temp.add( ch);
            }
        }
        l1.addAll(temp);

        for (Character character : l1) {
            System.out.print(character);

        }

    }

    public static ArrayList<Character> convertStringToArraylist(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        for(int i = 0; i<str.length();i++){
            charList.add(str.charAt(i));
        }
        return charList;
    }
}
