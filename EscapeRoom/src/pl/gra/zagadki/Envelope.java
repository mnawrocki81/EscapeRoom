package pl.gra.zagadki;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Envelope extends JDialog{

	public Envelope(JFrame owner) {
		   super(owner, "Envelope", true);
		   
		   setEnvelopeParametres ();
}

	public void setEnvelopeParametres() {
		setBounds(350, 50, 700, 900);
		setLayout(null);
	}
}

