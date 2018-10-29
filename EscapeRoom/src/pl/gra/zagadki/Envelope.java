package pl.gra.zagadki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Envelope extends JDialog{
	
	private JLabel imageNewspaper;
	private JButton bCancel;

	public Envelope(JFrame owner) {
		   super(owner, "Envelope", true);
		   
		   setEnvelopeParametres ();
		   createImage();
		   createButtonToCancel();
}

	public void setEnvelopeParametres() {
		setBounds(350, 50, 700, 900);
		setTitle("Envelope");
		setLayout(null);
	}
	
	public void createImage() {
		imageNewspaper = new JLabel();
		imageNewspaper.setIcon(new ImageIcon("images/newspaper.jpg"));
		imageNewspaper.setBounds(20, 30, 642, 710);
		add(imageNewspaper);
	}

	public void createButtonToCancel() {
		bCancel = new JButton("Wróć do gry");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		bCancel.setBounds(275, 800, 150, 30);
		add(bCancel);
	}
	
}

