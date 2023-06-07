package players;

import java.util.ArrayList;

import entities.Carta;

public interface IPlayerInterface {

  public void gerarMao(ArrayList<Carta> deck);

  public void mostrarMao();

  public void manter();

  public void pegar(ArrayList<Carta> deck);

}
