package poo.lista12q1;

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

    public void deposito(double valor) throws ValorInvalido {
        if (valor <= 0) {
            throw new ValorInvalido("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void saque(double valor) throws SaldoInsuficiente, ValorInvalido {
        if (valor <= 0) {
            throw new ValorInvalido("O valor do saque deve ser positivo.");
        }
        if (valor > this.saldo) {
            throw new SaldoInsuficiente("Saldo insuficiente. Disponível: " + this.saldo);
        }
        this.saldo -= valor;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getConta() { return conta; }
    public void setConta(String conta) { this.conta = conta; }
    public double getTaxa() { return taxa; }
    public void setTaxa(double taxa) { this.taxa = taxa; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
}