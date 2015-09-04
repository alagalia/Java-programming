package JavaSyntax;

import java.util.Scanner;

public class P02TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aX = scanner.nextInt();
        int aY = scanner.nextInt();
        int bX = scanner.nextInt();
        int bY = scanner.nextInt();
        int cX = scanner.nextInt();
        int cY = scanner.nextInt();

        int triangleArea = Math.abs((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2);
        if (triangleArea != 0) {
            System.out.println("The triangle`s area is: "+triangleArea);
        }
        else {
            System.out.println("This points cannot form triangle!");
        }
    }
}
