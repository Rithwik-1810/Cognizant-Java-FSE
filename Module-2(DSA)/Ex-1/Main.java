public class Main {
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(101, "Laptop", 10, 50000);
        Product p2 = new Product(102, "Mouse", 50, 500);

        manager.addProduct(p1);
        manager.addProduct(p2);

        System.out.println("\nInventory:");
        manager.displayInventory();

        manager.updateProduct(101, 15, 52000);

        System.out.println("\nAfter Update:");
        manager.displayInventory();

        manager.deleteProduct(102);

        System.out.println("\nAfter Deletion:");
        manager.displayInventory();
    }
}