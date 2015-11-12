/**
 * Created by Dell on 12.11.2015 ã..
 */
public class BinarySearch {
    public static void main(String[] args) {
        int searched = 45;
        int[] nums = new int[]{1,2,4,13,22,23,33,45,50};
        int index = findIndex(searched, nums);
        System.out.println(index);
    }

    private static int findIndex(int searched, int[] nums) {
        int start = 0;
        int end=nums.length-1;
        while (start<=end){
            int middle = (start + end) / 2;
            if (nums[middle]==searched){
               return middle;
            }
            if (searched<nums[middle]){
                end=middle-1;
            }
            else if (searched>nums[middle]){
                start=middle+1;
            }
        }
        return -1;
    }
}
