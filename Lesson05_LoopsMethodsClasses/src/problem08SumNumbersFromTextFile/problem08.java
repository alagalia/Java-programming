package problem08SumNumbersFromTextFile;
/*
Write a program to read a text file "Input.txt" holding a sequence of integer numbers, each at a separate line. Print the sum of the numbers at the console. Ensure you close correctly the file in case of exception or in case of normal execution.
 */
import java.io.*;

public class problem08 {
    public static void main(String[] args) throws IOException{
        int sum = 0;
        String fileName = "Input.txt";
        try( BufferedReader fileReader = new BufferedReader(new FileReader(fileName))
        ) {
            while (true) {
                String line = fileReader.readLine();
                if (line == null) {
                    break;
                }
                int num = Integer.parseInt(line);
                    sum+=num;
            }
            System.out.println("Result: "+ sum);
        } catch (IOException ioex) {
            System.err.println("Cannot read the file " + fileName);
            ioex.printStackTrace();
        }
    }
}
