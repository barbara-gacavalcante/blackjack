# Blackjack Game - OOP Final Project

**Título do Projeto:** Blackjack

**Disciplina:** Linguagem de Programação I (Programação Orientada a Objetos em Java)

**Professora:** Prof. Dra. Danielle Rousy Dias Ricarte

**Equipe de desenvolvedores:**
- Ana Paula Chaves Cabral
- Bárbara Geovanna Alves Cavalcante
- Luiz Henrique dos Santos Souza
- Samuel da Silva Ferreira


## INTRODUÇÃO

O projeto do jogo ***Blackjack***, também conhecido como *Vinte e Um*, consiste num famoso jogo de baralho de apostas entre um jogador contra um Dealer, que compram cartas, buscando aproximar a soma de pontuação das cartas que possuem em até 21. Quem se aproximar mais desse valor, ganha e quem passar do valor, perde imediatamente.

Para a criação do jogo, os desenvolvedores pesquisaram acerca do funcionamento dos jogos de Blackjack e definiram o conjunto de regras utilizadas para explicar o jogo de forma simples e também como guia para efetuar a modelagem do problema, com algumas adaptações em relação aos jogos do mundo real para uma melhor experiência de usuário. Podemos ver as regras de funcionamento do jogo definidas a seguir: 

### Regras Blackjack

1. O usuário joga contra o Dealer (computador), podendo vencer, perder ou empatar:
    - O jogador ganha se no final da rodada possuir uma pontuação maior que a do Dealer, com até 20 pontos.Se o jogador obtiver um blackjack (21 pontos), ganha automaticamente se o Dealer não conseguir um Blackjack;
    - O jogador perde automaticamente se ultrapassar 21 pontos em mãos ou se possuir uma pontuação menor que a do Dealer no final da rodada;
    - O jogador empata caso possua a mesma pontuação que o Dealer no final da rodada.
2. O deck é composto por 52 cartas, sendo 13 de cada naipe, embaralhadas antes do início de cada rodada;
3. As cartas de 2 a 10 têm a pontuação de seus respectivos valores de face;
4. As cartas de figura, sendo dama, valete e rei (J, Q e K) valem 10 pontos cada;
5. O Ás pode valer 1 ou 11 pontos, o primeiro Ás da mão vale 11 pontos, a partir do segundo Ás da mão, valem 1 ponto;
6. O jogador recebe duas cartas do deck viradas para cima;
7. O dealer recebe duas cartas do deck, com apenas uma virada para cima;
8. O jogador deverá analisar suas cartas e a carta do dealer e escolher entre as opções: 
    - Manter: manter sua mão como está e finalizar a rodada; 
    - Pegar: adicionar mais uma carta à mão para aproximar-se mais de 21 pontos; 
9. Quando o jogador selecionar a opção “Manter”, será a vez do Dealer jogar, este irá virar sua segunda carta para cima, e prosseguir automaticamente com sempre as seguintes opções: 
    - Se a mão do Dealer tiver 17 pontos ou mais, ele irá Manter e finalizar a própria jogada, finalizando o jogo; 
    - Se a mão do Dealer tiver menos de 17 pontos, automaticamente ele irá Pegar uma carta até chegar ou ultrapassar esse valor e então finalizar o jogo; 
10. A rodada finaliza comparando a mão do jogador e do Dealer e fim de jogo. Nas apostas, dependendo do resultado final, os valores recebidos ou perdidos serão afetados no saldo do jogador.


## MODELAGEM

<details>
<summary>Ver imagem da UML</summary>
  
