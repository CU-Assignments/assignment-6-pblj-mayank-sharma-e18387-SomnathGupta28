import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Smartphone", "Electronics", 800.00));
        products.add(new Product("Tablet", "Electronics", 400.00));
        products.add(new Product("Chair", "Furniture", 150.00));
        products.add(new Product("Table", "Furniture", 300.00));
        products.add(new Product("Sofa", "Furniture", 700.00));
        products.add(new Product("Shirt", "Clothing", 50.00));
        products.add(new Product("Jeans", "Clothing", 60.00));
        products.add(new Product("Jacket", "Clothing", 120.00));

        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveProducts.forEach((category, product) -> {
            System.out.println(category + ": " + product.map(Product::toString).orElse("None"));
        });

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.printf("\nAverage price of all products: %.2f%n", averagePrice);
    }
}