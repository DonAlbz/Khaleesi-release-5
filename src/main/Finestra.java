package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Finestra implements Observer {	

	private JFrame mainFrame;
	private JLabel nomeLabel;
	private JLabel nomeInseritoLabel;
	private JLabel categoriaDesLabel;
	private JLabel categoriaLabel;
	private JLabel expDesLabel;
	private JLabel expLabel;
	private JLabel hpDesLabel;
	private JLabel hpLabel;
	private JLabel armaDesLabel;
	private JLabel armaLabel;
	private JLabel moneteDesLabel;
	private JLabel moneteLabel;
	private JLabel contenutoCasellaDesLabel;
	private JLabel contenutoCasellaLabel;
	private JLabel livelloDesLabel;
	private JLabel livelloLabel;
	private JLabel grazieLabel;
	private JLabel theShandonAdventureLabel;
	
	private Panel controlPanel;
	
	

	public Finestra(Partita partita){
		prepareGUI();
		inserisciDatiIniziali(partita);
		update(partita,partita);
		
	}


	private void prepareGUI(){
		mainFrame = new JFrame("Scheda di gioco");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(8, 2));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    
		mainFrame.setAlwaysOnTop(true);
		//mainFrame.setUndecorated(true);
		mainFrame.getContentPane().setBackground(new Color(209,245,255));
		//mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, 0);
		mainFrame.setLocation(0, 0);
		nomeLabel = new JLabel();
		nomeLabel.setAlignmentX(JLabel.CENTER);
		nomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeInseritoLabel = new JLabel();        
		nomeInseritoLabel.setHorizontalAlignment(JLabel.CENTER);
		
		livelloDesLabel = new JLabel();        
		livelloDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		livelloLabel = new JLabel();        
		livelloLabel.setHorizontalAlignment(JLabel.CENTER);
		
		categoriaDesLabel = new JLabel();        
		categoriaDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		categoriaLabel = new JLabel();        
		categoriaLabel.setHorizontalAlignment(JLabel.CENTER);
		
		expDesLabel = new JLabel();        
		expDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		expLabel = new JLabel();        
		expLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		hpDesLabel = new JLabel();
		hpDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		hpLabel = new JLabel();        
		hpLabel.setHorizontalAlignment(JLabel.CENTER);//
		
		armaDesLabel = new JLabel();        
		armaDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		armaLabel = new JLabel();
		armaLabel.setHorizontalAlignment(JLabel.CENTER);
		moneteDesLabel = new JLabel();        
		moneteDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		moneteLabel = new JLabel();
		moneteLabel.setHorizontalAlignment(JLabel.CENTER);
		contenutoCasellaDesLabel = new JLabel();        
		contenutoCasellaDesLabel.setHorizontalAlignment(JLabel.RIGHT);
		contenutoCasellaLabel = new JLabel();        
		contenutoCasellaLabel.setHorizontalAlignment(JLabel.CENTER);
		
		grazieLabel = new JLabel();
		grazieLabel.setHorizontalAlignment(JLabel.CENTER);
		theShandonAdventureLabel = new JLabel();
		theShandonAdventureLabel.setHorizontalAlignment(JLabel.CENTER);		
		theShandonAdventureLabel.setVerticalAlignment(JLabel.TOP);		
	
		mainFrame.add(nomeLabel);
		mainFrame.add(nomeInseritoLabel);
		
		mainFrame.add(categoriaDesLabel);
		mainFrame.add(categoriaLabel);
		
		mainFrame.add(livelloDesLabel);
		mainFrame.add(livelloLabel);
		
		mainFrame.add(expDesLabel);
		mainFrame.add(expLabel);
		
		mainFrame.add(hpDesLabel);
		mainFrame.add(hpLabel);

		mainFrame.add(armaDesLabel);
		mainFrame.add(armaLabel);
		
		mainFrame.add(moneteDesLabel);
		mainFrame.add(moneteLabel);
		
		mainFrame.add(contenutoCasellaDesLabel);
		mainFrame.add(contenutoCasellaLabel);
		mainFrame.setVisible(true);  
	}

	private void inserisciDatiIniziali(Partita partita){
		nomeLabel.setText("Nome guerriero:"); 
		nomeInseritoLabel.setText(partita.getGuerriero().getNome());
		categoriaDesLabel.setText("Categoria:"); 
		categoriaLabel.setText(partita.getGuerriero().getCategoria());		
		livelloDesLabel.setText("Livello:"); 
		expDesLabel.setText("Esperienza:"); 
		hpDesLabel.setText("Punti vita:"); 
		armaDesLabel.setText("Arma impugnata:"); 
		moneteDesLabel.setText(Visualizzatore.MONETE);
		contenutoCasellaDesLabel.setText("Contenuto casella corrente:");
		grazieLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE,20));
		grazieLabel.setText("Grazie per aver giocato a");
		theShandonAdventureLabel.setFont(new Font("Serif",Font.BOLD,35));
		theShandonAdventureLabel.setText("The Shandon Adventure");
		mainFrame.setVisible(true);  
	} 
	
	public void arrivederci(){
		mainFrame.getContentPane().removeAll();
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.add(grazieLabel);
		mainFrame.add(theShandonAdventureLabel);	
		mainFrame.revalidate();
		mainFrame.repaint();
		try {
			Thread.sleep(4000);
			mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setContenutoCasella(String s){
		contenutoCasellaLabel.setText(s);
	}
	
	private void setPuntiVita(Double d){
		hpLabel.setText(Double.toString(d));
	}
	
	private void setArma(String a){
		armaLabel.setText(a);
	}
	
	private void setLivello(int l){
		livelloLabel.setText(Integer.toString(l));
	}
	
	private void setMonete(int m){
		moneteLabel.setText(Integer.toString(m));
	}
	
	private void setExp(int e){
		expLabel.setText(Integer.toString(e));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Partita partita=(Partita)arg;
		setContenutoCasella(partita.contenutoCasellaToString(partita.getGuerriero().getPosizione()));
		setPuntiVita(partita.getGuerriero().getPuntiVita());
		setMonete(partita.getGuerriero().getMonete());
		try{
			setArma(partita.getGuerriero().getArma().getNomeOggetto());
		}
		catch(NullPointerException e){
			setArma(Visualizzatore.NESSUNA);			
		}
		setLivello(partita.getGuerriero().getLivello());
		setExp(partita.getGuerriero().getPuntiEsperienza());
	}
}

