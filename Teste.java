package poo.lista11q2;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Animal> animais = new ArrayList<>();

        do{
            System.out.println("-- MENU --");
            System.out.println("1. Cadastrar animal");
            System.out.println("2. Ação de andar");
            System.out.println("3. Ação de voar");
            System.out.println("4. Ação de nadar");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: "); int opc = scan.nextInt(); scan.nextLine();

            if(opc == 1){
                System.out.println("-- ESCOLHA O TIPO DE ANIMAL --");
                System.out.println("1. Cachorro // 2. Gato // 3. Pato // 4. Peixe");
                System.out.print("Digite: ");
                int tipo = scan.nextInt(); scan.nextLine();

                System.out.print("Nome: "); String nome = scan.nextLine();
                System.out.print("Idade: "); int idade = scan.nextInt(); scan.nextLine();
                System.out.print("Peso: "); double peso = scan.nextDouble();
                System.out.print("Altura: "); double altura = scan.nextDouble();

                switch (tipo) {
                    case 1:
                        Cachorro cachorro = new Cachorro(nome, idade, peso, altura);
                        animais.add(cachorro);
                        break;
                    case 2:
                        Gato gato = new Gato(nome, idade, peso, altura);
                        animais.add(gato);
                        break;
                    case 3:
                        Pato pato = new Pato(nome, idade, peso, altura);
                        animais.add(pato);
                        break;
                    case 4:
                        Peixe peixe = new Peixe(nome, idade, peso, altura);
                        animais.add(peixe);
                    default:
                        System.out.println("Tipo inválido.");
                        return;
                }
            }
            else if(opc == 2){
                for (Animal a : animais) {
                    if(a instanceof PodeAndar){
                        System.out.println(a.getNome() + " andou.");
                    }
                }
            }
            else if(opc == 3){
                for (Animal a : animais) {
                    if(a instanceof PodeVoar){
                        System.out.println(a.getNome() + "voou.");
                    }
                }
            }
            else if(opc == 4){
                for (Animal a : animais) {
                    if(a instanceof PodeNadar){
                        System.out.println(a.getNome() + " nadou.");
                    }
                }
            }
            else{
                System.out.println("Saindo...");
                break;
            }
        }
        while(true);
        scan.close();
    }
}
