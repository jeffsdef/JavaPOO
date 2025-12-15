package poo.lista11q2;

public class Gato extends Animal implements PodeAndar, PodeNadar{
    public Gato(String nome, int idade, double peso, double altura){
        super(nome, idade, peso, altura);
    }

    @Override
    public void andar() {
        System.out.println(getNome() + " andou.");      
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " nadou.");
    }
}
