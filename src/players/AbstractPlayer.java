package players;

import java.util.ArrayList;

import entities.Carta;

public abstract class AbstractPlayer implements PlayerInterface {

  public abstract void gerarMao(ArrayList<Carta> deck);

  public abstract void mostrarMao();

  public abstract void manter();

  public abstract void pegar(ArrayList<Carta> deck);
}
