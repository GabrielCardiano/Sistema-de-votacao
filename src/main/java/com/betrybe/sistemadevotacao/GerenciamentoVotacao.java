package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Instantiates a new Gerenciamento votacao.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidato : this.pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    this.pessoasCandidatas.add(novoCandidato);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitor : this.pessoasEleitoras) {
      if (eleitor.getCpf() == cpf) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
    this.pessoasEleitoras.add(novoEleitor);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : this.cpfsComputados) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numeroPessoaCandidata) {
        candidato.receberVoto();
        this.cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    int totalVotos = cpfsComputados.size();

    for (PessoaCandidata candidato : this.pessoasCandidatas) {
      String nomeCandidato = candidato.getNome();
      int votosCandidato = candidato.getVotos();
      double votosPercentuais = Math.round(((double) votosCandidato / totalVotos) * 100);
      System.out.println(
          "Nome: %s - %d votos ( %f%% )".formatted(nomeCandidato, votosCandidato,
              votosPercentuais));
    }
    System.out.println("Total de votos: " + totalVotos);
  }
}
