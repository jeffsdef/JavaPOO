package poo.lista10q2;

public class FreteTerrestre extends Frete {
    public FreteTerrestre(String codigo, String descricao, double distancia, double peso, double valorFreteBasico) {
        super(codigo, descricao, distancia, peso, valorFreteBasico);
    }
    
    @Override
    public double calcularFrete() {
        return super.getValorFreteBasico() + (getDistancia() * 3.5) + (getPeso() * 2.0);
    }
}
