package application;

import java.util.Scanner;

import entities.Deck;
import players.*;

public class Face {

  private final Controle con = new Controle();
  private Deck deck = new Deck();
  private Dealer dealer = new Dealer();

  public void UI() {
    Scanner sc = new Scanner(System.in);
    int op;

    do {
      System.out.println("\t\t=-=-=-=-=-   BLACKJACK    -=-=-=-=-=\n");
      System.out.println("\t\t=-=-=-=-=-=-=   Menu   =-=-=-=-=-=-=\n");
      System.out.println("\t1 - Novo jogo!");
      System.out.println("\t2 - Regras");
      System.out.println("\t3 - Dados dos Jogos Anteriores");
      System.out.println("\t4 - Creditos");
      System.out.println("\t5 - Finalizar programa");

      System.out.println("\tDigite o numero indicado pelo menu para a opçao desejada: ");
      op = Integer.parseInt(sc.nextLine());
      switch (op) {
        case 1:
          novoJogo();
          break;
        case 2:
          con.regras();
          sc.close();
          UI();
          break;
        case 3:
          // CHECAR DE FUNÇÃO DE HISTORICO ESTA VAZIA
          // dedade.add(fsdfsdfgerger)
          break;
        case 4:
          System.out.println("Criadores: " +
              "\nApanaula bBarbz Luizin Samu" +
              "\nE a perfeita maravilhosa Danizinhaaa!!!");

          sc.close();
          UI();
          break;
        case 5:
          System.out.println("Cabou xauu 😘!!!");
          break;
      }
    } while (true);

  }

  public void novoJogo() {
    Scanner sc = new Scanner(System.in);
    int op;
    boolean jogoAcabado = false;
    double saldo;
    double aposta;
    String nome = new String();
    System.out.println("Digite seu nome:");
    nome = sc.nextLine();
    System.out.println("Quantas bufunfas voce tem!!");
    saldo = Double.parseDouble(sc.nextLine());
    System.out.println("Quanto da bufunfa voce deseja apostar!!");
    aposta = Double.parseDouble(sc.nextLine());
    Player player = new Player(nome, saldo, aposta);

    deck.fillDeckList();
    deck.shuffle();
    player.gerarMao(deck.getDeck());
    player.mostrarMao();
    dealer.gerarMao(deck.getDeck());
    dealer.mostrarMao();
    do {
      System.out.println("\nEstas sao as suas opçoes: ");
      System.out.println("\t1 - Manter a mao. ");
      System.out.println("\t2 - Pegar uma carta");

      System.out.println("\nDigite o numero relacionado a opçao que voce escolheu:");
      op = Integer.parseInt(sc.nextLine());

      // Se ele nao ficou com 21 ele pode pegar outra carta (dentro da rodada), Se
      // ainda nao atingiu 21 ele pode dweiufghweyuogfwe;

      switch (op) {
        case 1:
          player.manter();
          while (dealer.getPontos() < 17)
            dealer.pegar(deck.getDeck());
          dealer.manter();
          con.compararRes(player, dealer);
          jogoAcabado = true;
          break;
        case 2:
          player.pegar(deck.getDeck());
          if (player.getPontos() > 21) {
            while (dealer.getPontos() < 17) {
              dealer.pegar(deck.getDeck());
            }
            dealer.manter();
            con.compararRes(player, dealer);
            jogoAcabado = true;
            break;
          }
          System.out.println(player.getPontos() == 21);
          break;
      }
    } while (!jogoAcabado);
    player.resetar();
    dealer.resetar();
  }
}