![UML - Blackjack](https://github.com/barbara-gacavalcante/blackjack/assets/111505580/6a954dff-ae5e-45cf-843a-839d1f5cf727 "UML do Blackjack")


</details>


## FERRAMENTAS UTILIZADAS

O jogo foi desenvolvido na linguagem Java, utilizando conceitos de Programação Orientada à Objetos, e foram usadas as IDEs: IntelliJ IDEA, Eclipse IDE e Visual Studio Code. As IDEs foram utilizadas de acordo com a preferência de cada desenvolvedor, e o jogo foi testado utilizando cada uma para observar seu comportamento em cada uma delas.

A pasta fonte foi dividida em 3 pacotes principais, sendo estes: “application”, “entities” e “players”. 

### Application

O pacote “application” contém as classes responsáveis por executar e controlar o jogo. Sendo estas:
- Program: trata-se da classe principal, que possui o método “main”, responsável por iniciar a execução do jogo. Sua função, basicamente, é instanciar a classe “Face” e chamar o seu método “UI” – redirecionando o usuário para o menu principal.
- Face: é a classe que lida com a interface de usuário, mediando as interações com o jogador. Como já foi mencionado, possui o método “UI” (sigla para User Interface), ou seja, é a classe que recebe a entrada com a escolha do usuário (dentre as opções: iniciar um novo jogo, verificar as regras, mostrar dados dos jogadores anteriores, exibir os créditos – informações dos desenvolvedores – e, por fim, finalizar a aplicação). Além deste, a classe também apresenta os métodos para iniciar um novo jogo e exibir os dados dos jogos anteriores.
- Controle: refere-se à classe responsável por realizar o controle e a lógica do jogo. Seus métodos são: Comparar os resultados entre os jogadores e exibir as regras da aplicação.

### Entities

Quanto ao pacote “entities”, é onde são definidas as classes relacionadas à apresentação de cartas e do baralho em si. Ele é composto por:

- Carta: classe responsável por representar a carta de baralho, formada pelos atributos naipe e valor, e pelos métodos construtores, getters e setters e toString.
- Deck: classe responsável por representar o baralho, formada pelos atributos valor, naipe e deck (um ArrayList de cartas), e pelos métodos:
fillDeckList: usado para o preenchimento do baralho com todas as combinações possíveis de valores e naipes, adicionando cada objeto do tipo “Carta” à lista “deck”.
- shuffle: faz uso do algoritmo de Fisher-Yates para embaralhar as cartas, garantindo que seja impossível para o jogador prever as cartas do Dealer ou as que ele próprio pode pegar nas próximas jogadas.
- getDeck: usado para retornar as cartas.

### Players

Por fim, o pacote “players” é constituído por uma interface (“IPlayerInterface”), que define os métodos de gerar a “mão” inicial (isto é, as cartas que serão designadas inicialmente para os jogadores), de mostrar a “mão”, de manter as cartas e de pegar uma nova carta, bem como pelas classes:

- Dealer: implementa a interface e representa o dealer (jogador adversário, neste caso sendo o próprio computador). Em resumo, ela implementa os métodos da interface, considerando algumas limitações:  
    - Só é mostrada 1 única carta da mão do dealer;  
    - O dealer só escolhe pegar a carta se, ao somar os pontos das cartas em sua mão, o resultado for menor que 17.
- Player: herda a classe “Dealer” e representa o usuário. Seu diferencial é que é composta pelos atributos “nome”, “saldo”, “aposta” e “pontos”, permitindo que esses dados sejam armazenados e facilmente acessados enquanto a aplicação está em execução. Além disso, também implementa os métodos da interface.


## CONCLUSÃO

Durante todo o processo de desenvolvimento do programa, foi possível aplicar os conceitos aprendidos em relação à linguagem Java e ao paradigma de orientação a objetos, bem como o paradigma desempenha bem em problemas mais complexos.

Em relação aos resultados alcançados, o programa mostrou-se funcional e capaz de simular o jogo Blackjack de forma satisfatória. Ao longo do desenvolvimento, foram implementadas as regras essenciais do jogo, como o cálculo dos valores das mãos, a decisão de “pegar” ou “manter” dos jogadores e a avaliação das vitórias e das derrotas. O programa também foi capaz de lidar com situações especiais, como a possibilidade de empate ou ocorrência de um blackjack natural. É permitido ao usuário jogar contra o computador, tomar decisões estratégicas e acompanhar o seu saldo, tornando a experiência do jogo autêntica e imersiva.

No entanto, durante o desenvolvimento, algumas dificuldades foram encontradas. Uma das principais foi a necessidade de compreender e aplicar corretamente os princípios da orientação a objetos. A equipe de desenvolvedores reuniu-se e debateu entre si, por meio de uma abordagem mais cuidadosa, para efetuar a abstração e modelar o problema e assim efetuar criação das classes adequadas, a definição dos seus atributos e métodos, bem como a correta utilização da herança e polimorfismo. A resolução de problemas que envolviam a interação entre diferentes classes também se mostrou desafiadora em alguns momentos. Ademais, à medida que o programa foi sendo desenvolvido, foi possível perceber uma progressão no entendimento desses conceitos, com a aplicação prática se tornando mais fluente. Através desse projeto, foi possível compreender a importância da organização do código, do encapsulamento e da reutilização de código em projetos complexos.

O desenvolvimento do programa Blackjack proporcionou resultados positivos, permitindo simular com precisão o jogo e oferecer uma experiência convincente aos usuários. A aprendizagem da linguagem Java e da programação orientada a objetos foi reforçada de maneira significativa, permitindo uma reflexão sincera sobre a importância desses conhecimentos na construção de soluções robustas e escaláveis. Bem como a importância da utilização de mecanismos como o Git para trabalhar com uma equipe de diversos desenvolvedores efetuando mudanças nos diversos arquivos de códigos.

Como consideração final, uma das principais contribuições da disciplina de Linguagem de Programação I foi a forma como incentivou-se pensar nas entidades do mundo de forma menos linear, como em classes e objetos. Essa abordagem permitiu uma melhor organização e compreensão do código, além de facilitar a manutenção e evolução do software, fundamental para o crescimento dos criadores do jogo como programadores. Os conceitos e práticas aprendidos foram aplicados com sucesso no desenvolvimento do nosso projeto, demonstrando a eficácia da abordagem de orientação a objetos.
