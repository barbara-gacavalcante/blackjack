package players;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entities.Carta;
import entities.Deck;

public class Dealer {
  private ArrayList<Carta> cartasMao = new ArrayList<Carta>();
  public int pontos = 0;
  private boolean flag = false;

  // Selecionar duas cartas do Deck para cartasMao e removê-las do Deck
  public void gerarMao(ArrayList<Carta> deck) {
    int startingAmount = 2;

    for (int i = 0; i < startingAmount; i++) {
      cartasMao.add(deck.get(i));
      pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());
      deck.remove(i);
    }
  }

  // Mostrar uma carta do Dealer para o Jogador
  public void mostrarMao() {
    System.out.println("DEALER \nA carta virada para cima é: ");
    System.out.println(cartasMao.get(0).getValor() + cartasMao.get(0).getNaipe()); // ?
  }

  public void dadosDoJogo() {

    System.out.println("Mão do Dealer: ");
    for (Carta c : cartasMao) {
      System.out.println(c.getValor() + c.getNaipe());
    }
    System.out.println("Pontos:" + pontos);
  }

  // Calcular a pontuação total das cartas na mão
  public int calcularResultado() {
    return this.pontos;
  }

  // Manter o número de cartas (17 pontos ou mais) na mão e encerrar jogo
  public void manter() {
    System.out.println("DEALER\nAs cartas que o Dealer possui são: ");

    for (Carta c : cartasMao) {
      System.out.println(c.getValor() + c.getNaipe());
    }
    System.out.println("Totalizando " + calcularResultado() + " pontos.");
  }

  // Adicionar mais uma carta na mão do dealer
  public void pegar(ArrayList<Carta> deck) {
    cartasMao.add(deck.get(0));
    deck.remove(0);
    cartasMao.set(0, cartasMao.get(1));
    cartasMao.set(1, cartasMao.get(2));
    cartasMao.remove(2);
    System.out.println("O dealer pegou uma carta..." + "\nNaipe: " + cartasMao.get(cartasMao.size() - 1).getNaipe()
        + "\nValor: " + cartasMao.get(cartasMao.size() - 1).getValor());
    pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());
  }

  public int verifyValue(String s) { // Talvez mais organizado na main
    switch (s) {
      case "J":
      case "Q":
      case "K":
        return 10;
      case "A":
        if (!flag) {
          flag = !flag;
          return 11;
        }
        return 1;
      default:
        return Integer.parseInt(s);
    }
  }
}