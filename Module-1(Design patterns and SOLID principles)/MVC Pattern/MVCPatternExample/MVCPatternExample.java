public class MVCPatternExample {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        System.out.println("--- Initial Student Record ---");
        controller.updateView();

        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        System.out.println("\n--- Updated Student Record ---");
        controller.updateView();
    }
}
