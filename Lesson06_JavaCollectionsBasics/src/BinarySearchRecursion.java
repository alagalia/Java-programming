/**
 * Created by Dell on 12.11.2015 ã..
 */
public class BinarySearchRecursion {
    public static void main(String[] args) {
        int searched = 50;
        int[] nums = new int[]{1,2,4,13,22,23,33,45,50};
        int index = findIndex(nums, 0, nums.length - 1, searched);
        System.out.println(index);
    }

    public static int findIndex(int[] nums, int start, int end, int searched) {
        int middle = (start + end) / 2;
        if(end < start) {
            return -1;
        }if(searched==nums[middle]) {
            return middle;
        } else if(searched<nums[middle]) {
            return findIndex(nums, start, middle - 1, searched);
        } else {
            return findIndex(nums, middle + 1, end, searched);
        }

    }
}
