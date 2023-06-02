package entities;

import java.util.*;

public class Deck {

	String[] valor = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K" };
	String[] naipe = { "PAUS", "OURO", "COPAS", "ESPADAS" };
	private static final ArrayList<Carta> deck = new ArrayList<Carta>();

	// Preencher o deck com cada combinação de um valor com um naipe
	public void fillDeckList() {
		for (String n : naipe) {
			for (String v : valor) {
				Carta carta = new Carta(n, v);
				deck.add(carta);
			}
		}
	}

	// Embaralhamento Fisher-Yates
	public void shuffle() {
		Random rd = new Random();

		for (int i = deck.size() - 1; i > 0; i--) {
			int j = rd.nextInt(i + 1);
			Carta temp = deck.get(i);

			deck.set(i, deck.get(j));
			deck.set(j, temp);

		}
	}

	public ArrayList<Carta> getDeck() {
		return deck;
	}
}
