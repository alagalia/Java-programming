import java.util.Scanner;
/*
Write a  program to find all increasing sequences inside an array of integers. The integers are given in a single line, separated by a space. Print the sequences in the order of their appearance in the input array, each at a single line. Separate the sequence elements by a space. Find also the longest increasing sequence and print it at the last line. If several sequences have the same longest length, print the leftmost of them.
 */
public class Problem04_LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = (scan.nextLine()).split(" ");
        Integer[] nums = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            try{
                nums[i]= Integer.parseInt(input[i]);
            } catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }

        Integer maxSeqCounter = 1;
        Integer currentSeqCounter = 1;

        Integer endPos=1;

        System.out.print(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                System.out.print(" "+ nums[i]);
                currentSeqCounter++;
                if (currentSeqCounter>maxSeqCounter){
                    maxSeqCounter=currentSeqCounter;
                    endPos=i;
                }
            } else {
                currentSeqCounter=1;
                System.out.println();
                System.out.print(nums[i]);
            }
        }
        System.out.println();
        System.out.println("Longest:"+ produceLongestString(nums, endPos, maxSeqCounter));
    }

    private static String produceLongestString(Integer[] nums, Integer endPos, Integer maxSeqCounter) {
        if(maxSeqCounter==1){
            return nums[0].toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = endPos-maxSeqCounter+1; i <= endPos; i++) {
           sb = sb.append(nums[i]).append(" ");
        }
        return sb.toString();
    }
}
