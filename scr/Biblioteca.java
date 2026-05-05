import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();

    private int proximoIdEmprestimo;
    public Biblioteca() {
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {
        // Criar autores
        Autor autor1 = new Autor(1, "J.K. Rowling", LocalDate.of(1965, 7, 31));
        Autor autor2 = new Autor(2, "George R.R. Martin", LocalDate.of(1948, 9, 20));
        Autor autor3 = new Autor(3, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor autor4 = new Autor(4, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        Autor autor5 = new Autor(5, "George Orwell", LocalDate.of(1903, 6, 25));
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
        autores.add(autor5);

        // Criar livros
        Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "Harry Potter e a Câmara Secreta", autor1);
        Livro livro3 = new Livro(3, "As Crônicas de Gelo e Fogo: A Guerra dos Tronos", autor2);
        Livro livro4 = new Livro(4, "Dom Casmurro", autor3);
        Livro livro5 = new Livro(5, "Memórias Póstumas de Brás Cubas", autor3);
        Livro livro6 = new Livro(6, "A Hora da Estrela", autor4);
        Livro livro7 = new Livro(7, "1984", autor5);
        Livro livro8 = new Livro(8, "A Revolução dos Bichos", autor5);
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);
        livros.add(livro6);
        livros.add(livro7);
        livros.add(livro8);
    }

    public void listarLivrosDisponiveis() {
        System.out.println("\n===== LIVROS DISPONÍVEIS =====");

        boolean encontrouDisponivel = false;

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("ID: " + livro.getId()
                        + " | Título: " + livro.getTitulo()
                        + " | Autor: " + livro.getAutor().getNome());
                encontrouDisponivel = true;
            }
        }

        if (!encontrouDisponivel) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public  void buscarLivroDisponivelPorId (int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id && livro.isDisponivel()) {
                System.out.println("Livro encontrado: " + livro.getTitulo() + " por " + livro.getAutor().getNome());
                return;
            }
        }
        System.out.println("Nenhum livro disponível encontrado com o ID: " + id);
    }

    public boolean realizarEmprestimo (int idLivro, String nomeCliente) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) {
                if (livro.isDisponivel()) {
                    livro.setDisponivel(false);
                    Emprestimo emprestimo = new Emprestimo(proximoIdEmprestimo++, livro, nomeCliente);
                    emprestimos.add(emprestimo);
                    System.out.println("Empréstimo realizado com sucesso para o livro: " + livro.getTitulo());
                    return true;
                } else {
                    System.out.println("O livro '" + livro.getTitulo() + "' não está disponível para empréstimo.");
                    return false;
                }
            }
        }
        System.out.println("Nenhum livro encontrado com o ID: " + idLivro);
        return false;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
