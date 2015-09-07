package problem10OrderOfProducts;
/*
Create a class Product to hold products, which have name (string) and price (decimal number).
Read from a text file named "Products.txt" a list of product with prices and keep them in a list of products.
Each product will be in format name + space + price. You should hold the products in objects of class Product.
Read from a text file named "Order.txt" an order of products with quantities.
Each order line will be in format product + space + quantity.
Calculate and print in a text file "Output.txt" the total price of the order.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class Problem10 {
    public static void main(String[] args) {

        TreeMap<String, Product> products = new TreeMap<>();
        TreeMap<String, Double> productQuantity = new TreeMap<>();

        try(BufferedReader listProducts = new BufferedReader(new FileReader("Products.txt"));
            BufferedReader listOfOrders = new BufferedReader(new FileReader("Order.txt")))
        {
            addProductToList(products, listProducts);

            putOrdersToTreeMap(productQuantity, listOfOrders);

            //iterate productQuantity and calculate total sum of order
            Double sum = 0d;
            Set<String> nameOfProductsInOrderList = productQuantity.keySet();
            for(String name: nameOfProductsInOrderList){
                Double price = products.get(name).getPrice();
                Double quantity = productQuantity.get(name);
                Double totalForProduct= price* quantity;
                sum += totalForProduct;
                //System.out.println("Quantity of "+name+" is: "+productQuantity.get(name));
                    }
                System.out.printf("%.2f",sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addProductToList(TreeMap<String, Product> products, BufferedReader listProducts) throws IOException {
        while (true) {
            String lineProducts = listProducts.readLine();
            if(lineProducts==null){break;}
            String[] stringElements = lineProducts.split(" ");
            String productName = stringElements[0];
            Double price = Double.parseDouble(stringElements[1]);
            products.put(productName, new Product(productName, price));
        }
    }

    private static void putOrdersToTreeMap(TreeMap<String, Double> productQuantity, BufferedReader listOfOrders) throws IOException {
        while (true){
            String lineOrders= listOfOrders.readLine();
            if(lineOrders==null){break;}
            String[] stringElements = lineOrders.split(" ");
            String productName = stringElements[1];
            Double quantity = Double.parseDouble(stringElements[0]);
            if (!productQuantity.containsKey(productName))
            {
                productQuantity.put(productName, quantity);
            }
            else {
                Double currentQuantity = productQuantity.get(productName);
                productQuantity.put(productName,quantity+currentQuantity);
            }
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
