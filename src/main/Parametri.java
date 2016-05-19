package main;

public final class Parametri {
	public final static short PUNTI_VITA_INIZIALI=100;
	public final static short PUNTI_ESPERIENZA_INIZIALI=0;
	public final static short MONETE_INIZIALI=0;
	public final static short [] MONETE_NEL_FORZIERE= {10,20,30};
	public final static short DANNO_SPADA=10;	
	public final static short DANNO_ARCO=15;
	public final static short DANNO_PUGNALE=20;
	public final static short DANNO_MANI_NUDE=40;
	public final static short CURA_POZIONE=10;
	public final static short DANNO_VELENO=10;
	public final static double PROB_SPADA=0.16666;		//PROBABILITA' DEL CONTENUTO DI UNA CASELLA
	public final static double PROB_ARCO=0.16666; 		// LA SOMMA DELLE PROBABILITA' DEVE ESSERE UGUALE A 1
	public final static double PROB_PUGNALE=0.083335;          
	public final static double PROB_POZIONE=0.083335;          
	public final static double PROB_FORZIERE=0.16667;
	public final static double PROB_ORCO= 0.16667;
	public final static double PROB_VUOTA=0.16667;
	public final static double PROB_FORZIERE_VUOTO=0.3333;		//PROBABILITA' DEL CONTENUTO DI UN FORZIERE
	public final static double PROB_FORZIERE_MONETE=0.3333;		//LA SOMMA DELLE PROBABILITA' DEVE ESSERE 1
	public final static double PROB_FORZIERE_VELENO=0.3334;
	public static final double PROB_FUGA = 0.45;
	public static final int PUNTI_EXP_ORCO = 1;
	public static final double PALADINO_F = 1;
	public static final double PALADINO_V = 1;
	public static final String PALADINO = "Paladino";
	public static final double LADRO_F = 0.5;
	public static final double LADRO_V = 2;
	public static final String LADRO = "Ladro";
	public static final double BARBARO_F = 2;
	public static final double BARBARO_V = 0.5;
	public static final String BARBARO = "Barbaro";
	public static final short LIVELLO_INIZIALE = 1;
	public static final short CAP_EXP = 10;
	public static final double FORZA_INCREMENTO = 0.2;
	public static final double FORZA_VELOCITA = 0.2;
	public static final int COEFFICIENTE_V = 100;
	public static double probFuga = 1 - PROB_FUGA;
	
	
	
}
