package problem07DaysBeweenTwoDates;
/*
Write a program to calculate the difference between two dates in number of days. The dates are entered at two consecutive lines in format day-month-year.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class problem07 {

            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                String firstString = scan.nextLine();
                String secondString = scan.next();

                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");

                try {
                    Date firstdate = myFormat.parse(firstString);
                    Date secondDate = myFormat.parse(secondString);
                    System.out.println(getDifferenceDays(firstdate, secondDate));
                }
                catch (ParseException ex)
                {
                    ex.printStackTrace();
                }

        }
    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    }
