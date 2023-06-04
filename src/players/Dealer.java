package players;

import java.util.ArrayList;

import entities.Carta;

public class Dealer extends AbstractPlayer {
  private ArrayList<Carta> cartasMao = new ArrayList<Carta>();
  public int pontos = 0;
  private boolean flag = false;

  // Selecionar duas cartas do Deck para cartasMao e removê-las do Deck
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

  public int getPontos() {
    return pontos;
  }

  // Mostrar uma carta do Dealer para o Jogador
  public void mostrarMao() {
    System.out.println("\n\nDEALER \nA carta virada para cima é: ");
    System.out.println(cartasMao.get(0).getValor() + cartasMao.get(0).getNaipe()); // ?
  }

  // Manter o número de cartas (17 pontos ou mais) na mão e encerrar jogo
  public void manter() {
    System.out.println("\n\nDEALER\nAs cartas que o Dealer possui são: ");

    for (Carta c : cartasMao) {
      System.out.println(c.getValor() + c.getNaipe());
    }
    System.out.println("\nTotalizando " + pontos + " pontos.");
  }

  // Adicionar mais uma carta na mão do dealer
  public void pegar(ArrayList<Carta> deck) {

    cartasMao.add(deck.get(0));
    deck.remove(0);
    System.out.println("\n\nO dealer pegou uma carta..." + cartasMao.get(cartasMao.size() - 1).getNaipe()
        + cartasMao.get(cartasMao.size() - 1).getValor());
    pontos += verifyValue(cartasMao.get(cartasMao.size() - 1).getValor());

  }

  public int verifyValue(String s) {
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