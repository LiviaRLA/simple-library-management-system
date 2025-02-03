import java.util.Date;

public class Book {

    private int id;
    private String title;
    private Author author;
    private boolean available;
    private Date createdAt;
    private Date updatedAt;

    public Book(int id, String title, Author author, boolean isAvailable, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // getters and setters
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
