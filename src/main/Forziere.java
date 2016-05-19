package main;

public class Forziere extends AbstractObject {
	private boolean vuoto=true;
	private int monete;
	private int veleno;

	public Forziere(String nomeOggetto) {
		super(nomeOggetto);
	}

	/**
	 * @return the monete
	 */
	public int getMonete() {
		return monete;
	}

	/**
	 * @param monete the monete to set
	 */
	public void setMonete(int monete) {
		if (monete>0)
			vuoto=false;
		this.monete = monete;
		if(monete==0)
			vuoto=true;
	}

	/**
	 * @return the veleno
	 */
	public int getVeleno() {
		return veleno;
	}

	/**
	 * @param veleno the veleno to set
	 */
	public void setVeleno(int veleno) {
		if(veleno>0)
			vuoto=false;
		this.veleno = veleno;
		if(veleno==0)
			vuoto=true;	
	}
	
	/**
	 * @return the vuoto
	 */
	public boolean isVuoto() {
		return vuoto;
	}
	
}
