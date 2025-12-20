package poo.lista13q2;
import java.util.*;

public class Teste { 
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
       
        List<Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU DE CONTAS ---");
            System.out.println("1 - Criar conta (Corrente/Poupanca)");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Atualizar todas as contas");
            System.out.println("6 - Sair");
            System.out.print("Escolha a opção: ");
            int op = scan.nextInt(); scan.nextLine();

            if (op == 1) {
                System.out.print("Tipo de conta (Corrente/Poupanca): ");
                String opConta = scan.nextLine();
                System.out.print("Nome do cliente: ");
                String nome = scan.nextLine();
                System.out.print("CPF do cliente: ");
                String cpf = scan.nextLine();
                Cliente cliente = new Cliente(nome, cpf);
                System.out.print("Número da conta: ");
                int numero = scan.nextInt();
                System.out.print("Taxa (ex: 0.01): ");
                double taxa = scan.nextDouble();
                System.out.print("Saldo inicial: ");
                double saldo = scan.nextDouble();
                scan.nextLine();

                if (opConta.equalsIgnoreCase("Corrente")) {
                    ContaCorrente cc = new ContaCorrente(cliente, numero, taxa, saldo);
                    contas.add(cc);
                    System.out.println("Conta corrente criada.");
                } else {
                    ContaPoupanca cp = new ContaPoupanca(cliente, numero, taxa, saldo);
                    contas.add(cp);
                    System.out.println("Conta poupança criada.");
                }
            }

            else if (op == 2) {
                System.out.print("Número da conta para saque: ");
                int num = scan.nextInt();
                System.out.print("Valor a sacar: ");
                double valor = scan.nextDouble();
                scan.nextLine();
                try {
                    if (valor < 0) throw new ValorInvalidoException();
                    boolean encontrou = false;
                    for (Conta c : contas) {
                        if (num == c.getNumero()) {
                            encontrou = true;
                            if (valor > c.getSaldo()) throw new SaldoInsuficienteException();
                            c.Sacar(valor);
                            System.out.println("Saque realizado.");
                            break;
                        }
                    }
                    if (!encontrou) System.out.println("Conta não encontrada.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            else if (op == 3) {
                System.out.print("Número da conta para depósito: ");
                int num = scan.nextInt();
                System.out.print("Valor a depositar: ");
                double valor = scan.nextDouble();
                scan.nextLine();
                try {
                    if (valor < 0) throw new ValorInvalidoException();
                    boolean encontrou = false;
                    for (Conta c : contas) {
                        if (num == c.getNumero()) {
                            c.Depositar(valor);
                            System.out.println("Depósito realizado.");
                            encontrou = true;
                            break;
                        }
                    }
                    if (!encontrou) System.out.println("Conta não encontrada.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            else if (op == 4) {
                System.out.print("Número da conta origem: ");
                int numOrigem = scan.nextInt();
                System.out.print("Número da conta destino: ");
                int numDestino = scan.nextInt();
                System.out.print("Valor a transferir: ");
                double valorT = scan.nextDouble();
                scan.nextLine();
                try {
                    if (valorT < 0) throw new ValorInvalidoException();
                    Conta origem = null, destino = null;
                    for (Conta c : contas) {
                        if (c.getNumero() == numOrigem) origem = c;
                        if (c.getNumero() == numDestino) destino = c;
                    }
                    if (origem == null || destino == null) {
                        System.out.println("Conta origem ou destino não encontrada.");
                    } else {
                        if (valorT > origem.getSaldo()) throw new SaldoInsuficienteException();
                        origem.Sacar(valorT);
                        destino.Depositar(valorT);
                        System.out.println("Transferência realizada.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            else if (op == 5) {
                for (Conta c : contas) {
                    c.Atualizar();
                }
                System.out.println("Todas as contas foram atualizadas.");
            }

            else if (op == 6) {
                System.out.println("Saindo...");
                break;
            }
        }
    }
}
