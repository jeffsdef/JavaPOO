package poo.lista12q1;

public class SaldoInsuficiente extends Exception{
    public SaldoInsuficiente(){};
    
    public SaldoInsuficiente(String message){
        super(message);
    }
}
