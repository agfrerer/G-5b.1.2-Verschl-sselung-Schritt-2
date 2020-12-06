package gfrerer.cipher;

public class ShiftCipher extends MonoAlphabeticCipher {

	public ShiftCipher() {
		super();
	}

	public void setShiftValue(int value) {
		String original = "abcdefghijklmnopqrstuvwxyzäöüß";
		String secretAlphabet = "";
		char neu;

		for(int i=0;i<original.length();i++) {
			char alt = original.charAt(i);

			if((original.indexOf(alt) + value) > 29) {
				neu = (char)(alt + value-30);
			}else{
				if((original.indexOf(alt) + value) < 0) {
					neu = (char)(alt + value+30);
				}else {
					neu = (char)(alt + value);
				}
			}
			secretAlphabet = secretAlphabet + neu;
		}
		super.setSecretAlphabet(secretAlphabet);
	}
	
	public String getSecretAlphabet() {
		return super.getSecretAlphabet();
	}
}