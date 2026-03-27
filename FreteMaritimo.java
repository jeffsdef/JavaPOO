package poo.lista12q2;

public class FreteMaritimo extends Frete {
    public FreteMaritimo(String codigo, String descricao, double distancia, double peso, double valorFreteBasico) {
        super(codigo, descricao, distancia, peso, valorFreteBasico);
    }
    
    @Override
    public double calcularFrete() {
        return super.getValorFreteBasico() + (getDistancia() * 5.0) + (getPeso() * 1.5) + 300;
    }
}
