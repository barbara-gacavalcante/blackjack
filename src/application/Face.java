package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Deck;
import players.*;

public class Face {
  private final Scanner sc = new Scanner(System.in);
  private final Controle con = new Controle();
  private Deck deck = new Deck();
  private Dealer dealer = new Dealer();

  private ArrayList<Player> players = new ArrayList<>();

  public void UI() {

    int op;
    do {
      System.out.println("\t\t=-=-=-=-=-   BLACKJACK    -=-=-=-=-=\n");
      System.out.println("\t\t=-=-=-=-=-=-=   Menu   =-=-=-=-=-=-=\n");
      System.out.println("\t1 - Novo jogo!");
      System.out.println("\t2 - Regras");
      System.out.println("\t3 - Dados dos Jogadores Anteriores");
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
          UI();
          break;
        case 3:
          dadosDosJogadores();
          break;
        case 4:
          System.out.println("Criadores: " +
              "\nApanaula bBarbz Luizin Samu" +
              "\nE a perfeita maravilhosa Danizinhaaa!!!");
          UI();
          break;
        case 5:
          System.out.println("Cabou xauu 😘!!!");
          break;
        default:
          System.out.println("Voce digitou algo que nao esta entre os numeros naturais de 1 a 5. Tente novamente!");
          break;
      }
    } while (op != 5);

    sc.close();

  }

  public void novoJogo() {
    int op, indice;
    boolean jogoAcabado = false;
    double saldo = 0;
    double aposta = 0;
    String nome = new String();
    System.out.println("Digite seu nome:");
    nome = sc.nextLine();

    do {
      try {
        op = 1;
        System.out.println("Quantas bufunfas voce tem (em dinheiro)!!");
        saldo = Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException erro) {
        op = 0;
        System.out.println("Voce digitou um caractere que nao eh numero, meu caro. Digite novamente");
      }
    } while (op == 0);

    do {
      try {
        op = 1;
        System.out.println("Quanto da bufunfa voce deseja apostar (tambem em dinheiro)!!");
        aposta = Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException erro) {
        op = 0;
        System.out.println("Voce digitou um caractere que nao eh numero, meu caro. Digite novamente");
      }
    } while (op == 0);

    indice = 0; // Contar onde esta o player
    op = 0; // Saber se tem na lista.

    for (indice = 0; indice < players.size(); indice++)
      if (players.get(indice).getNome().equalsIgnoreCase(nome)) {
        op = 1;
        System.out.println("\n==============IMPORTANTE==============" +
            "\nEncontramos o teu nome em nossa lista de Players. Voce tem, na verdade, o saldo de R$"
            + players.get(indice).getSaldo() + ", mas vamos manter a aposta!" +
            "\n======================================");
        players.get(indice).setAposta(aposta);
        break;
      }

    if (op == 0)
      players.add(new Player(nome, saldo, aposta));

    deck.fillDeckList();
    deck.shuffle();
    players.get(indice).gerarMao(deck.getDeck());
    players.get(indice).mostrarMao();
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
          players.get(indice).manter();
          while (dealer.getPontos() < 17)
            dealer.pegar(deck.getDeck());
          dealer.manter();
          con.compararRes(players.get(indice), dealer);
          jogoAcabado = true;
          break;
        case 2:
          players.get(indice).pegar(deck.getDeck());
          if (players.get(indice).getPontos() > 21) {
            while (dealer.getPontos() < 17) {
              dealer.pegar(deck.getDeck());
            }
            dealer.manter();
            con.compararRes(players.get(indice), dealer);
            jogoAcabado = true;
            break;
          }
          System.out.println(players.get(indice).getPontos() == 21);
          break;
      }
    } while (!jogoAcabado);

  }

  public void dadosDosJogadores() {

    int indice = 1;
    if (players.size() == 0)
      System.out.println("Ainda nao existe jogadores cadastrados!!");
    else {
      System.out
          .println("Estes sao os dados dos jogadores anteriores, incluindo o nome, o saldo atual e a ultima aposta: ");
      for (Player aux : players) {
        System.out.println("Player " + indice++ + "-> " +
            "\nNome: " + aux.getNome() +
            "\nSaldo atual: RS" + String.format("%.2f", aux.getSaldo()) +
            "\nUltima aposta: R$" + String.format("%.2f", aux.getAposta()) + "\n");
      }
    }
  }
}
