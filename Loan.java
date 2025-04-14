import java.util.Date;

public class Loan {

    private int id;
    private static int countId=1;
    private User user;
    private Book book;
    private Date loanDate;
    private Date returnDate;
    private boolean active;
    
    public Loan(Book book, User user) {
        this.id = countId++;
        this.user = user;
        this.book = book;
        this.loanDate = new Date();
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return active;
    }

    public void returnBook() {
        this.returnDate = new Date();
        this.active = false;
        this.book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Loan {" +
                "\nid= " + id +
                "\nbook= " + book +
                "\nuser= " + user +
                "\nloanDate= " + loanDate +
                "\nreturnDate= " + returnDate +
                "\nactive= " + active +
                "\n}";
    }
    
}
