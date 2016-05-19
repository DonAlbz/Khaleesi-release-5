package main;

public class Arma extends AbstractObject {
	private int danno;
	
	public Arma(String nomeOggetto, int danno) {
		super(nomeOggetto);
		this.danno=danno;
	}

	/**
	 * @return the danno
	 */
	public int getDanno() {
		return danno;
	}

	
}
