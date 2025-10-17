import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private Author author;
    private Boolean available;
    private LocalDate registrationDate;
    private LocalDate updateDate;

    // Constructor
    public Book(int id, String title, Author author, Boolean available, LocalDate registrationDate, LocalDate updateDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
        this.registrationDate = registrationDate;
        this.updateDate = updateDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}