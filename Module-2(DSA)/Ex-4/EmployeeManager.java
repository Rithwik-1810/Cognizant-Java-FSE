public class EmployeeManager {

    private Employee[] employees;
    private int count;
    private int capacity;

    public EmployeeManager(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count >= capacity) {
            System.out.println("Cannot add. Array is full.");
            return;
        }
        employees[count] = emp;
        count++;
        System.out.println("Added: " + emp);
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int indexToDelete = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }

        for (int i = indexToDelete; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;
        System.out.println("Employee with ID " + employeeId + " deleted.");
    }
}
