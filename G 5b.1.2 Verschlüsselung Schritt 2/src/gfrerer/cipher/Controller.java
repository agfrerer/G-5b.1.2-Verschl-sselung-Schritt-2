package gfrerer.cipher;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Controller implements ActionListener {
	private MonoAlphabeticCipher maC;
	private ShiftCipher shiftC;
	private SubstitutionCipher substC;
	private PanelKlasse panel;
	private FrameKlasse frame;

	public Controller() {
		this.maC = new MonoAlphabeticCipher();
		this.shiftC = new ShiftCipher();
		this.substC = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
		
		this.panel = new PanelKlasse(this);
		this.frame = new FrameKlasse(panel);
	}

	public void actionPerformed(ActionEvent e)  {

		String eingabe = panel.getEingabe();
		String selected = panel.selected();
		String ausgabe = "";

		if(e.getSource() == panel.getVer()){

			if(selected.equals("Cäsar")) {
				int value = eingabeZahl("Ver");
				this.shiftC.setShiftValue(value);
				ausgabe = this.shiftC.encrypt(eingabe);
				panel.setPanel(ausgabe);

			}else if(selected.equals("Secret")) {
				String secret = eingabeABC();
				this.maC.setSecretAlphabet(secret);
				ausgabe = this.maC.encrypt(eingabe);
				panel.setPanel(ausgabe);
			}
			
		}else if(e.getSource() == panel.getEnt()){

			if(selected.equals("Cäsar")) {
				int value = eingabeZahl("Ent");
				int neu = -(value);
				this.shiftC.setShiftValue(neu);
				ausgabe = this.shiftC.encrypt(eingabe);
				panel.setPanel(ausgabe);
				
			}else if(selected.equals("Secret")) {
				String secret = eingabeABC();
				this.maC.setSecretAlphabet(secret);
				ausgabe = this.maC.decrypt(eingabe);
				panel.setPanel(ausgabe);
			}
		}
	}
	
	public int eingabeZahl(String text) {
		boolean zahl = false;
		int wert = 0;
		while(zahl==false) {
			String eingabe = JOptionPane.showInputDialog("Geben Sie einen " + text + "schlüsselungswert ein!");
			if (eingabe == null) {
				System.exit(0);
			} else if (eingabe.equals("")) {
				eingabe = "0";
			}
			try {
				wert = Integer.parseInt(eingabe);
				zahl = true;
			}catch(NumberFormatException e) {
				zahl = false;
			}
		}
		return wert;
	}
	
	public String eingabeABC() {
		String eingabe = JOptionPane.showInputDialog("Geben Sie ein Geheimalphabet ein!");
		if (eingabe == null) {
			System.exit(0);
		}
		this.substC.setSecretAlphabet(eingabe);
		return eingabe;
	}

	public static void main(String[] args) {
		/**SubstitutionCipher sc = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
		try {
			sc.encrypt("Anja Gfrerer");
			sc.decrypt("Qdpq Uzjtjtj");
		}catch(Exception e) {
			System.out.println("Etwas ist in Ihrem Alphabet schiefgegangen!");
		}
		ShiftCipher shc = new ShiftCipher();
		shc.setShiftValue(10);
		System.out.println(shc.getSecretAlphabet()); **/

		new Controller();
		
	}
}
