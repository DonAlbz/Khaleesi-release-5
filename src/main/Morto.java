/**
 * 
 */
package main;

/**
 * @author alber
 *
 */
public class Morto extends AbstractStato {

	/**
	 * @param nomeOggetto
	 */
	public Morto(Partita partita) {
		super(partita);
		eseguiAzione();
	}

	@Override
	public void eseguiAzione() {
		Visualizzatore.morto();
		partita.setContinuare(false);		
	}

}
