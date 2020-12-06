package gfrerer.cipher;

import java.awt.event.*;
import java.io.*;

import javax.swing.JOptionPane;

public class MonoAlphabeticCipher implements Cipher, ActionListener {
	private String secretAlphabet, alphabet;
	private boolean weiter;
	private PanelKlasse panel;

	public MonoAlphabeticCipher() {
		this.secretAlphabet = "";
		this.alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		this.panel = new PanelKlasse(this);
	}

	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}

	protected void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}

	@Override
	public String encrypt(String text) {
		String textNeu = "";
		boolean fortsetzen = true;
		text = text.toLowerCase();
		for(int i=0; i < text.length(); i++) {
			String buchstabe = text.substring(i, i+1);
			if(this.alphabet.indexOf(buchstabe)==-1) {
				textNeu = textNeu + buchstabe;
			}else {
				int indexNormal = this.alphabet.indexOf(buchstabe);
				String secretBuchstabe = this.secretAlphabet.substring(indexNormal, indexNormal+1);
				textNeu = textNeu + secretBuchstabe;
			}
		}
		System.out.println("Encrypt Text: " + textNeu);
		return textNeu;
	}

	@Override
	public String decrypt(String text) {
		String original = text;
		String textNeu = "";
		text = text.toLowerCase();
		
		for(int i=0; i < text.length(); i++) { 
			String secretBuchstabe = text.substring(i, i+1);
			if(this.alphabet.indexOf(secretBuchstabe)==-1) {
				textNeu = textNeu + secretBuchstabe;
			}else {
				int indexSecret = this.secretAlphabet.indexOf(secretBuchstabe);
				String buchstabe = this.alphabet.substring(indexSecret, indexSecret+1);
				textNeu = textNeu + buchstabe;
			}
		}
		String textTUC = "";
		for(int i=0; i < original.length(); i++) {
			if(original.substring(i, i+1).toLowerCase().equals(original.substring(i, i+1))) {
				textTUC = textTUC + textNeu.substring(i, i+1);
			}else {
				textTUC = textTUC + textNeu.substring(i, i+1).toUpperCase();
			}
		}
		System.out.println("Decrypt Text: " + textTUC);
		return textTUC;
	}

	public static void main(String[] args) {
		SubstitutionCipher sc = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
		try {
			sc.encrypt("Anja Gfrerer");
			sc.decrypt("Qdpq Uzjtjtj");
		}catch(Exception e) {
			System.out.println("Etwas ist in Ihrem Alphabet schiefgegangen!");
		}
		ShiftCipher shc = new ShiftCipher(10);
		shc.setShiftValue(10);
		System.out.println(shc.getSecretAlphabet());
		
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		PanelKlasse p = new PanelKlasse(mac);
		FrameKlasse f = new FrameKlasse(p);
	}
	
	public void actionPerformed(ActionEvent e)  {
		int wert = fenster();
		String wort = panel.getEingabe();
		String welcher = panel.selected();
		ShiftCipher sc = new ShiftCipher(0);
		
		if(e.getSource() == panel.getVer()){
			
			if(welcher.equals("Cäsar")) {
				sc.encrypt(wort);
			}else if(welcher.equals("Secret")) {
				sc.setShiftValue(wert);
			}
		}else if(e.getSource() == panel.getEnt()){
			
			if(welcher.equals("Cäsar")) {
				sc.decrypt(wort);
			}else if(welcher.equals("Secret")) {
				sc.decrypt(sc.getSecretAlphabet());
			}
		}
	}
	
	public int fenster() {
		String wert = JOptionPane.showInputDialog("Geben Sie eine Zahl zum Verschlüsseln des Alphabets an!");
		int zahl = 0;
		try {
			zahl = Integer.parseInt(wert);
			return zahl;
		}catch(NumberFormatException e) {
			
		}
		return zahl;
	}
}