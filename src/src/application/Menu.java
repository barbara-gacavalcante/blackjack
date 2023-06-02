package application;

import players.*;
import entities.*;
import javax.swing.JOptionPane;
import java.util.*;

class Menu {

    final int DEALERLIMIT = 17;
    final int LIMIT = 21;

    Scanner sc = new Scanner(System.in);

    private static Deck deck = new Deck();

    Player player = new Player();
    Dealer dealer = new Dealer();

    public void regras () {

        System.out.println("\t\t\t- BLACKJACK GAME -\n");
        System.out.println("\tO projeto do Blackjack, ou Vinte e Um, consiste num jogo competitivo de apostas entre um jogador contra um dealer, que compram cartas, buscando aproximar a soma dos valores das cartas que possuem em até vinte e um. " +
                "\nQuem se aproximar mais desse valor, ganha e quem passar do valor, perde imediatamente.\n");
        System.out.println("\t\tREGRAS\n");
        System.out.println("\t1 - O usuário joga contra o Dealer (computador), podendo vencer, perder ou empatar:");
        System.out.println("\t\ta - O jogador ganha se no final da rodada possuir uma pontuação maior que a do Dealer, com até 20 pontos. " +
                "\n\t\tSe o jogador obtiver um blackjack (21 pontos com as duas cartas), ganha automaticamente se o Dealer também não ter um blackjack;");
        System.out.println("\t\tb - O jogador perde automaticamente se ultrapassar 21 pontos em mãos ou se possuir uma pontuação menor que a do Dealer no final da rodada;");
        System.out.println("\t\tc - O jogador empata caso possua a mesma pontuação que o Dealer no final da rodada.");
        System.out.println("\t2 - O deck é composto por 52 cartas (ou múltiplos), sendo 13 de cada naipe;");
        System.out.println("\t3 - As cartas de 2 a 10 têm a pontuação de seus respectivos valores de face;");
        System.out.println("\t4 - As cartas de dama, valete e rei (J, Q e K) valem 10 pontos;");
        System.out.println("\t5 - O Ás pode valer 1 ou 11 pontos, dependendo do que for mais vantajoso para a mão dos jogadores, *a partir do segundo Ás, vale 1;");
        System.out.println("\t6 - O jogador recebe duas cartas do deck viradas para cima;");
        System.out.println("\t7 - O dealer recebe duas cartas do deck, com apenas uma virada para cima;");
        System.out.println("\t8 - O jogador deverá analisar a carta do dealer e escolher entre as opções:");
        System.out.println("\t\ta - Manter: manter sua mão como está e finalizar a rodada;");
        System.out.println("\t\tb - Pegar: adicionar mais uma carta à mão para aproximar-se mais de 21 pontos;");
        System.out.println("\t\tc - *Dobrar: caso houver apostas, você pode pegar apenas uma carta a mais e dobrar sua aposta, e finalizar sua jogada;");
        System.out.println("\t\td - *Dividir: se sua mão veio com dois Ás, você poderá dividir sua jogada em duas mãos, como se fossem dois jogos diferentes " +
                "\n\t\t(caso não tenha essa opção, a partir do segundo Ás seria contado como pontuação 1, a opção de dividir também pode servir para outras cartas duplicadas);");
        System.out.println("\t\te - *Desistir: caso houver apostas, a opção de desistir encerraria a rodada imediatamente e devolveria metade do seu dinheiro apostado de volta.");
        System.out.println("\t9 - Quando o jogador selecionar a opção “Manter”, será a vez do Dealer jogar, irá virar sua segunda carta para cima, e prosseguir automaticamente com sempre as seguintes opções:");
        System.out.println("\t\ta - Se a mão do Dealer tiver 17 ou mais, ele irá Manter e finalizar a própria jogada e finalizar o jogo;");
        System.out.println("\t\tb - Se a mão do Dealer tiver uma pontuação menor que 17, automaticamente ele irá Pegar uma carta até chegar ou ultrapassar esse valor;");
        System.out.println("\t10 - A rodada finaliza comparando a mão do jogador e do Dealer, se houver apostas, dependendo do resultado final, os valores recebidos ou perdidos serão afetados.\n");
        JOptionPane.showMessageDialog(null, "As regras do jogo estao no terminal. Leia-as!");
    }


