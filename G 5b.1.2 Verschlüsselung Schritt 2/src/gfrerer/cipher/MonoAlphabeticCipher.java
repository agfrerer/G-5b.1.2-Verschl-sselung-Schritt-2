package gfrerer.cipher;

import java.awt.event.*;
import java.io.*;

import javax.swing.JOptionPane;

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet, alphabet;
	private boolean weiter;

	public MonoAlphabeticCipher() {
		this.secretAlphabet = "";
		this.alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
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
}