import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private String nomeCliente;
    private LocalDate dataDeEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Livro livro, String nomeCliente) {
        this.id = id;
        this.livro = livro;
        this.nomeCliente = nomeCliente;
        this.dataDeEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolverLivro() {
        this.dataDevolucao = LocalDate.now();
        this.livro.setDisponivel(true);
    }
}
