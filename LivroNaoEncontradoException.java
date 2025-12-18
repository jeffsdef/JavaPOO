package poo.lista13q1;

public class LivroNaoEncontradoException extends Exception{
    public LivroNaoEncontradoException(){}

    public LivroNaoEncontradoException(String message){
        System.out.println(message);
    }
}
