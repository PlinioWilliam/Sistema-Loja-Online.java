public class Cliente {
    private String nome;
    private final String cpf;
    private int pontosFidelidade;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pontosFidelidade = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getPontos() {
        return this.pontosFidelidade;
    }

    public void adicionarPontos(int pontos) {
        this.pontosFidelidade += pontos;
    }

    public void removerPontos(int pontos) {
        this.pontosFidelidade -= pontos;
    }

}
