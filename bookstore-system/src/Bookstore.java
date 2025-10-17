import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private int nextBookId = 1;
    private int nextAuthorId = 1;
    private int nextClientId = 1;

    // Construtor
    public Bookstore() {
        initializeData();
    }

    // Metodo para inicializar listas com dados
    private void initializeData() {
        Author author1 = new Author(1, "J.K. Rowling", LocalDate.of(1965, 7, 31));
        Author author2 = new Author(2, "George R.R. Martin", LocalDate.of(1948, 9, 20));
        Author author3 = new Author(3, "Augusto Varela", LocalDate.of(2023, 10, 15));

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        // Inicializando livros
        Book book1 = new Book(1, "Harry Potter and the Sorcerer's Stone", author1, true, LocalDate.now(), LocalDate.now());
        Book book2 = new Book(2, "A Game of Thrones", author2, true, LocalDate.now(), LocalDate.now());
        Book book3 = new Book(3, "Dragões de Silarea", author3, true, LocalDate.now(), LocalDate.now());

        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    // Metodo para listar livros disponíveis
    public void listAvailableBooks() {
        boolean hasAvailableBooks = false; // Flag para verificar disponibilidade

        System.out.println("Livros Disponíveis:");
        for (Book book : books) {
            if (book.getAvailable()) {
                System.out.println("ID: " + book.getId() + " | Título: " + book.getTitle() + " | Autor: " + book.getAuthor().getName());
                hasAvailableBooks = true; // Encontrou um livro disponível
            }
        }
    }

    // Metodo para registrar um novo livro
    public void registerNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o título do livro: ");
        String title = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
        String authorName = scanner.nextLine();
        System.out.print("Digite se o livro está disponível (true/false): ");
        boolean available = scanner.nextBoolean();

        Author author = new Author(nextAuthorId++, authorName, LocalDate.now()); // Gera ID automaticamente
        Book book = new Book(nextBookId++, title, author, available, LocalDate.now(), LocalDate.now()); // Gera ID automaticamente
        books.add(book);
        System.out.println("Livro adicionado com sucesso!");
    }

    // Metodo para cadastrar um novo cliente
    public void registerNewClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String name = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        for (Client client : clients) {
            if (client.email().equalsIgnoreCase(email)) {
                System.out.println("Este email já está cadastrado.");
                return;
            }
        }

        Client client = new Client(nextClientId++, name, email);
        clients.add(client);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Mtodo para escolher livro pelo ID
    public void chooseBookForLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o ID do livro que deseja: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book selectedBook = null;
        for (Book book : books) {
            if (book.getId() == bookId && book.getAvailable()) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook != null) {
            System.out.print("Insira seu nome para o registro do empréstimo: ");
            String customerName = scanner.nextLine();
            LocalDate loanDate = LocalDate.now();
            LocalDate returnDate = loanDate.plusDays(14); // Exemplo: empréstimo de 14 dias
            Loan newLoan = new Loan(loans.size() + 1, selectedBook, customerName, loanDate, returnDate);
            loans.add(newLoan);
            selectedBook.setAvailable(false); // Marca o livro como não disponível
            System.out.println("Empréstimo registrado com sucesso para " + customerName + ".");
        } else {
            System.out.println("Livro não encontrado ou não disponível para empréstimo.");
        }
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Getters and Setters
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}