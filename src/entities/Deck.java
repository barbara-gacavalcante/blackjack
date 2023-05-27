package entities;

import java.util.*;


public class Deck {

	String[] valor = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K" };
	String[] naipe = { "♠", "♦", "♥", "♣" };
	private static final ArrayList<Carta> deck = new ArrayList<Carta>();
	
	//Preencher o deck com cada combinação de um valor com o naipe
	public void fillDeckList() {
		for (String n : naipe) {
			for (String v : valor) {
				Carta carta = new Carta(n, v);
				deck.add(carta);
			}
		}
	}
	
	//Embaralhamento Fisher-Yates
	public void shuffle() {
        Random rd = new Random();
        
        for (int i = deck.size() - 1; i > 0; i--) {
        	int j = rd.nextInt(i + 1);
        	Carta temp = deck.get(i);
        	
        	deck.set(i, deck.get(j));
        	deck.set(j, temp);
        	
        }
    }
	
	//Fornecer as cartas iniciais de cada jogador antes de excluí-las do baralho 
	public ArrayList<Carta> getDeck(){
		
		ArrayList<Carta> cards = new ArrayList<>();
		
		Random rd = new Random();
		int card1 = rd.nextInt(deck.size());
		cards.add(deck.remove(card1));
		
		int card2 = rd.nextInt(deck.size());
		cards.add(deck.remove(card2));
		
		return cards;
	}
}

