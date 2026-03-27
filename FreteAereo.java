package poo.lista12q2;

public class FreteAereo extends Frete {
    public FreteAereo(String codigo, String descricao, double distancia, double peso, double valorFreteBasico) {
        super(codigo, descricao, distancia, peso, valorFreteBasico);
    }
    
    @Override
    public double calcularFrete() {
        return super.getValorFreteBasico() + (getDistancia() * 10.0) + (getPeso() * 8.0) + 1000;
    }
}
