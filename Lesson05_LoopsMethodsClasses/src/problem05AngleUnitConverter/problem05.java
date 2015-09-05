package problem05AngleUnitConverter;
/*
Write a method to convert from degrees to radians. Write a method to convert from radians to degrees. You are given a number n and n queries for conversion. Each conversion query will consist of a number + space + measure. Measures are "deg" and "rad". Convert all radians to degrees and all degrees to radians. Print the results as n lines, each holding a number + space + measure. Format all numbers with 6 digit after the decimal point.
 */
import java.util.Locale;
import java.util.Scanner;

public class problem05 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);
        int loops= scan.nextInt();
        for (int i = 0; i < loops; i++) {
            double num = Double.parseDouble(scan.next());
            String format = scan.next();
            switch (format){
                case "deg": convertDegreeToRadian(num); break;
                case "rad": convertRadianToDegree(num);break;
            }
        }
    }

    private static void convertRadianToDegree(double num) {
        System.out.printf("%.6f%n", num * 180 / Math.PI);
    }

    private static void convertDegreeToRadian(double num) {
        System.out.printf("%.6f%n", num * Math.PI / 180);
    }
}
