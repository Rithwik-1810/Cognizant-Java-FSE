public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        System.out.println("First call to display():");
        image.display();

        System.out.println("\nSecond call to display():");
        image.display();
    }
}
