package poo.lista13q1;

import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();

        do{
            System.out.println("--- BIBLIOTECA ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Buscar Livro (ISBN)");
            System.out.println("3. Buscar Livro (Editora)");
            System.out.println("4. Buscar Livro (Autor)");
            System.out.println("0. Sair");
            System.out.println("--- --- ---");
            System.out.print("Digite a opção: ");
            int opc = scan.nextInt(); scan.nextLine();

            switch (opc) {
                case 1:
                    try{
                        System.out.println("--- LIVRO ---");
                        System.out.print("ISBN: "); String isbn = scan.next();
                        System.out.print("Título: "); String titulo = scan.next();
                        System.out.print("Ano da edição: "); int anoEdicao = scan.nextInt(); scan.nextLine();

                        System.out.println("--- AUTOR ---");
                        System.out.print("Nome: "); String nome = scan.next();
                        System.out.print("Nacionalidade: "); String nacionalidade = scan.next();
                        System.out.print("Data de Nascimento: "); String dataNasc = scan.next();
                        Autor autor = new Autor(nome, nacionalidade, dataNasc);

                        System.out.println("--- EDITORA ---");
                        System.out.print("Código: "); int codigo = scan.nextInt(); scan.nextLine();
                        System.out.print("Nome: "); String nomeEd = scan.next();
                        System.out.print("País de origem: "); String paisOrigem = scan.next();
                        System.out.print("Ano de fundação: "); int fundacao = scan.nextInt(); scan.nextLine();
                        Editora editora = new Editora(codigo, nomeEd, paisOrigem, fundacao);

                        for (Livro l : livros) {
                            if (l.getIsbn().equals(isbn)) {
                                throw new ISBNDuplicadoException("ISBN duplicado: " + isbn);
                            }
                        }
                        Livro livro = new Livro(isbn, titulo, anoEdicao, autor, editora);
                        livros.add(livro);
                        
                    } catch(ISBNDuplicadoException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Digite o ISBN: ");
                    String isbn = scan.next();

                    try {
                        Livro encontrado = null;
                        for (Livro l : livros) {
                            if (l.getIsbn().equals(isbn)) {
                                encontrado = l;
                                break;
                            }
                        }

                        if (encontrado == null) {
                            throw new LivroNaoEncontradoException("Livro não encontrado: " + isbn);
                        }

                        System.out.println("Livro encontrado: " + encontrado.getTitulo() + " de " + encontrado.getAutor().getNome());

                    } catch (LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o código da Editora: ");
                    int codigoEd = scan.nextInt(); scan.nextLine();

                    try {
                        List<Livro> encontradosEd = new ArrayList<>();
                        for (Livro l : livros) {
                            if (l.getEditora() != null && l.getEditora().getCodigo() == codigoEd) {
                                encontradosEd.add(l);
                            }
                        }

                        if (encontradosEd.isEmpty()) {
                            throw new EditoraNaoEncontradaException("Editora não encontrada: " + codigoEd);
                        }

                        System.out.println("Livros da editora (código " + codigoEd + "):");
                        for (Livro l : encontradosEd) {
                            System.out.println("- " + l.getTitulo() + " (" + l.getIsbn() + ") de " + l.getAutor().getNome());
                        }

                    } catch (EditoraNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do Autor: ");
                    String nomeAutor = scan.next();

                    try {
                        List<Livro> encontradosAu = new ArrayList<>();
                        for (Livro l : livros) {
                            if (l.getAutor() != null && l.getAutor().getNome().equalsIgnoreCase(nomeAutor)) {
                                encontradosAu.add(l);
                            }
                        }

                        if (encontradosAu.isEmpty()) {
                            throw new AutorNaoEncontradoException("Autor não encontrado: " + nomeAutor);
                        }

                        System.out.println("Livros do autor " + nomeAutor + ":");
                        for (Livro l : encontradosAu) {
                            System.out.println("- " + l.getTitulo() + " (" + l.getIsbn() + ") — editora: " + l.getEditora().getNome());
                        }

                    } catch (AutorNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.print("Saindo...");
                    break;
            
                default:
                    break;
            }
        }
        while(true);
    }
}
