package poo.lista13q2;

public class ValorInvalidoException extends Exception{
    public ValorInvalidoException(){   
    }

    public ValorInvalidoException(String message){
        System.out.println(message);
    }
}
