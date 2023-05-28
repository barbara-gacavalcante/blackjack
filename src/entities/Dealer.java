package entities;

import java.util.*;
import entities.Carta;
import entities.Deck;

public class Dealer {
    Arraylist<Carta> cartasMao = new ArrayList<Carta>();
    public int quantas = 0;
    public int pontos = 0;

    // Selecionar duas cartas do Deck para cartasMao e removê-las do Deck
    public void gerarMao {
        for (quantas=0;quantas<2;quantas++){
            cartasMao.add(quantas, deck.get(quantas));
            deck.remove(quantas);
        }
    }

    // Mostrar uma carta do Dealer para o Jogador
    public mostrarMao {
        System.out.println("DEALER %nA carta virada para cima é: ");
        System.out.println(cartasMao.getValor(0) + " de " + cartasMao.getNaipe(0)); // ?
    }

    // Calcular a pontuação total das cartas na mão
    public int calcularResultado {
        int contarAs = 0;
        int face = 0;
        // String faceLetra = new String(); diminuir metodo getValor de cartasMao?
        for (int quantas=0;quantas<cartasMao.size();quantas++){
            // Se o valor da carta é numérico, a pontuação é igual o valor da face
            try{
                face = Integer.parseInt(cartasMao.getValor(quantas));
                pontos+=face;
            }
            // Se o valor da carta é A vale 1 ou 11, se é J, Q ou K vale 10
            catch (NumberFormatException ex){
                if(cartasMao.getValor(quantas).contains("A") && contarAs == 0){
                    face = 11;
                    contarAs++;
                } else if (cartasMao.getValor(quantas).contains("A") && contarAs > 0) {
                    face = 1;
                } else if (cartasMao.getValor(quantas).contains("J")
                        || cartasMao.getValor(quantas).contains("Q")
                        || cartasMao.getValor(quantas).contains("K")){ face = 10; }
                pontos+=face;
            }

        }
        return pontos;
    }

    // Manter o número de cartas (17 pontos ou mais) na mão e encerrar jogo
    public manter{
        // Printar as cartas do Dealer e a pontuação dele;
    }

    // Adicionar mais uma carta na mão do dealer
    public pegar{
        cartasMao.add(quantas, deck.get(quantas));
        deck.remove(quantas);
        quantas++;
    }


}