    public void compararResultados() {

        int playerPoints = player.calcularResultado();
        int dealerPoints = dealer.calcularResultado();

        if (dealerPoints > LIMIT) {
            System.out.println("Player ganhou! Porque o Dealer tem mais de 21 pontos!");
            dealer.dadosDoJogo();
        } else if (playerPoints == dealerPoints) {
            System.out.println("Empate entre o Player e o Dealer!");
            player.dadosDoJogo();
            dealer.dadosDoJogo();
        } else if (playerPoints == LIMIT) {
            System.out.println("O Player ganhou com um Blackjack!!");
            player.dadosDoJogo();
        } else if (dealerPoints == LIMIT) {
            System.out.println("O Dealer ganhou com um Blackjack!!");
            dealer.dadosDoJogo();
        } else if (playerPoints > dealerPoints) {
            System.out.println("O Player ganhou!");
            player.dadosDoJogo();
            dealer.dadosDoJogo();
        } else {
            System.out.println("O Dealer ganhou!");
            dealer.dadosDoJogo();
        }

    }
    public void novoJogo () {

        int i;

        deck.fillDeckList();
        deck.shuffle();

        for (Carta c : deck.getDeck()) {
            System.out.println(c.getValor() + c.getNaipe());
        }

        player.gerarMao(deck.getDeck());
        player.dadosDoJogo();

        dealer.gerarMao(deck.getDeck());
        dealer.mostrarMao();

        do {

            System.out.println("\nEstas sao as suas opçoes para terminar a rodada: ");
            System.out.println("\t1 - Manter a mao. ");
            System.out.println("\t2 - Pegar uma carta");

            System.out.println("\nDigite o numero relacionado a opçao que voce escolheu:");

            i = sc.nextInt();
            sc.nextLine();

            if (i == 1)
                player.manter();
            else if (i == 2)
                player.pegar(deck.getDeck());
            else
                System.out.println("Voce nao selecionou nenhuma das opçoes! Tente de novo!!\n");

        } while (i < 1 || i > 2);

        if (player.calcularResultado() > LIMIT) {
            System.out.println("Player, voce perdeu! Tinha mais de 21 pontos!");
            player.dadosDoJogo();
        }else {
            if (dealer.calcularResultado() < DEALERLIMIT)
                while (dealer.calcularResultado() < DEALERLIMIT)
                    dealer.pegar(deck.getDeck());
            else
                dealer.manter();

            compararResultados();
        }



    }

    public void dadosDoJogo() {

        if (player.calcularResultado() == 0)
            System.out.println("Ainda nao teve um jogo para ver seus dados");
        else {
            player.dadosDoJogo();
            dealer.dadosDoJogo();
        }
    }

    public void creditos() {

        System.out.println("Todos os creditos para Barbara, Ana Paula, Samuel e Luiz©\n Obrigado por tudo, Dany!"); // Temporario

    }

    public void opcoes () {

        int i;

        do {
            System.out.println("\t\t=-=-=-=-=-   BLACKJACK    -=-=-=-=-=\n");
            System.out.println("\t\t=-=-=-=-=-=-=   Menu   =-=-=-=-=-=-=\n");
            System.out.println("\t1 - Novo jogo!");
            System.out.println("\t2 - Regras");
            System.out.println("\t3 - Dados do Jogo!");
            System.out.println("\t4 - Creditos");
            System.out.println("\t5 - Sair do Jogo");

            System.out.println("\tDigite o numero indicado pelo menu para a opçao desejada: ");

            i = sc.nextInt();
            sc.nextLine();

            if (i == 1)
                novoJogo();
            else if (i == 2)
                regras();
            else if (i == 3)
                dadosDoJogo();
            else if (i == 4)
                creditos();
            else if (i == 5)
                System.out.println("Ate mais e volte a jogar de novo em breve!!");


            if (i < 0 || i > 5) {
                System.out.println("Voce nao digitou uma opcao valida! Digite os numeros entre 1 e 5! ");
            }
        } while (i != 5);

        sc.close();

    }



}
