package poo.lista12q2;

import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Frete> fretes = new ArrayList<>();

        do {
            System.out.println("\n-- Menu --");
            System.out.println("1. Cadastrar um novo frete");
            System.out.println("2. Listar todos os fretes cadastrados");
            System.out.println("3. Calcular o valor de um frete individual");
            System.out.println("4. Comparar o valor do frete entre os três tipos de transporte");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: "); int opc = scan.nextInt(); 
            scan.nextLine(); 

            try {
                if (opc == 1) {
                    System.out.print("Código da entrega: ");
                    String codigo = scan.nextLine();

                    // VERIFICAÇÃO DE CÓDIGO DUPLICADO
                    for (Frete f : fretes) {
                        if (f.getCodigo().equals(codigo)) {
                            throw new CodigoDuplicado("Já existe um frete cadastrado com o código: " + codigo);
                        }
                    }

                    System.out.print("Descrição: "); String descricao = scan.nextLine();
                    System.out.print("Distância (km): "); double distancia = scan.nextDouble();
                    System.out.print("Peso da carga (kg): "); double peso = scan.nextDouble();
                    System.out.print("Valor do frete básico: "); double valorFreteBasico = scan.nextDouble();

                    System.out.println("Tipo de frete: [1] Terrestre, [2] Marítimo, [3] Aéreo, [4] Padrão");
                    System.out.print("Digite o tipo: "); int tipo = scan.nextInt(); scan.nextLine();

                    Frete frete;
                    if (tipo == 1) frete = new FreteTerrestre(codigo, descricao, distancia, peso, valorFreteBasico);
                    else if (tipo == 2) frete = new FreteMaritimo(codigo, descricao, distancia, peso, valorFreteBasico);
                    else if (tipo == 3) frete = new FreteAereo(codigo, descricao, distancia, peso, valorFreteBasico);
                    else frete = new FretePadrao(codigo, descricao, distancia, peso, valorFreteBasico);

                    fretes.add(frete);
                    System.out.println("Frete cadastrado com sucesso!");

                } else if (opc == 2) {
                    // VERIFICAÇÃO DE LISTA VAZIA
                    if (fretes.isEmpty()) {
                        throw new ListaFretesVazia("A lista de fretes está vazia. Cadastre algo primeiro.");
                    }

                    System.out.println("\n-- Lista de Fretes --");
                    for (Frete f : fretes) {
                        System.out.println("Código: " + f.getCodigo() + " | Tipo: " + f.getClass().getSimpleName());
                        System.out.println("Valor Final: R$ " + f.calcularFrete());
                        System.out.println("-------------------");
                    }

                } else if (opc == 3) {
                    if (fretes.isEmpty()) {
                        throw new ListaFretesVazia("Não há fretes para pesquisar.");
                    }

                    System.out.print("Código da entrega: ");
                    String codigoB = scan.nextLine();
                    boolean encontrado = false;

                    for (Frete f : fretes) {
                        if (codigoB.equals(f.getCodigo())) {
                            System.out.println("Valor total do frete (" + f.getDescricao() + "): R$ " + f.calcularFrete());
                            encontrado = true;
                            break;
                        }
                    }

                    // VERIFICAÇÃO DE FRETE NÃO ENCONTRADO
                    if (!encontrado) {
                        throw new FreteNaoEncontrado("Nenhum frete localizado com o código: " + codigoB);
                    }

                } else if (opc == 4) {
                    System.out.print("Descrição: "); String descricaoC = scan.nextLine();
                    System.out.print("Distância (km): "); double distanciaC = scan.nextDouble();
                    System.out.print("Peso da carga (kg): "); double pesoC = scan.nextDouble();
                    System.out.print("Valor do frete básico: "); double valorFreteBasicoC = scan.nextDouble();

                    FreteTerrestre t = new FreteTerrestre("", descricaoC, distanciaC, pesoC, valorFreteBasicoC);
                    FreteMaritimo m = new FreteMaritimo("", descricaoC, distanciaC, pesoC, valorFreteBasicoC);
                    FreteAereo a = new FreteAereo("", descricaoC, distanciaC, pesoC, valorFreteBasicoC);

                    System.out.println("\n-- Comparativo --");
                    System.out.println("Terrestre: R$ " + t.calcularFrete());
                    System.out.println("Marítimo:  R$ " + m.calcularFrete());
                    System.out.println("Aéreo:     R$ " + a.calcularFrete());

                } else if (opc == 0) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }

            } catch (CodigoDuplicado | ListaFretesVazia | FreteNaoEncontrado e) {
                System.out.println("\n>>> ERRO: " + e.getMessage());
            } catch (Exception e) {
                // Captura outros erros genéricos dentro das operações
                System.out.println("\n>>> Ocorreu um erro: " + e.getMessage());
                scan.nextLine(); 
            }

        } while (true);
        scan.close();
    }
}