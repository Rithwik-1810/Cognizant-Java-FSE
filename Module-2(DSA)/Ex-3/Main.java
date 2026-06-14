public class Main {

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {

        Order[] ordersForBubble = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 75.50),
            new Order(3, "Charlie", 520.00),
            new Order(4, "Diana", 180.75),
            new Order(5, "Eve", 340.20)
        };

        Order[] ordersForQuick = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 75.50),
            new Order(3, "Charlie", 520.00),
            new Order(4, "Diana", 180.75),
            new Order(5, "Eve", 340.20)
        };

        System.out.println("\nOrders before sorting:");
        printOrders(ordersForBubble);

        SortingAlgorithms.bubbleSort(ordersForBubble);
        System.out.println("\nAfter Bubble Sort (by total price):");
        printOrders(ordersForBubble);

        SortingAlgorithms.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        System.out.println("\nAfter Quick Sort (by total price):");
        printOrders(ordersForQuick);

        System.out.println("\nTime Complexity:");
        System.out.println("Bubble Sort - Best: O(n), Average: O(n^2), Worst: O(n^2)");
        System.out.println("Quick Sort  - Best: O(n log n), Average: O(n log n), Worst: O(n^2)");
        System.out.println("Quick Sort is preferred for large order lists due to better average performance.");
    }
}
