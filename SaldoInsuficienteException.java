package poo.lista13q2;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException() {
    }

    public SaldoInsuficienteException(String message){
        System.out.println(message);
    }
}
