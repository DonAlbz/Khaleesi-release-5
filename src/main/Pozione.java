package main;

public class Pozione extends AbstractObject{
	private int totaleCura;
	
	public Pozione(String nomeOggetto, int totaleCura) {
		super(nomeOggetto);
		this.totaleCura=totaleCura;
	}

	/**
	 * @return the totaleCura
	 */
	public int getTotaleCura() {
		return totaleCura;
	}

}
