package poo.lista10q1;

public abstract class Conta {
    private String nome;
    private String conta;
    private double taxa;
    private double saldo;

    public Conta(String nome, String conta, double taxa, double saldo){
        this.nome = nome;
        this.conta = conta;
        this.taxa = taxa;
        this.saldo = saldo;
    }

    public abstract void atualizar();

    public double deposito(double valor){
        return valor += getSaldo();
    }

    public double saque(double valor){
        return valor -= getSaldo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
