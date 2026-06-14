public class Main {

    public static void main(String[] args) {

        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design Database Schema", "Pending"));
        taskList.addTask(new Task(2, "Implement Login API", "In Progress"));
        taskList.addTask(new Task(3, "Write Unit Tests", "Pending"));
        taskList.addTask(new Task(4, "Deploy to Staging", "Pending"));

        System.out.println("\nAll tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for task with ID 3:");
        Task found = taskList.searchTask(3);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID 2:");
        taskList.deleteTask(2);

        System.out.println("\nAfter deletion:");
        taskList.traverseTasks();

        System.out.println("\nTime Complexity of linked list operations:");
        System.out.println("Add      - O(n) to reach end of list");
        System.out.println("Search   - O(n) scanning from head");
        System.out.println("Traverse - O(n)");
        System.out.println("Delete   - O(n) to find the node, then O(1) to remove it");
        System.out.println("Linked lists are better than arrays when data changes frequently.");
    }
}
