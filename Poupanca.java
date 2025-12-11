package poo.lista10q1;

public class Poupanca extends Conta{
    public Poupanca(String nome, String conta, double taxa, double saldo){
        super(nome, conta, taxa, saldo);
    }

    public void atualizar(){
        setSaldo(getSaldo() + getTaxa());
    }
}
