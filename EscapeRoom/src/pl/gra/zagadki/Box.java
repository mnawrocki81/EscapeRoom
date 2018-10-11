package pl.gra.zagadki;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Box extends JDialog {
	
	private JLabel imageBox1, imageBox2;
	private JButton bOpen, bTake, bCancel;
	private Envelope envelope;

	public Box(JFrame owner) {
		   super(owner, "Box", true);
		   
		   setLetterParametres ();
		   createImage1Parameters();
		   createImage2Parameters();
		   createButtonOpenBox();
		   createButtonTakeEnvelope();
		   createButtonToCancel();
}
	
	public void setLetterParametres ()
	{
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		//setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public void  createImage1Parameters()
	{
		imageBox1 = new JLabel(new ImageIcon("images/skrzynka1.jpg"));
		imageBox1.setBounds(50, 30, 1000, 500);
		add(imageBox1);
		

	}
	
	public void  createImage2Parameters()
	{
		imageBox2 = new JLabel(new ImageIcon("images/skrzynka2.jpg"));
		imageBox2.setBounds(50, 30, 1000, 500);
		imageBox2.setVisible(false);
		add(imageBox2);
		
	}
	
	public void createButtonOpenBox() {
		bOpen = new JButton("Otwórz skrzynkę");
		bOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				imageBox1.setVisible(false);
				imageBox2.setVisible(true);
				bOpen.setVisible(false);
				bTake.setVisible(true);
			}
		});
		bOpen.setBounds(470, 400, 150, 30);
		bOpen.setBackground(new Color(165, 42, 42));
		bOpen.setForeground(Color.white);
		add(bOpen);
	}
	
	public void createButtonTakeEnvelope()
	{
		bTake = new JButton("Weź kopertę");
		bTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (envelope == null) {
					envelope = new Envelope(null);
				}

				envelope.setVisible(true);
			}
		});
		bTake.setBounds(470, 270, 150, 30);
		bTake.setVisible(false);
		add(bTake);
		
	}
	
	public void createButtonToCancel()
	{
		bCancel = new JButton("Wróć do gry");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		bCancel.setBounds(200, 600, 120, 25);
		add(bCancel);
	}
}
