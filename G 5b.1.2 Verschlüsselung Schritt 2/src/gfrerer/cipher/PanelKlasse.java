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
	private MonoAlphabeticCipher mac;
	private JPanel p1, p2, p3;
	private JLabel l1;
	private JTextField textfeld;
	private JRadioButton caesar, subst;
	private ButtonGroup bg;
	private JButton ver, ent;

	public PanelKlasse(MonoAlphabeticCipher mac) {
		this.setLayout(new BorderLayout());

		this.mac = mac;
		
		//Gesamt
		GridLayout grid = new GridLayout(4, 1);
		this.setLayout(grid);
		
		//Textfeld + Überschrift
		GridLayout oben = new GridLayout(2, 1);
		p1 = new JPanel();
		l1 = new JLabel();
		textfeld = new JTextField();

		p1.setLayout(oben);
		l1.setText("Geben Sie Ihren gewünschten Text ein!");
		p1.add(l1);
		p1.add(textfeld);
		this.add(p1, BorderLayout.PAGE_START);
		
		//Cäsar oder per Geheimalphabet
		GridLayout auswahl = new GridLayout(1, 2);
		p2 = new JPanel();
		caesar = new JRadioButton("Cäsar-Verschlüsselung");
		subst = new JRadioButton("Geheimalphabet");
		bg = new ButtonGroup();
		
		caesar.addActionListener(mac);
		subst.addActionListener(mac);
		
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
		
		ver.addActionListener(mac);
		ent.addActionListener(mac);
		
		p3.setLayout(schluessel);
		p3.add(ver);
		p3.add(ent);
		this.add(p3);
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
}


