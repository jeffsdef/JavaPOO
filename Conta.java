package poo.lista13q2;

public abstract class Conta {
    private Cliente cliente;
    private int numero;
    private double taxa;
    private double saldo;

    public Conta(Cliente cliente, int numero, double taxa, double saldo){
        this.cliente = cliente;
        this.numero = numero;
        this.taxa = taxa;
        this.saldo = saldo;
    }

    public abstract void Atualizar();

    public void Sacar(double valor){
        this.saldo -= valor;
    }

    public void Depositar(double valor){
        this.saldo += valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
