package gfrerer.cipher;

public class SubstitutionCipher extends MonoAlphabeticCipher {
	
	public SubstitutionCipher(String secretAlphabet) {
		setSecretAlphabet(secretAlphabet);
	}

	public void setSecretAlphabet(String secretAlphabet) {
		String original = secretAlphabet;
		String textTUC = "";
		secretAlphabet = secretAlphabet.toLowerCase();
		String neuSecret = "";
		boolean fortsetzen = false;

		if(secretAlphabet.length()==30) {
			fortsetzen = true;
		}else {
			System.out.println("Alphabet muss genau 30 Zeichen besitzen!");
		}
		if(fortsetzen==true) {
			for(int i=0; i < secretAlphabet.length(); i++) {
				String secretBuchstabe = secretAlphabet.substring(i, i+1);
				if(neuSecret.indexOf(secretBuchstabe)==-1) {
					fortsetzen = true;
					neuSecret = neuSecret + secretBuchstabe;
				}else {
					System.out.println("Buchstabe doppelt!");
					fortsetzen = false;
					break;
				}
			}
		}
		if(fortsetzen==true) {
			System.out.println("Secret Alphabet: " + neuSecret);
			secretAlphabet = neuSecret;
			super.setSecretAlphabet(secretAlphabet);
		}
	}
}