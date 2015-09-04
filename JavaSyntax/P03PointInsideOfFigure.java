package JavaSyntax;
import java.util.Locale;
import java.util.Scanner;

public class P03PointInsideOfFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        if ((x>=12.5 && x<=22.5 && y>=6 && y<=8.5)
                ||(x>=12.5 && x<=17.5 && y>=8.5 && y<=13.5)
                ||(x>=20 && x<=22.5 && y>=8.5 && y<=13.5)) {
            System.out.println("The point is inside of polygon!");
        }
        else {
            System.out.println("The point is outside of polygon!");
        }
    }
}
