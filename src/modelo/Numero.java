package modelo;

public class Numero {
	private int numero;
	
	public Numero() {
		this.numero = 0;
	}
	
	public void Sumar() {
		this.numero++;
	}
	
	public String toString() {
		return ""+this.numero;
	}
}
