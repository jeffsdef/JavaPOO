package poo.lista12q2;

public abstract class Frete {
    private String codigo;
    private String descricao;
    private double distancia;
    private double peso;
    private double valorFreteBasico;
    
    public Frete(String codigo, String descricao, double distancia, double peso, double valorFreteBasico) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.distancia = distancia;
        this.peso = peso;
        this.valorFreteBasico = valorFreteBasico;
    }
    
    public abstract double calcularFrete();
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public double getDistancia() {
        return distancia;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public double getValorFreteBasico() {
        return valorFreteBasico;
    }
}