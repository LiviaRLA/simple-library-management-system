import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        int id = 0;
        String name;
        String email;
        Date birthDate;
        String birthDateInput;
        String title;
        Date createdAt;
        Date updatedAt;
        String authorName;
        String userName;

        System.out.println("===== WELCOME to THE Library =====\n");

        do {

            System.out.println("Insert the number corespondent to the option you wanna follow");
            System.out.println(
                "1. LIST ALL BOOKS\n" +
                "2. LIST AVAILABLE BOOKS\n" +
                "3. ADD USER\n" +
                "4. ADD AUTHOR\n" +
                "5. ADD BOOK\n" +
                "6. LOAN BOOK\n" +
                "7. RETURN BOOK\n" +
                "8. LIST USERS\n" +
                "9. LIST AUTHORS\n" +
                "0. CLOSE SYSTEM"
            );
            System.out.print("Option: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    if (!library.listBooks().isEmpty()) {
                        library.listBooks();
                        System.out.println(library.listBooks());
                    } else {
                        System.out.println("There are no books registered in this library!");
                    }
                    break;

                case 2:
                    if (!library.listAvailableBooks().isEmpty()) {
                        library.listAvailableBooks();
                        System.out.println(library.listAvailableBooks());
                    } else {
                        System.out.println("There are no books available in this library!");
                    }
                    break;

                case 3:
                    System.out.println("Insert user informations");
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Email: ");
                    email = sc.nextLine();
                    System.out.print("Birth Date (dd/MM/yyyy): ");
                    birthDateInput = sc.nextLine();
                    birthDate = null;
                    try {
                        birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDateInput);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    }               
                    id = 1 + (int)(Math.random() * 999);
                    User user = new User(id, name, email, birthDate);
                    library.addUser(user);
                    System.out.println(user);
                    break;

                case 4:
                    System.out.println("Insert author informations");
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Birth Date (dd/MM/yyyy): ");
                    birthDateInput = sc.nextLine();
                    birthDate = null;
                    try {
                        birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDateInput);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    }               
                    id = 1 + (int)(Math.random() * 999);
                    Author author = new Author(id, name, birthDate);
                    library.addAuthor(author);
                    System.out.println(author);
                    break;

                case 5:
                    System.out.println("Insert book informations");
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author Name: ");
                    authorName = sc.nextLine();
                    id = 1 + (int)(Math.random() * 999);
                    createdAt = new Date();
                    updatedAt = new Date();
                    author = library.findAuthorByName(authorName);
                    if (author == null) {
                        System.out.println("Author not found. Please add the author first.");
                        break;
                    }
                    Book book = new Book(id, title, author, true, createdAt, updatedAt);
                    library.addBook(book);
                    System.out.println(book);
                    break;

                case 6:
                    System.out.println("Insert the following informations");
                    sc.nextLine();
                    System.out.print("Book title: ");
                    title = sc.nextLine();
                    System.out.print("Book author name: ");
                    authorName = sc.nextLine();
                    book = library.findBookByTitleAndAuthor(title, authorName);
                    if (book == null) {
                        System.out.println("Book not found.");
                        break;
                    }
                    System.out.print("User Name: ");
                    userName = sc.nextLine();
                    user =library.findUserByName(userName);
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    id = 1 + (int)(Math.random() * 999);
                    Loan loan = library.loanBook(book, user);
                    System.out.println(loan);
                    break;

                case 7:
                    System.out.println("Insert the book id to be returned");
                    System.out.print("Loan id: ");
                    id = sc.nextInt();
                    loan = library.returnBook(id);
                    if (loan == null) {
                        System.out.println("Loan not found.");
                        break;
                    }
                    System.out.println(loan);
                    break;

                case 8:
                    System.out.println(library.listUsers());
                    break;

                case 9:
                    System.out.println(library.listAuthors());
                    break;

                case 0:
                    System.out.println("Thank you for the visit!");
                    break;

                default:
                    System.out.println("Option invalid or not available at the moment!");
                    break;
            }
        } while (op!= 0);

        sc.close();
        
    }
}
