public class Main {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(101, "Alice", "Developer", 75000));
        manager.addEmployee(new Employee(102, "Bob", "Designer", 60000));
        manager.addEmployee(new Employee(103, "Charlie", "Manager", 90000));
        manager.addEmployee(new Employee(104, "Diana", "Tester", 55000));

        System.out.println("\nAll employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for employee with ID 103:");
        Employee found = manager.searchEmployee(103);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID 102:");
        manager.deleteEmployee(102);

        System.out.println("\nAfter deletion:");
        manager.traverseEmployees();

        System.out.println("\nTime Complexity of array operations:");
        System.out.println("Add      - O(1)");
        System.out.println("Search   - O(n)");
        System.out.println("Traverse - O(n)");
        System.out.println("Delete   - O(n) due to element shifting");
    }
}
