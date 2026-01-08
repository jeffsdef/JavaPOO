package poo.lista13q1;

public class Autor {
    private String nome;
    private String nacionalidade;
    private String dataNasc;

    public Autor(String nome, String nacionalidade, String dataNasc){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNasc = dataNasc;
    }

    public String getNome() {return nome;}
    public String getNacionalidade() {return nacionalidade;}
    public String getdataNasc() {return dataNasc;}

    public void setNome(String nome) {this.nome = nome;}
    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
    public void setdataNasc(String dataNasc) {this.dataNasc = dataNasc;}
    
}
