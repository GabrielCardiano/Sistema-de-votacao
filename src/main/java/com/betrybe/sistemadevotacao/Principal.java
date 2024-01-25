package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Principal principal = new Principal();

    // Etapa 1 -> Cadastro de candidato:
    principal.cadastrarCandidato(gerenciamentoVotacao, scanner);

    // Etapa 2 -> Cadatro de eleitor:
    principal.cadastrarEleitor(gerenciamentoVotacao, scanner);

    // Etapa 3 -> Etapa de votação:
    principal.sistemaDeVotacao(gerenciamentoVotacao, scanner);
  }

  /**
   * Cadastrar candidato.
   *
   * @param gerenciamentoVotacao the gerenciamento votacao
   * @param scanner              the scanner
   */
  public void cadastrarCandidato(GerenciamentoVotacao gerenciamentoVotacao, Scanner scanner) {
    System.out.println("Cadastrar pessoa candidata?\n"
        + "1 - Sim\n"
        + "2 - Não\n"
        + "Entre com o número correspondente à opção desejada:");

    String opcao = scanner.nextLine();

    if ("1".equals(opcao)) {
      System.out.println("Entre com o nome da pessoa candidata:");
      String nome = scanner.nextLine();
      System.out.println("Entre com o número da pessoa candidata:");
      int numero = Integer.parseInt(scanner.nextLine());

      gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);

      cadastrarCandidato(gerenciamentoVotacao, scanner);
    }

    return;
  }

  static void cadastrarEleitor(GerenciamentoVotacao gerenciamentoVotacao, Scanner scanner) {
    System.out.println("Cadastrar pessoa eleitora?\n"
        + "1 - Sim\n"
        + "2 - Não\n"
        + "Entre com o número correspondente à opção desejada:");

    short opcao = Short.parseShort(scanner.nextLine());

    if (opcao == 1) {
      System.out.println("Entre com o nome da pessoa eleitora:");
      String nome = scanner.nextLine();
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpf = scanner.nextLine();

      gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);

      cadastrarEleitor(gerenciamentoVotacao, scanner);
    }

    return;
  }

  static void sistemaDeVotacao(GerenciamentoVotacao gerenciamentoVotacao, Scanner scanner) {
    System.out.println(" Entre com o número correspondente à opção desejada:\n"
        + " 1 - Votar\n"
        + " 2 - Resultado Parcial\n"
        + " 3 - Finalizar Votação");

    short opcao = Short.parseShort(scanner.nextLine());

    if (opcao == 1) {
      System.out.println("Entre com o cpf da pessoa eleitora:");
      String cpfEleitor = scanner.nextLine();
      System.out.println("Entre com o número da pessoa candidata:");
      int numeroCandidato = Integer.parseInt(scanner.nextLine());

      gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);

      sistemaDeVotacao(gerenciamentoVotacao, scanner);
    }

    if (opcao == 2) {
      gerenciamentoVotacao.mostrarResultado();
      sistemaDeVotacao(gerenciamentoVotacao, scanner);
    }

    if (opcao == 3) {
      gerenciamentoVotacao.mostrarResultado();
      return;
    }

    scanner.close();
    return;
  }
}


