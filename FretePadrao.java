package poo.lista10q2;

public class FretePadrao extends Frete {
    public FretePadrao(String codigo, String descricao, double distancia, double peso, double valorFreteBasico) {
        super(codigo, descricao, distancia, peso, valorFreteBasico);
    }
    
    @Override
    public double calcularFrete() {
        return super.getValorFreteBasico();
    }
}