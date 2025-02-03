import java.util.Date;

public class Author {

    private int id;
    private String name;
    private Date birthDate;

    public Author(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        name = this.name;
    }

    public void setBirthDate(Date birthDate) {
        birthDate = this.birthDate;
    }
    
}
