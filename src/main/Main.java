package main;

public class Main {

	public static void main(String[] args) {
		
		benvenuto();
		Partita partita = new Partita();
		partita.start();
		arrivederci();
	}

	private static void benvenuto() {
		Visualizzatore.printBenvenuto();
		
	}
	
	private static void arrivederci() {
		Visualizzatore.printArrivederci();
		
	}
	
			
		
}

