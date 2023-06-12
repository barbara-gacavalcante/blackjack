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
	        System.out.println("\t1 - Novo jogo");
	        System.out.println("\t2 - Regras");
	        System.out.println("\t3 - Dados dos Jogadores Anteriores");
	        System.out.println("\t4 - Créditos");
	        System.out.println("\t5 - Finalizar programa");

	        System.out.println("\tDigite o número indicado pelo menu para selecionar a opção desejada: ");
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
	                System.out.println("\n\nCriadores: " +
	                        "\nAna Paula Chaves Cabral" +
	                        "\nBárbara Geovanna Alves Cavalcante" +
	                        "\nLuiz Henrique dos Santos Souza" +
	                        "\nSamuel da Silva Ferreira" +
	                        "\n\nDisciplina: Linguagem de Programação I" +
	                        "\nProfessora: Danielle Rousy Dias Ricarte\n\n");
	                UI();
	                break;
	            case 5:
	                System.out.println("\n\nFinalizando aplicação. Agradecemos por jogar! :)");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("\n\nVocê digitou algo que não está entre as opções de 1 a 5 do menu. \nDigite um valor válido!");
	                break;
	        }
	    } while (op != 5);
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
        System.out.println("Qual o valor do seu saldo inicial (Formato válido: 00.00)?");
        saldo = Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException erro) {
        op = 0;
        System.out.println("Você digitou um caractere que não é número. Digite um valor válido.");
      }
    } while (op == 0);

    do {
        try {
            op = 1;
            System.out.println("Qual é o valor da sua aposta (Formato válido: 00.00)?");
            aposta = Double.parseDouble(sc.nextLine());
            
            if (aposta > saldo) {
                System.out.println("\nA aposta não pode ser maior que o saldo disponível.\n\n");
                op = 0;
            }
        } catch (NumberFormatException erro) {
            op = 0;
            System.out.println("Você digitou um caractere que não é número. Digite um valor válido.");
        }
    } while (op == 0);

    indice = 0; // Contar onde esta o player
    op = 0; // Saber se tem na lista.

    for (indice = 0; indice < players.size(); indice++)
      if (players.get(indice).getNome().equalsIgnoreCase(nome)) {
        op = 1;
        System.out.println("\n==================================IMPORTANTE==================================" +
            "\n\nEncontramos o seu nome em nossa lista de Players. Você tem um saldo de R$ "
            + players.get(indice).getSaldo() + ", mas iremos manter a aposta!" +
            "\n\n\n==============================================================================");
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
      System.out.println("\nOpções de jogadas disponíveis:");
      System.out.println("\t1 - Manter as cartas da mão.");
      System.out.println("\t2 - Pegar uma carta.");

      System.out.println("\nDigite o numero relacionado a opção escolhida:");
      op = Integer.parseInt(sc.nextLine());

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
          break;
      }
    } while (!jogoAcabado);

  }

  public void dadosDosJogadores() {

    int indice = 1;
    if (players.size() == 0)
      System.out.println("\n\nAinda não existem jogadores cadastrados!\n\n\n\n");
    else {
      System.out
          .println("\n\nEstes são os dados dos jogadores anteriores, incluindo o nome, o saldo atual e o valor da última aposta: ");
      for (Player aux : players) {
        System.out.println("Player " + indice++ + " -> " +
            "\nNome: " + aux.getNome() +
            "\nSaldo atual: RS " + String.format("%.2f", aux.getSaldo()) +
            "\nÚltima aposta: R$ " + String.format("%.2f", aux.getAposta()) + "\n");
      }
    }
  }
}
