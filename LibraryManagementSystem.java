package Task_3;

import java.util.*;

public class LibraryManagementSystem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;
        do{
            System.out.println("\n===== Libarary Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch(choice){
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    library.addBook(new Book(bookId, bookTitle));
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();
                    library.addUser(new User(userId, userName));
                    break;
                case 3:
                    library.viewBooks();
                    break;
                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUserId = scanner.nextInt();
                    library.issueBook(issueBookId, issueUserId);
                    break;
                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    library.returnBook(returnBookId);
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }while( choice != 6);
        scanner.close();
    }
}
