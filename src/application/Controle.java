package application;

import players.*;

public class Controle {

	public void compararRes(Player player, Dealer dealer) {
	    if (player.getPontos() > dealer.getPontos() && player.getPontos() <= 21) {
	        System.out.println("\n\nVitória do Player! :)");
	        if (player.getPontos() == 21) {
	            System.out.println("\nBLACKJACK! Player ganhou com 21, então ganha 2x o valor da aposta!\n");
	            player.setSaldo(player.getAposta() * 2);
	            return;
	        }
	        System.out.println("\nPlayer ganha o valor da aposta!\n");
	        player.setSaldo(player.getAposta());
	        return;
	    }
	    if (player.getPontos() < dealer.getPontos() && dealer.getPontos() <= 21) {
	        System.out.println("\n\nVitória do Dealer :(");
	        if (dealer.getPontos() == 21) {
	            System.out.println("\nDealer ganhou com 21, então Player perde 2x o valor da aposta.\n");
	            player.setSaldo(-(player.getAposta() * 2));
	            return;
	        }
	        System.out.println("\nPlayer perde o valor da aposta.\n");
	        player.setSaldo(-(player.getAposta()));
	        return;
	    }

	    if (player.getPontos() > 21 && dealer.getPontos() > 21) {
	        System.out.println("\n\nZebra! Dealer e Player perderam!");
	        System.out.println("\nPlayer perde apenas metade do valor apostado!\n");
	        player.setSaldo(-(player.getAposta() / 2));
	        return;
	    } else if (player.getPontos() > 21) {
	        System.out.println("\n\nPlayer perdeu :(");
	        System.out.println("\nPlayer ultrapassou os 21 pontos, então perde o valor da aposta.\n");
	        player.setSaldo(-(player.getAposta()));
	    } else if (dealer.getPontos() > 21) {
	        System.out.println("\n\nVitória do Player! :)");
	        System.out.println("\nDealer ultrapassou os 21 pontos, então o player ganha o valor da aposta!\n");
	        player.setSaldo(+(player.getAposta()));
	    } else if (player.getPontos() == dealer.getPontos() && player.getPontos() < 21) {
	        System.out.println("\n\nEmpate! Ambos têm a mesma pontuação.");
	        System.out.println("\nPlayer recebe metade do valor da aposta.\n");
	        player.setSaldo(player.getAposta() / 2);
	    }
	}

  public void regras() {
    System.out.println("\t\t\t- BLACKJACK GAME -\n");
    System.out.println(
        "\tO projeto do Blackjack, ou Vinte e Um, consiste num jogo competitivo de apostas entre um jogador contra um dealer, que compram cartas, buscando aproximar a soma dos valores das cartas que possuem em até vinte e um. "
            +
            "\nQuem se aproximar mais desse valor, ganha e quem passar do valor, perde imediatamente.\n");
    System.out.println("\t\tREGRAS\n");
    System.out.println("\t1 - O usuário joga contra o Dealer (computador), podendo vencer, perder ou empatar:");
    System.out.println(
        "\t\ta - O jogador ganha se no final da rodada possuir uma pontuação maior que a do Dealer, com até 20 pontos. "
            +
            "\n\t\tSe o jogador obtiver um blackjack (21 pontos), ganha automaticamente se o Dealer não conseguir um Blackjack;");
    System.out.println(
        "\t\tb - O jogador perde automaticamente se ultrapassar 21 pontos em mãos ou se possuir uma pontuação menor que a do Dealer no final da rodada;");
    System.out.println("\t\tc - O jogador empata caso possua a mesma pontuação que o Dealer no final da rodada.");
    System.out.println("\t2 - O deck é composto por 52 cartas, sendo 13 de cada naipe, embaralhadas antes do início de cada rodada;");
    System.out.println("\t3 - As cartas de 2 a 10 têm a pontuação de seus respectivos valores de face;");
    System.out.println("\t4 - As cartas de figura, sendo dama, valete e rei (J, Q e K) valem 10 pontos cada;");
    System.out.println(
        "\t5 - O Ás pode valer 1 ou 11 pontos, o primeiro Ás da mão vale 11 pontos, a partir do segundo Ás da mão, valem 1 ponto;");
    System.out.println("\t6 - O jogador recebe duas cartas do deck viradas para cima;");
    System.out.println("\t7 - O dealer recebe duas cartas do deck, com apenas uma virada para cima;");
    System.out.println("\t8 - O jogador deverá analisar suas cartas e a carta do dealer e escolher entre as opções:");
    System.out.println("\t\ta - Manter: manter sua mão como está e finalizar a rodada;");
    System.out.println("\t\tb - Pegar: adicionar mais uma carta à mão para aproximar-se mais de 21 pontos;");
    System.out.println(
        "\t9 - Quando o jogador selecionar a opção “Manter”, será a vez do Dealer jogar, este irá virar sua segunda carta para cima, e prosseguir automaticamente com sempre as seguintes opções:");
    System.out.println(
        "\t\ta - Se a mão do Dealer tiver 17 pontos ou mais, ele irá Manter e finalizar a própria jogada, finalizando o jogo;");
    System.out.println(
        "\t\tb - Se a mão do Dealer tiver menos de 17 pontos, automaticamente ele irá Pegar uma carta até chegar ou ultrapassar esse valor e então finalizar o jogo;");
    System.out.println(
        "\t10 - A rodada finaliza comparando a mão do jogador e do Dealer e fim de jogo. Nas apostas, dependendo do resultado final, os valores recebidos ou perdidos serão afetados no saldo do jogador.\n");
  }
}
