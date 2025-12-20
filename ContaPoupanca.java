package poo.lista13q2;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, int numero, double taxa, double saldo){
        super(cliente, numero, taxa, saldo);
    }

    
    public void Atualizar(){
        super.Depositar(getTaxa());
    }
}
