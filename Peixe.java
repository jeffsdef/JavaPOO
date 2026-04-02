package poo.lista11q2;

public class Peixe extends Animal implements PodeNadar{
    public Peixe(String nome, int idade, double peso, double altura){
        super(nome, idade, peso, altura);
    }

     @Override
    public void nadar() {
        System.out.println(getNome() + " nadou.");
    }
}
