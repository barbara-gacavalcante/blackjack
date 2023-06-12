package players;

import java.util.ArrayList;
import java.util.Random;

import entities.Carta;

public class Player extends Dealer {
  private String nome;
  private double saldo;
  private double aposta;
  private static ArrayList<Carta> cartasMao = new ArrayList<Carta>();
  private int pontos = 0;

  private Random random = new Random();

  public Player(String nome, double saldo, double aposta) {
    this.nome = nome;
    this.saldo = saldo;
    this.aposta = aposta;
  }

  public ArrayList<Carta> getCartasMao() {
    return cartasMao;
  }

  public int getPontos() {
    return pontos;
  }

  public double getAposta() {
    return aposta;
  }

  public String getNome() {
    return nome;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setAposta(double aposta) {
    this.aposta = aposta;
  }

  public void gerarMao(ArrayList<Carta> deck) {
    int startingAmount = 2;
    pontos = 0;

    while (cartasMao.size() > 0)
      cartasMao.remove(0);

    for (int i = 0; i < startingAmount; i++) {
      cartasMao.add(deck.get(i));
      pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());
      deck.remove(i);
    }
  }

  public void setSaldo(double res) {
    saldo += res;
  }

  public void mostrarMao() {
    System.out.println("\n\nPLAYER\nMão do jogador: ");
    for (Carta c : cartasMao) {
      System.out.println(c.getValor() + c.getNaipe());
    }
    System.out.println("\nTotal: " + pontos + " pontos.");
  }

  public void pegar(ArrayList<Carta> deck) { // Falta implementar se o ás valera 1 ou 11
    int randomNumber = random.nextInt(deck.size());

    cartasMao.add(deck.get(randomNumber));
    deck.remove(randomNumber);
    System.out.println("\n\nVocê pegou uma carta...\n" + cartasMao.get(cartasMao.size() - 1).getNaipe()
        + cartasMao.get(cartasMao.size() - 1).getValor());
    pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());
    System.out.println("\nTotal: " + pontos + " pontos.");
  }

  public void manter() {
    System.out.println("\n\nVocê manteve sua mão... Agora é a vez do Dealer!");
  }

  public void dadosDoJogo() { // Mostrar resultados anteriores

    System.out.println("\n\nSua mão: ");
    for (Carta c : cartasMao) {
      System.out.println(c.getValor() + c.getNaipe());
    }
    System.out.println("\nPontos: " + pontos);
  }
}
