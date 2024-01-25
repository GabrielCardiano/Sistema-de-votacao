package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Instantiates a new Pessoa candidata.
   *
   * @param nome    the nome
   * @param numeros the numeros
   */
  public PessoaCandidata(String nome, int numeros) {
    this.nome = nome;
    this.numero = numeros;
    this.votos = 0;
  }

  public int receberVoto() {
    return this.votos += 1;
  }

  //  getters e setters
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }
}
