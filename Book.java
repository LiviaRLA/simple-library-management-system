import java.util.Date;
import java.util.UUID;

public class Book {

    private int id;
    private String title;
    private Author author;
    private boolean isAvailable;
    private Date createdAt;
    private Date updatedAt;

    public Book(int id, String title, Author author, boolean isAvailable, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
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
}
