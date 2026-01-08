package poo.lista13q1;

public class Editora {
    private int codigo;
    private String nome;
    private String paisOrigem;
    private int fundacao;
    
    public Editora(int codigo, String nome, String paisOrigem, int fundacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.fundacao = fundacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public int getFundacao() {
        return fundacao;
    }

    public void setFundacao(int fundacao) {
        this.fundacao = fundacao;
    }
}
