package poo.lista11q2;

public class Animal {
    private String nome;
    private int idade;
    private double peso;
    private double tamanho;

    public Animal(String nome, int idade, double peso, double tamanho){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
}
