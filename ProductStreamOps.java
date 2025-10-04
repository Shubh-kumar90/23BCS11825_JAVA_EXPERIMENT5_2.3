import java.util.*;
import java.util.stream.*;

class Product {
    private int id;
    private String name;
    private double price;
    private String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + price + " - " + category;
    }
}

public class ProductStreamOps {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 80000, "Electronics"),
                new Product(2, "Mouse", 1500, "Electronics"),
                new Product(3, "Shirt", 1200, "Clothing"),
                new Product(4, "Phone", 40000, "Electronics"),
                new Product(5, "Jeans", 2000, "Clothing"));

        System.out.println("=== Products above ₹2000 ===");
        products.stream()
                .filter(p -> p.getPrice() > 2000)
                .forEach(System.out::println);

        System.out.println("\n=== Average price of Electronics ===");
        double avg = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Electronics"))
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        System.out.println("Average: ₹" + avg);

        System.out.println("\n=== Group by Category ===");
        Map<String, List<Product>> group = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        group.forEach((cat, list) -> {
            System.out.println(cat + ": " + list);
        });
    }
}
