import java.util.Date;

public class Loan {

    private int id;
    private User user;
    private Book book;
    private Date loanDate;
    private Date returnDate;
    
    public Loan(int id, User user, Book book, Date loanDate, Date returnDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = new Date();
        this.returnDate = returnDate;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
}
