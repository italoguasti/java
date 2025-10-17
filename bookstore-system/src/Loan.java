import java.time.LocalDate;

public class Loan {
    private int id;
    private Book book;
    private String customerName;
    private LocalDate loanDate;
    private LocalDate returnDate;

    // Constructor
    public Loan(int id, Book book, String customerName, LocalDate loanDate, LocalDate returnDate) {
        this.id = id;
        this.book = book;
        this.customerName = customerName;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}