/**
 * Das Programm erstellt eine GUI, mit einer Eingabemöglichkeit für den Nutzer
 */
package gfrerer.cipher;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

/**
 * @author anjag
 * @version 26.09.2020
 */
public class PanelKlasse extends JPanel {
	private JPanel p1, p2, p3, p4;
	private JLabel l1, l2;
	private JTextField textfeld;
	private JRadioButton caesar, subst;
	private ButtonGroup bg;
	private JButton ver, ent;
	private Controller c;

	public PanelKlasse(Controller c) {
		this.setLayout(new BorderLayout());

		this.c = c;
		
		//Gesamt
		GridLayout grid = new GridLayout(4, 1);
		this.setLayout(grid);
		Font schrift = new Font(Font.SANS_SERIF, Font.BOLD, 15);
		
		//Textfeld + Überschrift
		GridLayout oben = new GridLayout(2, 1);
		p1 = new JPanel();
		l1 = new JLabel();
		textfeld = new JTextField();

		p1.setLayout(oben);
		l1.setText("Geben Sie Ihren gewünschten Text ein!");
		l1.setFont(schrift);
		p1.add(l1);
		p1.add(textfeld);
		this.add(p1, BorderLayout.PAGE_START);
		
		//Cäsar oder per Geheimalphabet
		GridLayout auswahl = new GridLayout(1, 2);
		p2 = new JPanel();
		caesar = new JRadioButton("Cäsar-Verschlüsselung");
		subst = new JRadioButton("Geheimalphabet");
		bg = new ButtonGroup();
		
		caesar.addActionListener(c);
		subst.addActionListener(c);
		caesar.setFont(schrift);
		subst.setFont(schrift);
		
		p2.setLayout(auswahl);
		bg.add(caesar);
		bg.add(subst);
		p2.add(caesar);
		p2.add(subst);
		this.add(p2);
		
		//Verschlüsseln / Entschlüsseln
		GridLayout schluessel = new GridLayout(1, 2);
		p3 = new JPanel();
		ver = new JButton("Verschlüsseln");
		ent = new JButton("Entschlüsseln");
		
		ver.addActionListener(c);
		ent.addActionListener(c);
		ver.setFont(schrift);
		ent.setFont(schrift);
		
		p3.setLayout(schluessel);
		p3.add(ver);
		p3.add(ent);
		this.add(p3);
		
		//Ausgabe unten
		p4 = new JPanel();
		l2 = new JLabel("");
		
		p4.add(l2);
		this.add(p4);
	}
	
	public String getEingabe() {
		return this.textfeld.getText();
	}
	
	public JButton getVer() {
		return this.ver;
	}
	
	public JButton getEnt() {
		return this.ent;
	}
	
	public String selected() {
		String rueckgabe = "";
		if(this.caesar.isSelected()) {
			rueckgabe = "Cäsar";
		}else if(this.subst.isSelected()) {
			rueckgabe = "Secret";
		}
		return rueckgabe;
	}
	
	public void setPanel(String text) {
		Font schrift = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		l2.setText(text);
		l2.setFont(schrift);
	}
}


