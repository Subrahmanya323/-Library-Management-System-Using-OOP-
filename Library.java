package Task_3;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Map<Integer,Integer> issuedBooks = new HashMap<>();

    public  void addBook(Book book){
        books.add(book);
        System.out.println("Book added successfully");
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("User added successfully");
    }

    public void viewBooks(){
        System.out.println("\n---- List of Books ----");
        if(books.isEmpty()){
            System.out.println(" No books available.");
        } else {
            for(Book book : books) {
                book.display();
            }
        }
    }

    public void issueBook(int bookId, int userId){
        Book book = getBookById(bookId);
        User user = getUserById(userId);

        if(book == null){
            System.out.println("Book not found.");
            return;
        }

        if(user == null){
            System.out.println("User not found.");
            return;
        }

        if(book.isIssued()){
            System.out.println("Book is already is issued.");
            return;
        }

        book.issued();
        issuedBooks.put(bookId, userId);
        System.out.println("Book is issued to the user " + user.getName());
    }

    public void returnBook(int bookId){
        Book book = getBookById(bookId);

        if(book == null || !book.isIssued()){
            System.out.println("Book is not found or not issued.");
            return;
        }
        book.returned();
        issuedBooks.remove(bookId);
        System.out.println("Book is returned successfully.");
    }

    public Book getBookById(int id){
        for(Book b : books){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public User getUserById(int id){
        for(User u : users){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }
}
