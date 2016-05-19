/**
 * 
 */
package main;

/**
 * @author alberto
 *
 */
public class Armato  extends AbstractStato{
	
	public Armato(Partita partita) {
		super(partita);
	}

	
	
	/* (non-Javadoc)
	 * @see main.AbstractStato#eseguiAzione()
	 */
	@Override
	public void eseguiAzione() {
	
		if (!partita.isVuota(guerriero.getPosizione())){
			AbstractObject oggetto = partita.contenutoCasella(guerriero.getPosizione());
			//l'oggetto contenuto nella casella è Null quando la casella è vuota
			if(oggetto.getClass()==Forziere.class){
				trovatoForziere((Forziere)oggetto);
			}
			else if(oggetto.getClass()==Pozione.class){
				trovataPozione((Pozione)oggetto);
			}
			else if (oggetto.getClass()==Orco.class) {
				trovatoOrco((Orco) oggetto);
			}
			else if (oggetto.getClass()!=Arma.class){
				assert false;
			}
		}
		else 
			scegliDrop((guerriero.getArma()));				
		
	}

	/**Permette di scegliere se lasciare l'arma sulla casella vuota trovata, in caso affermativo la lascia.
	 * @param arma abbandonabile
	 */
	private void scegliDrop(Arma arma) {
		Boolean raccolta = Visualizzatore.scegliDropArma();
		if(raccolta){
			guerriero.dropArma();
			partita.modificaCasella(guerriero.getPosizione(), arma);
			partita.setStato(new Disarmato(partita));
		}		
	}

}
