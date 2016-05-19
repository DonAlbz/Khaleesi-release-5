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
	private JLabel hpDesLabel;
	private JLabel hpLabel;
	private JLabel armaDesLabel;
	private JLabel armaLabel;
	private JLabel contenutoCasellaDesLabel;
	private JLabel contenutoCasellaLabel;
	
	private Panel controlPanel;
	private JLabel livelloDesLabel;
	private JLabel livelloLabel;
	

	public Finestra(Partita partita){
		prepareGUI();
		inserisciDatiIniziali(partita);
		update(partita,partita);
		
	}


	private void prepareGUI(){
		mainFrame = new JFrame("Java AWT Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(5, 2));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setUndecorated(true);
		mainFrame.getContentPane().setBackground(new Color(209,245,255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, 40);
		nomeLabel = new JLabel();
		nomeLabel.setAlignmentX(JLabel.CENTER);
		nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomeInseritoLabel = new JLabel();        
		nomeInseritoLabel.setHorizontalAlignment(JLabel.CENTER);
		
		livelloDesLabel = new JLabel();        
		livelloDesLabel.setHorizontalAlignment(JLabel.CENTER);
		livelloLabel = new JLabel();        
		livelloLabel.setHorizontalAlignment(JLabel.CENTER);
		
		hpDesLabel = new JLabel();
		hpDesLabel.setHorizontalAlignment(JLabel.CENTER);
		hpLabel = new JLabel();        
		hpLabel.setHorizontalAlignment(JLabel.CENTER);//
		
		armaDesLabel = new JLabel();        
		armaDesLabel.setHorizontalAlignment(JLabel.CENTER);
		armaLabel = new JLabel();
		armaLabel.setHorizontalAlignment(JLabel.CENTER);
		contenutoCasellaDesLabel = new JLabel();        
		contenutoCasellaDesLabel.setHorizontalAlignment(JLabel.CENTER);
		contenutoCasellaLabel = new JLabel();        
		contenutoCasellaLabel.setHorizontalAlignment(JLabel.CENTER);
		

		mainFrame.add(nomeLabel);
		mainFrame.add(nomeInseritoLabel);
		mainFrame.add(livelloDesLabel);
		mainFrame.add(livelloLabel);
		mainFrame.add(hpDesLabel);
		mainFrame.add(hpLabel);

		mainFrame.add(armaDesLabel);
		mainFrame.add(armaLabel);
		mainFrame.add(contenutoCasellaDesLabel);
		mainFrame.add(contenutoCasellaLabel);
		mainFrame.setVisible(true);  
	}

	private void inserisciDatiIniziali(Partita partita){
		nomeLabel.setText("Nome guerriero:"); 
		nomeInseritoLabel.setText(partita.getGuerriero().getNome());
		livelloDesLabel.setText("Livello:"); 
		livelloLabel.setText(Integer.toString(partita.getGuerriero().getLivello()));
		
		hpDesLabel.setText("Punti vita:"); 
		hpLabel.setText(Double.toString(partita.getGuerriero().getPuntiVita()));
		armaDesLabel.setText("Arma impugnata:"); 
		contenutoCasellaDesLabel.setText("Contenuto casella corrente:"); 
		contenutoCasellaLabel.setText(partita.contenutoCasellaToString(partita.getGuerriero().getPosizione()));

		mainFrame.setVisible(true);  
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
	
	
	@Override
	public void update(Observable o, Object arg) {
		Partita partita=(Partita)arg;
		setContenutoCasella(partita.contenutoCasellaToString(partita.getGuerriero().getPosizione()));
		setPuntiVita(partita.getGuerriero().getPuntiVita());
		try{
			setArma(partita.getGuerriero().getArma().getNomeOggetto());
		}
		catch(NullPointerException e){
			setArma("");			
		}
		setLivello(partita.getGuerriero().getLivello());		
	}
}
