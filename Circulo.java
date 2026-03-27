package poo.lista11q1;

public class Circulo implements ObjetoGeometrico {
    private double raio;
    private double pi;
    
    public Circulo(double raio, double pi) {
        this.raio = raio;
        this.pi = pi;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    @Override
    public double calcularArea(){
        return pi * raio * raio;
    }
    public double calcularPerimetro(){
        return 2 * pi * raio;
    }
}
