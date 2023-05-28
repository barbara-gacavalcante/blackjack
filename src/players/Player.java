package players;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entities.Carta;

public class Player {
  private String nome;
  private double saldo;
  private double aposta;
  private static ArrayList<Carta> cartasMao = new ArrayList<Carta>();
  private int pontos;

  private boolean flag = false; // Em duvida se deixo isso aqui ou se faço a verificação do valor na main

  private Random random = new Random();

  public Player(String nome, double saldo, double aposta) {
    this.nome = nome;
    this.saldo = saldo;
    this.aposta = aposta;
  }

  public ArrayList<Carta> getCartasMao() {
    return cartasMao;
  }

  public void gerarMao(ArrayList<Carta> deck) { // Falta implementar se o ás valera 1 ou 11
    int startingAmount = 2;
    int randomNumber;

    for (int i = 0; i < startingAmount; i++) {
      randomNumber = random.nextInt(deck.size());
      cartasMao.add(deck.get(randomNumber));
      pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());
      deck.remove(randomNumber);
    }
  }

  public void mostrarMao() {
    for (Carta c : cartasMao) {
      System.out.println("Naipe:" + c.getNaipe() + "\nValor" + c.getValor());
    }
  }

  public void pegar(ArrayList<Carta> deck) { // Falta implementar se o ás valera 1 ou 11
    int randomNumber = random.nextInt(deck.size());

    cartasMao.add(deck.get(randomNumber));
    deck.remove(randomNumber);
    System.out.println("Você pegou uma carta..." + "\nNaipe: " + cartasMao.get(cartasMao.size() - 1).getNaipe()
        + "\nValor: " + cartasMao.get(cartasMao.size() - 1).getValor());
    pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());
  }

  public void manter() {
    System.out.println("Você manteve sua mão e passou a rodada...");
  }

  public void dadosDoJogo() { // Não sei como implementar (rascunho)

    System.out.println("Sua mão: ");
    for (Carta c : cartasMao) {
      System.out.println("Naipe: " + c.getNaipe() + "\nValor: " + c.getValor());
    }
    System.out.println("Pontos:" + pontos);
  }

  public double calcularAposta() { // Não sei implementar
    return 0.0;
  }

  public int calcularResultado() { // Não sei implementar
    return 0;
  }

  public int verifyValue(String s) { // Talvez mais organizado na main
    Scanner sc = new Scanner(System.in);
    int pt;
    switch (s) {
      case "J":
      case "Q":
      case "K":
        return 10;
      case "A":
        if (!flag) {
          flag = !flag;
          System.out.println("Você puxou um ás, ele valerá 1 ou 11 (você tem " + pontos + " pontos):");
          do {
            pt = Integer.parseInt(sc.nextLine());
          } while (pt != 1 || pt != 11);
          return pt;
        } else
          return 1;
      default:
        return Integer.parseInt(s);
    }
  }
}
