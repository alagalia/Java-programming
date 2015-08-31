package JavaSyntax;

import java.util.Arrays;
import java.util.Scanner;

public class P04SmallestOf3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = new double[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextDouble();
        }
        Arrays.sort(nums);
        System.out.println(nums[0]);
    }
}
