package poo.lista11q2;

public class Cachorro extends Animal implements PodeAndar, PodeNadar{
    public Cachorro(String nome, int idade, double peso, double tamanho){
        super(nome, idade, peso, tamanho);
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
