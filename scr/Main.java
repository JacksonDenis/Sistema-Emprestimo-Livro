import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("=== SISTEMA DE EMPRÉSTIMO DE LIVROS ===");
        System.out.print("Deseja ver a lista de livros disponíveis? (SIM/NÃO): ");
        String resposta = input.nextLine().trim().toUpperCase();

        while (true) {
            if (resposta.equals("SIM")) {
                biblioteca.listarLivrosDisponiveis();
                System.out.println("\\nDigite o ID do livro que deseja emprestar: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("Digite seu nome: ");
                String nome = input.nextLine();
                input.nextLine();
                biblioteca.realizarEmprestimo(id, nome);

                break;
            } else if (resposta.equals("NÃO")) {
                System.out.println("Ok, você pode ver a lista de livros disponíveis mais tarde.");
                break;
            } else {
                System.out.print("Resposta inválida. Por favor, digite 'SIM' ou 'NÃO': ");
                resposta = input.nextLine().trim().toUpperCase();
            }
        }
        input.close();
    }
}