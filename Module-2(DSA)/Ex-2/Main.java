public class Main {

    public static void main(String[] args) {

        Product[] products = {
            new Product(103, "Headphones", "Electronics"),
            new Product(201, "T-Shirt", "Clothing"),
            new Product(55, "Running Shoes", "Footwear"),
            new Product(312, "Coffee Maker", "Kitchen"),
            new Product(415, "Novel Book", "Books")
        };

        System.out.println("\nLinear Search - searching for product ID 312:");
        Product found1 = SearchAlgorithms.linearSearch(products, 312);
        if (found1 != null) {
            System.out.println("Found: " + found1);
        } else {
            System.out.println("Product not found.");
        }

        Product[] sortedProducts = {
            new Product(55, "Running Shoes", "Footwear"),
            new Product(103, "Headphones", "Electronics"),
            new Product(201, "T-Shirt", "Clothing"),
            new Product(312, "Coffee Maker", "Kitchen"),
            new Product(415, "Novel Book", "Books")
        };

        System.out.println("\nBinary Search - searching for product ID 201:");
        Product found2 = SearchAlgorithms.binarySearch(sortedProducts, 201);
        if (found2 != null) {
            System.out.println("Found: " + found2);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\nBinary Search - searching for product ID 999:");
        Product found3 = SearchAlgorithms.binarySearch(sortedProducts, 999);
        if (found3 != null) {
            System.out.println("Found: " + found3);
        } else {
            System.out.println("Product with ID 999 not found.");
        }

        System.out.println("\nTime Complexity:");
        System.out.println("Linear Search - Best: O(1), Average: O(n), Worst: O(n)");
        System.out.println("Binary Search - Best: O(1), Average: O(log n), Worst: O(log n)");
        System.out.println("Binary search is faster for large datasets but needs a sorted array.");
    }
}
