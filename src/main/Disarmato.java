/**
 * 
 */
package main;

/**
 * @author alberto
 *
 */
public class Disarmato extends AbstractStato{


	public Disarmato(Partita partita) {
		super(partita);
	}
	
	/* (non-Javadoc)
	 * @see main.AbstractStato#eseguiAzione()
	 */
	public void eseguiAzione() {
		AbstractObject oggetto = partita.contenutoCasella(guerriero.getPosizione()); //l'oggetto contenuto nella casella è Null quando la casella è vuota
		if (!partita.isVuota(guerriero.getPosizione())){			
			if (oggetto.getClass()==Arma.class){
				scegliRaccolta((Arma)oggetto);				
			}
			else if(oggetto.getClass()==Forziere.class){
				trovatoForziere((Forziere)oggetto);
			}
			else if(oggetto.getClass()==Pozione.class){
				trovataPozione((Pozione)oggetto);
			}
			else if (oggetto.getClass()==Orco.class) {
				trovatoOrco((Orco)oggetto);
			}
			else 
				assert false;
		}

	}	

	/**Fa scegliere se impugnare l'arma trovata, in caso affermativo la impugna
	 * @param arma impugnabile
	 */
	private void scegliRaccolta(Arma arma) {
		Boolean raccolta = Visualizzatore.scegliRaccoltaArma(arma.getNomeOggetto());
		if(raccolta){
			guerriero.impugna(arma);
			partita.modificaCasella(guerriero.getPosizione(), null);
			partita.setStato(new Armato(partita));
		}
	}

}
