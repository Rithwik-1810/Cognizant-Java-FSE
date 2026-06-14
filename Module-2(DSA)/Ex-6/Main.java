
public class Main {

    public static void main(String[] args) {

        Book[] books = {
            new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(1, "Clean Code", "Robert C. Martin"),
            new Book(5, "Harry Potter", "J.K. Rowling"),
            new Book(2, "Atomic Habits", "James Clear"),
            new Book(4, "Sapiens", "Yuval Noah Harari")
        };

        Book[] sortedBooks = {
            new Book(2, "Atomic Habits", "James Clear"),
            new Book(1, "Clean Code", "Robert C. Martin"),
            new Book(5, "Harry Potter", "J.K. Rowling"),
            new Book(4, "Sapiens", "Yuval Noah Harari"),
            new Book(3, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        System.out.println("\nLinear Search - looking for 'Harry Potter':");
        Book result1 = LibrarySearch.linearSearchByTitle(books, "Harry Potter");
        if (result1 != null) {
            System.out.println("Found: " + result1);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nBinary Search - looking for 'Atomic Habits':");
        Book result2 = LibrarySearch.binarySearchByTitle(sortedBooks, "Atomic Habits");
        if (result2 != null) {
            System.out.println("Found: " + result2);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nBinary Search - looking for 'Unknown Title':");
        Book result3 = LibrarySearch.binarySearchByTitle(sortedBooks, "Unknown Title");
        if (result3 != null) {
            System.out.println("Found: " + result3);
        } else {
            System.out.println("Book 'Unknown Title' not found in the library.");
        }

        System.out.println("\nTime Complexity:");
        System.out.println("Linear Search - O(n), works on unsorted data");
        System.out.println("Binary Search - O(log n), requires sorted data");
        System.out.println("For 10,000 books, binary search needs about 14 steps vs up to 10,000 for linear.");
    }
}
