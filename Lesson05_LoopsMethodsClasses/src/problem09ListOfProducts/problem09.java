package problem09ListOfProducts;
/*
Create a class Product to hold products, which have name (string) and price (decimal number). Read from a text file named "Input.txt" a list of products. Each product will be in format name + space + price. You should hold the products in objects of class Product. Sort the products by price and write them in format price + space + name in a file named "Output.txt".
 */
import java.io.*;
import java.util.*;

public class problem09 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        String fileName = "productsInput.txt";
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))
        ) {
            while (true) {
                String line= bf.readLine();
                if(line==null){ break;}
                String[] productElement=line.split(" ");
                String name = productElement[0];
                double price = Double.parseDouble(productElement[1]);
                products.add(new Product(name, price));
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(products);
        outputInfo(products);
    }

    private static void outputInfo(List<Product> list) {
        try( PrintWriter writer = new PrintWriter("output-text.txt")
        ) {
            for(Product product : list) {
            writer.println(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Product implements Comparable<Product>{
    String name;
    double price;

    public Product(String name, double prise) {
        this.price = prise;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return price + " " + name;
    }

    public int compareTo(Product other) {
            return new Double(this.price).compareTo(other.price);
    }
}
