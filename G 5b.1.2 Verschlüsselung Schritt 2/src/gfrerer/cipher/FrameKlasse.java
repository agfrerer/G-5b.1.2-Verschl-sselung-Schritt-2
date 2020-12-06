package gfrerer.cipher;
import javax.swing.*;
/**
 * @author anjag
 * @version 26.09.2020
 */
public class FrameKlasse extends JFrame {
	
	public FrameKlasse(PanelKlasse panel) {
		super("Alphabet-Verschlüsselung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelKlasse p = panel;
		this.add(p);
		this.pack();
		this.setVisible(true);
	}
}
