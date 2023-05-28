package application;

import players.*;
import entities.*;

public class Program {

	private static Deck deck = new Deck();

	public static void main(String[] args) {
		Player player = new Player("Jorge", 20000, 2000);

		deck.fillDeckList();
		/*
		 * for (Carta c : deck.getDeck()) {
		 * System.out.println("\nNaipe: " + c.getNaipe() + "\nValor: " + c.getValor());
		 * }
		 */
		player.gerarMao(deck.getDeck());
		player.dadosDoJogo();
	}
}
