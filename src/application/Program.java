package application;

import players.*;
import entities.*;

public class Program {

	private static Deck deck = new Deck();

	public static void main(String[] args) {
		Player player = new Player("Jorge", 20000, 2000);
		Dealer dealer = new Dealer();

		deck.fillDeckList();
		deck.shuffle();

		for (Carta c : deck.getDeck()) {
			System.out.println(c.getValor() + c.getNaipe());
		}

		player.gerarMao(deck.getDeck());
		player.dadosDoJogo();
		player.manter();

		dealer.gerarMao(deck.getDeck());
		dealer.mostrarMao();
		dealer.manter();

		// System.out.println("Bah jaguara quantos bufunfa ce tem? "); usar essas
		// palavras pra perguntar o saldo total do player
		// O dealer só pega cartas se < 17

		/*
		 * if (perdeu || dealerGanhou) player.setSaldo(-aposta); // se perdeu acima de
		 * 21 se lascou!!! perdeu tudo COLOCA VALOR NEGATIVO
		 * if (perdeu && dealerPerdeu) player.setSaldo(-aposta/2); // se os dois
		 * perderam perde metade da aposta
		 * 
		 * if (ganhou && dealerPerdeu) player.setSaldo(aposta*3); // se ganhou e o
		 * dealer ta acima de 21 ganha o triplo
		 * if (ganhou) player.setSaldo(aposta*2); // se ganhou e o dealer não
		 * necessariamente passou de 21
		 */
	}
}
