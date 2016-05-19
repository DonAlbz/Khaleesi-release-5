package main;

public class Orco extends AbstractObject {
	
	private int puntiExpOttenuti;
	public Orco (String nomeOggetto, int puntiExpOttenuti) {
		super(nomeOggetto);
		this.puntiExpOttenuti=puntiExpOttenuti;
	}

	public int getExp(){
		return puntiExpOttenuti;
	}
}
