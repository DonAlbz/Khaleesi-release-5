package main;

import utility.EstrazioniCasuali;

public class ObjectFactory {
	private static double limiteProbSpada=Parametri.PROB_SPADA;
	private static double limiteProbArco=limiteProbSpada+Parametri.PROB_ARCO;
	private static double limiteProbPugnale=limiteProbArco + Parametri.PROB_PUGNALE;
	private static double limiteProbPozione = limiteProbPugnale+Parametri.PROB_POZIONE;
	private static double limiteProbForziere = limiteProbPozione+Parametri.PROB_FORZIERE;
	private static double limiteProbVuota = limiteProbForziere+Parametri.PROB_VUOTA;
	private static double limiteProbOrco= limiteProbVuota+Parametri.PROB_ORCO;
	
	/**Crea il contenuto casuale di una casella applicado le probabilita' definite nella classe Parametri
	 * @return
	 */
	public static AbstractObject creaContenutoCasella(){
		double casual = EstrazioniCasuali.estraiDouble(0, limiteProbVuota);
		if (casual<=limiteProbSpada){
			return creaSpada();
		}
		else if (casual<=limiteProbArco){
			return creaArco();
		}
		else if (casual<=limiteProbPugnale){
			return creaPugnale();
		}
		else if (casual<=limiteProbPozione){
			return creaPozione();
		}
		else if (casual<=limiteProbForziere){
			return creaForziere();
		}
		else if (casual<=limiteProbOrco){
			return creaOrco();
		}
		else if (casual<=limiteProbVuota){
			return null;
		}	
		else 
			assert false;
		return null;
	}

	private static AbstractObject creaSpada() {
		return new Arma (Visualizzatore.SPADA,Parametri.DANNO_SPADA);
	}

	private static AbstractObject creaArco() {
		return new Arma (Visualizzatore.ARCO,Parametri.DANNO_ARCO);
	}


	private static AbstractObject creaPugnale() {
		return new Arma (Visualizzatore.PUGNALE,Parametri.DANNO_PUGNALE);
	}


	private static AbstractObject creaPozione() {
		return new Pozione(Visualizzatore.POZIONE, Parametri.CURA_POZIONE);
	}
	
	private static AbstractObject creaOrco() {
		return new Orco (Visualizzatore.ORCO, Parametri.PUNTI_EXP_ORCO);
	}

	
	private static double limiteProbForzVuoto=Parametri.PROB_FORZIERE_VUOTO;
	private static double limiteProbForzMonete=limiteProbForzVuoto+Parametri.PROB_FORZIERE_MONETE;
	private static double limiteProbForzVeleno=limiteProbForzMonete + Parametri.PROB_FORZIERE_VELENO;

	private static AbstractObject creaForziere() {
		Forziere forziere= new Forziere(Visualizzatore.FORZIERE);
		double casual = EstrazioniCasuali.estraiDouble(0, limiteProbForzVeleno);
		if (casual<=limiteProbForzVuoto){
			return forziere;
		}
		else if (casual<=limiteProbForzMonete){
			int indiceCasualeMonete=EstrazioniCasuali.estraiIntero(0, Parametri.MONETE_NEL_FORZIERE.length-1);
			forziere.setMonete(Parametri.MONETE_NEL_FORZIERE[indiceCasualeMonete]);
			return forziere;
		}
		else if (casual<=limiteProbForzVeleno){
			forziere.setVeleno(Parametri.DANNO_VELENO);
			return forziere;
		}
		else 
			assert false;
		return null;
	}


	
	
}
