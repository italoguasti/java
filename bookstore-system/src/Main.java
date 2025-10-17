import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner scanner = new Scanner(System.in);
        String response;

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Ver livros disponíveis");
            System.out.println("2. Pegar um livro emprestado");
            System.out.println("3. Cadastrar um novo livro");
            System.out.println("4. Cadastrar um novo cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    bookstore.listAvailableBooks();
                    break;
                case 2:
                    if (bookstore.getBooks().stream().anyMatch(Book::getAvailable)) {
                        bookstore.chooseBookForLoan(); // Metodo de escolher livro para empréstimo
                    } else {
                        System.out.println("Desculpe, não há livros disponíveis para empréstimo.");
                    }
                    break;
                case 3:
                    bookstore.registerNewBook();
                    break;
                case 4:
                    bookstore.registerNewClient();
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema. Encerrando...");
                    scanner.close();
                    return; // Encerra o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}