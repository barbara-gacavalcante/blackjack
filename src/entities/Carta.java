package entities;

public class Carta {
	private String naipe;
	private String valor;
	
	public Carta(String n, String v) {
		this.naipe = n;
		this.valor = v;
	}
	
	public String getNaipe() {
		return naipe;
	}
	
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return naipe + valor;
	}
	
}
