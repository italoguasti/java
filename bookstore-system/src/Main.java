import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner scanner = new Scanner(System.in);
        String response;

        while (true) {
            System.out.print("Deseja ver os livros disponíveis? (SIM/NAO): ");
            response = scanner.nextLine().trim().toUpperCase();

            if (response.equals("SIM")) {
                bookstore.listAvailableBooks();

                if (bookstore.getBooks().stream().anyMatch(Book::getAvailable)) {
                    // Pergunta ao usuário se deseja emprestar um livro
                    System.out.print("Deseja pegar um livro emprestado? (SIM/NAO): ");
                    String loanResponse = scanner.nextLine().trim().toUpperCase();

                    if (loanResponse.equals("SIM")) {
                        bookstore.chooseBookForLoan();
                    } else if (loanResponse.equals("NAO")) {
                        System.out.println("Você optou por não pegar um livro emprestado.");
                    } else {
                        System.out.println("Resposta inválida. Por favor, digite 'SIM' ou 'NÃO'.");
                    }
                } else {
                    System.out.println("Desculpe, todos os livros foram emprestados! :(");
                }

            } else if (response.equals("NAO")) {
                System.out.println("Obrigado por usar o sistema. Encerrando...");
                break;
            } else {
                System.out.println("Por favor, digite 'SIM' ou 'NÃO'.");
            }
        }

        scanner.close();
    }
}