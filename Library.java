import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // CRUD books
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> listBooks() {
        return books;
    }

    public List<Book> listAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books){
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    public Book updateBook(int id, String newTitle) {
        for (Book book : books) {
            if (book.getId() == id){
                book.setTitle(newTitle);
                return book;
            }
        }
        return null;
    }

    public List<Book> removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        return books;
    }

    // CRUD authors
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> listAuthors() {
        return authors;
    }

    public Author updateAuthor(int id, String name) {
        for (Author author : authors) {
            if (author.getId() == id){
                author.setName(name);
                return author;
            }
        }
        return null;
    }

    public List<Author> removeAuthor(int id) {
        authors.removeIf(author -> author.getId() == id);
        return authors;
    }

    // CRUD users
    public void addUser(User user) {
        users.add(user);
    }

    public List<User> listUsers() {
        return users;
    }

    public User updateUser(int id, String name) {
        for (User user : users) {
            if (user.getId() == id){
                user.setName(name);
                return user;
            }
        }
        return null;
    }

    public List<User> removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
        return users;
    }

    //Loans
    public Loan loanBook(Book book, User user) {
        if (book.isAvailable()) {
            Loan loan = new Loan(book, user);
            loans.add(loan);
            book.setAvailable(false);
            return loan;
        } else {
            System.out.println("Book not available!");
            return null;
        }
    }

    public Loan returnBook(int id) {
        for (Loan loan : loans) {
            if (loan.getId() == id && loan.isActive()) {
                loan.returnBook();
                return loan;
            }
        }
        return null;
    }

    public List<Loan> listLoans() {
        return loans;
    }

    public Author findAuthorByName(String authorName) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(authorName)){
                return author;
            }
        }
        return null;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                list.add(book);
            }
        }
        return list;
    }

    public Book findBookByTitleAndAuthor(String title, String authorName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> listBooksByAuthor(String authorName) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                list.add(book);
            }
        }
        return list;
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public User findUserByName(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}