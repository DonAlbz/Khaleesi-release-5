package main;

import java.awt.Point;

import inputDati.InputDati;

public abstract class Guerriero {
	private String nome;
	private Point posizione;
	private double puntiVita;
	private int puntiEsperienza;
	private int monete;
	private Arma arma;
	private double forza;
	private double velocita;
	private String categoria;
	private short livello;

	public Guerriero(double forza, double velocita, String categoria) {
		this.nome = richiestaNome();
		puntiVita = Parametri.PUNTI_VITA_INIZIALI;
		puntiEsperienza = Parametri.PUNTI_ESPERIENZA_INIZIALI;
		posizione = new Point(0, 0);
		livello = Parametri.LIVELLO_INIZIALE;
		this.forza = forza;
		this.velocita = velocita;
		this.categoria = categoria;
	}

	/**
	 * @return
	 */
	public Point getPosizione() {
		return posizione;
	}

	private String richiestaNome() {
		return Visualizzatore.richiestaNomeGuerriero();
	}

	public void impugna(Arma arma) {
		assert this.arma == null;
		this.arma = arma;
	}

	/**
	 * @return the arma
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * @param monete
	 *            the monete to set
	 */
	public void setMonete(int monete) {
		this.monete = monete;
	}

	/**
	 * @return the puntiVita
	 */
	public double getPuntiVita() {
		return puntiVita;
	}

	public void setPuntiVita(int nuoviPuntiVita) {
		puntiVita = nuoviPuntiVita;
	}

	public void subisciDanni(double danni) {
		puntiVita -= danni;
	}

	/**
	 * Applica i danni subiti in combattimento alla vita del guerriero
	 * 
	 */
	public void combatti() {
		subisciDanni(danniSubiti());
	}

	/**
	 * @return i danni che subirebbe in combattimento
	 */
	public double danniSubiti() {
		if (arma != null) {
			return arma.getDanno() / forza;
		} else
			return Parametri.DANNO_MANI_NUDE;
	}

	/**
	 * Cura il guerriero
	 * 
	 * @param cura
	 */
	public void riceviCura(int cura) {
		puntiVita += cura;
	}

	/**
	 * @return the puntiEsperienza
	 */
	public int getPuntiEsperienza() {
		return puntiEsperienza;
	}

	public void dropArma() {
		this.arma = null;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	public Boolean isVivo() {
		return puntiVita > 0;
	}

	public void aumentaExp(int exp) {
		puntiEsperienza += exp;
		controllaLivello();
	}

	public void controllaLivello(){
		if(puntiEsperienza%Parametri.CAP_EXP==0)
			aumentaLivello();			
	}

	private void aumentaLivello() {
		livello++;	
		forza+=Parametri.FORZA_INCREMENTO;
		velocita+=Parametri.FORZA_VELOCITA;
	}
	
	public void aumentaMonete(int monete){
		this.monete+=monete;
		diminuisciVelocita(monete);
	}

	private void diminuisciVelocita(int monete) {
		double nuovaVelocita=velocita-(double)(monete/Parametri.COEFFICIENTE_V);
		if(nuovaVelocita<0)
			nuovaVelocita=0;
		this.velocita=nuovaVelocita;		
	}

	/**
	 * @return the velocita
	 */
	public double getVelocita() {
		return velocita;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	
	public int getLivello(){
		return livello;
	}
	
	public int getMonete(){
		return monete;
	}
	
}
