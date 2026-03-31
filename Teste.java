package poo.lista10q2;

import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Frete> fretes = new ArrayList<>();

        do{
            System.out.println("-- Menu --");
            System.out.println("1. Cadastrar um novo frete");
            System.out.println("2. Listar todos os fretes cadastrados");
            System.out.println("3. Calcular o valor de um frete individual");
            System.out.println("4. Comparar o valor do frete entre os três tipos de transporte");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: "); int opc = scan.nextInt(); scan.nextLine();

            if(opc == 1){
                System.out.print("Código da entrega: "); String codigo = scan.nextLine();
                System.out.print("Descrição: "); String descricao = scan.nextLine();
                System.out.print("Distância (km): "); double distancia = scan.nextDouble();
                System.out.print("Peso da carga (kg): "); double peso = scan.nextDouble();
                System.out.print("Valor do frete básico: "); double valorFreteBasico = scan.nextDouble();
                
                System.out.println("Tipo de frete:");
                System.out.println("1. Terrestre");
                System.out.println("2. Marítimo");
                System.out.println("3. Aéreo");
                System.out.println("4. Padrão");
                System.out.print("Digite o tipo: "); int tipo = scan.nextInt(); scan.nextLine();
                
                if(tipo == 1){
                    Frete frete = new FreteTerrestre(codigo, descricao, distancia, peso, valorFreteBasico);
                    fretes.add(frete);
                }
                else if(tipo == 2){
                    Frete frete = new FreteMaritimo(codigo, descricao, distancia, peso, valorFreteBasico);
                    fretes.add(frete);
                }
                else if(tipo == 3){
                    Frete frete = new FreteAereo(codigo, descricao, distancia, peso, valorFreteBasico);
                    fretes.add(frete);
                }
                else if(tipo == 4){
                    Frete frete = new FretePadrao(codigo, descricao, distancia, peso, valorFreteBasico);
                    fretes.add(frete);
                }
                else{
                    System.out.println("Tipo inválido! Cadastrando como padrão.");
                    Frete frete = new FretePadrao(codigo, descricao, distancia, peso, valorFreteBasico);
                    fretes.add(frete);
                }
                System.out.println("Frete cadastrado!");
            }
            else if(opc == 2){
                System.out.println("\n-- Lista de Fretes --");
                for (Frete f : fretes) {
                    System.out.println("Código: " + f.getCodigo());
                    System.out.println("Descrição: " + f.getDescricao());
                    System.out.println("Distância: " + f.getDistancia() + " km");
                    System.out.println("Peso: " + f.getPeso() + " kg");
                    System.out.println("Frete básico: R$ " + f.getValorFreteBasico());
                    System.out.println("Valor total: R$ " + f.calcularFrete());
                    System.out.println("Tipo: " + f.getClass().getSimpleName());
                    System.out.println("-------------------");
                }
            }
            else if(opc == 3){
                System.out.print("Código da entrega: "); String codigoB = scan.nextLine();
                boolean encontrado = false;
                
                for (Frete f : fretes) {
                    if(codigoB.equals(f.getCodigo())){
                        System.out.println("Valor total do frete: R$ " + f.calcularFrete());
                        encontrado = true;
                        break;
                    }
                }
                
                if(!encontrado){
                    System.out.println("Frete não encontrado!");
                }
            }
            else if(opc == 4){
                System.out.print("Descrição: "); String descricaoC = scan.nextLine();
                System.out.print("Distância (km): "); double distanciaC = scan.nextDouble();
                System.out.print("Peso da carga (kg): "); double pesoC = scan.nextDouble();
                System.out.print("Valor do frete básico: "); double valorFreteBasicoC = scan.nextDouble();
                
                FreteTerrestre terrestre = new FreteTerrestre("", descricaoC, distanciaC, pesoC, valorFreteBasicoC);
                FreteMaritimo maritimo = new FreteMaritimo("", descricaoC, distanciaC, pesoC, valorFreteBasicoC);
                FreteAereo aereo = new FreteAereo("", descricaoC, distanciaC, pesoC, valorFreteBasicoC);
                
                System.out.println("\n-- Comparação de Valores --");
                System.out.println("Frete Terrestre: R$ " + terrestre.calcularFrete());
                System.out.println("Frete Marítimo: R$ " + maritimo.calcularFrete());
                System.out.println("Frete Aéreo: R$ " + aereo.calcularFrete());
            }
            else{
                System.out.println("Saindo...");
                break;
            }
        }while(true);
        scan.close();
    }
}