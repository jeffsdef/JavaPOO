package poo.lista11q1;

import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<ObjetoGeometrico> objetos = new ArrayList<>();

        do{
            System.out.println("-- MENU --");
            System.out.println("1. Adicionar círculo.");
            System.out.println("2. Adicionar retângulo.");
            System.out.println("3. Média das áreas.");
            System.out.println("4. Média dos perímetros.");
            System.out.println("0. SAIR");
            System.out.print("Digite a opção: ");
            int opc = scan.nextInt(); scan.nextLine();

            if(opc == 1){
                cadCirculo(scan, objetos);
            }
            else if(opc == 2){
                cadRetangulo(scan, objetos);
            }
            else if(opc == 3){
                MediaAreas(scan, objetos);
            }
            else if(opc == 4){
                MediaPerimetros(scan, objetos);
            }
            else{
                System.out.println("Saindo...");
                break;
            }
        }
        while(true);
    }

    public static void cadCirculo(Scanner scan, List<ObjetoGeometrico> objetos){
        System.out.println("-- CíRCULO --");
        System.out.print("Raio: "); double raio = scan.nextDouble();
        System.out.print("Valor de pi: "); double pi = scan.nextDouble();
        Circulo circulo = new Circulo(raio, pi);
        objetos.add(circulo);
    }

    public static void cadRetangulo(Scanner scan, List<ObjetoGeometrico> objetos){
        System.out.println("-- RETÂNGULO --");
        System.out.print("Base: "); double base = scan.nextDouble();
        System.out.print("Altura: "); double altura = scan.nextDouble();
        Retangulo retangulo = new Retangulo(base, altura);
        objetos.add(retangulo);
    }

    public static void MediaAreas(Scanner scan, List<ObjetoGeometrico> objetos){
        if(objetos.isEmpty()) {
            System.out.println("Nenhum objeto geométrico cadastrado!");
            return;
        }
        
        double soma = 0;
        for(ObjetoGeometrico obj : objetos) {
            soma += obj.calcularArea();
        }
        double media = soma / objetos.size();
        System.out.println("Média das áreas: " + media);
    }

    public static void MediaPerimetros(Scanner scan, List<ObjetoGeometrico> objetos){
         if(objetos.isEmpty()) {
            System.out.println("Nenhum objeto geométrico cadastrado!");
            return;
        }
        
        double soma = 0;
        for(ObjetoGeometrico obj : objetos) {
            soma += obj.calcularPerimetro();
        }
        double media = soma / objetos.size();
        System.out.println("Média dos perímetros: " + media);
    }
}
