package pl.gra.zagadki;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Envelope extends JDialog{
	
	private JLabel newspapper;

	public Envelope(JFrame owner) {
		   super(owner, "Envelope", true);
		   
		   setEnvelopeParametres ();
		   createImage();
}

	public void setEnvelopeParametres() {
		setBounds(350, 50, 700, 900);
		setTitle("Envelope");
		setLayout(null);
	}
	
	public void createImage()
	{
		newspapper = new JLabel();
		newspapper.setIcon(new ImageIcon("images/newspapper.jpg"));
		newspapper.setBounds(50, 30, 600, 600);
		add(newspapper);
	}
	
	
}

