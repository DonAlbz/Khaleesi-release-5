package main;

public abstract class AbstractObject {
	private String nomeOggetto;
	public AbstractObject(String nomeOggetto){
		this.nomeOggetto=nomeOggetto;
	}
	
	/**
	 * @return the nomeOggetto
	 */
	public String getNomeOggetto() {
			return nomeOggetto;		
	}

	public String toString(){
		return nomeOggetto;
	}
}
