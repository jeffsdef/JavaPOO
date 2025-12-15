package poo.lista12q1;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        do {
            System.out.println("\n-- Menu --");
            System.out.println("1. Cadastrar nova conta.");
            System.out.println("2. Realizar Saque.");
            System.out.println("3. Realizar depósito.");
            System.out.println("4. Transferir entre duas contas.");
            System.out.println("5. Atualizar todas as contas.");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: ");
            int opc = scan.nextInt();
            scan.nextLine();

            try {
                if (opc == 1) {
                    System.out.print("Nome: "); String nome = scan.nextLine();
                    System.out.print("Nº da conta: "); String conta = scan.nextLine();
                    System.out.print("Taxa: R$"); double taxa = scan.nextDouble();
                    System.out.print("Saldo Inicial: R$"); double saldo = scan.nextDouble();
                    
                    Conta corrente = new Corrente(nome, conta, taxa, saldo);
                    contas.add(corrente);
                    System.out.println("Conta cadastrada com sucesso!");
                } 
                else if (opc == 2) {
                    System.out.print("Nº da conta: "); String contaB = scan.nextLine();
                    boolean achou = false;
                    for (Conta c : contas) {
                        if (contaB.equals(c.getConta())) {
                            System.out.print("Valor do saque: R$"); double valor = scan.nextDouble();
                            c.saque(valor);
                            System.out.println("Saque realizado. Novo saldo: " + c.getSaldo());
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) System.out.println("Conta não encontrada.");
                } 
                else if (opc == 3) {
                    System.out.print("Número da conta: "); String contaC = scan.nextLine();
                    boolean achou = false;
                    for (Conta c : contas) {
                        if (contaC.equals(c.getConta())) {
                            System.out.print("Valor do depósito: R$"); double valorB = scan.nextDouble();
                            c.deposito(valorB);
                            System.out.println("Depósito realizado. Novo saldo: " + c.getSaldo());
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) System.out.println("Conta não encontrada.");
                } 
                else if (opc == 4) {
                    System.out.print("Número da conta [pagador]: "); String contaPag = scan.nextLine();
                    System.out.print("Número da conta [recebedor]: "); String contaRec = scan.nextLine();
                    System.out.print("Valor da transferência: R$"); double transf = scan.nextDouble();

                    Conta pagador = null;
                    Conta recebedor = null;

                    for (Conta c : contas) {
                        if (contaPag.equals(c.getConta())) pagador = c;
                        else if (contaRec.equals(c.getConta())) recebedor = c;
                    }

                    if (pagador != null && recebedor != null) {
                        pagador.saque(transf); 
                        recebedor.deposito(transf);
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Uma ou ambas as contas não foram encontradas.");
                    }
                } 
                else if (opc == 5) {
                    for (Conta c : contas) {
                        c.atualizar();
                    }
                    System.out.println("Todas as contas foram atualizadas!");
                } 
                else if (opc == 0) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }

            } catch (SaldoInsuficiente e) {
                System.out.println("\n>>> Erro de Saldo: " + e.getMessage());
            } catch (ValorInvalido e) {
                System.out.println("\n>>> Erro de Valor: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n>>> Ocorreu um erro inesperado: " + e.getMessage());
                scan.nextLine();
            }

        } while (true);
        scan.close();
    }
}