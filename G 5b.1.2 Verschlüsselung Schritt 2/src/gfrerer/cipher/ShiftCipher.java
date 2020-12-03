package gfrerer.cipher;

public class ShiftCipher extends MonoAlphabeticCipher {
	private int value;
	
	public ShiftCipher(int value) {
		super();
		this.value = value;
	}
	
	public void setShiftValue(int value) {
		String original = ("abcdefghijklmnopqrstuvwxyzäöüß");
		char[] normal = original.toCharArray();
		char[] verschoben = new char[normal.length];
		
		if(value>0) {
			for(int i=0; i < 29; i++) {
				
			}
		}else {
			
		}
	}
}
