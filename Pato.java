package poo.lista11q2;

public class Pato extends Animal implements PodeAndar, PodeNadar, PodeVoar{
    public Pato(String nome, int idade, double peso, double altura){
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
    
    @Override
    public void voar() {
        System.out.println(getNome() + " voou.");
    }
}
