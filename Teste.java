package poo.lista10q1;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        do{
            System.out.println("-- Menu --");
            System.out.println("1. Cadastrar nova conta.");
            System.out.println("2. Realizar Saque.");
            System.out.println("3. Realizar depósito.");
            System.out.println("4. Transferir entre duas contas.");
            System.out.println("5. Atualizar todas as contas.");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: "); int opc = scan.nextInt(); scan.nextLine();

            if(opc == 1){
                System.out.print("Nome: "); String nome = scan.nextLine();
                System.out.print("Nº da conta: "); String conta = scan.nextLine();
                System.out.print("Taxa: R$"); double taxa = scan.nextDouble();
                System.out.print("Saldo: R$"); double saldo = scan.nextDouble();
                Conta corrente = new Corrente(nome, conta, taxa, saldo);
                contas.add(corrente);
            }
            else if(opc == 2){
                System.out.print("Nº da conta: "); String contaB = scan.nextLine();
                for (Conta c : contas) {
                    if(contaB.equals(c.getConta())){
                        System.out.print("Valor do saque: R$"); double valor = scan.nextDouble();
                        c.saque(valor);
                    }
                }
            }
            else if(opc == 3){
                System.out.print("Número da conta: "); String contaC = scan.nextLine();
                for (Conta c : contas) {
                    if(contaC.equals(c.getConta())){
                        System.out.print("Valor do depósito: R$"); double valorB = scan.nextDouble();
                        c.deposito(valorB);
                    }
                }
            }
            else if(opc == 4){
                System.out.print("Número da conta [pagador]: "); String contaPag = scan.nextLine();
                System.out.print("Número da conta [recebedor]: "); String contaRec = scan.nextLine();
                System.out.print("Valor da transferência: R$"); double transf = scan.nextDouble();

                for (Conta c : contas) {
                    if(contaPag.equals(c.getConta())){
                        c.saque(transf);
                    }
                    else if(contaRec.equals(c.getConta())){
                        c.deposito(transf);
                    }
                }

                System.out.println("Transferência realizada");
            }
            else if(opc == 5){
                for (Conta c : contas) {
                    c.atualizar();
                }
                System.out.println("Todas as contas foram atualizadas!");
            }
            else{
                System.out.println("Saindo...");
                break;
            }
        }while(true);
        scan.close();
    }
}
