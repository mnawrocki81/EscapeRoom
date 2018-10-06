package pl.gra.zagadki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Box extends JDialog {
	
	private JPanel imageBox1, imageBox2;
	private JButton bOpen, bTake, bCancel;
	private Envelope envelope;

	public Box(JFrame owner) {
		   super(owner, "Box", true);
		   
		   setLetterParametres ();
		   createImageParameters();
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
	
	public void  createImageParameters()
	{
		imageBox1 = new ImagePanelBox1();
		imageBox1.setBounds(50, 30, 1000, 500);
		add(imageBox1);
		
		imageBox2 = new ImagePanelBox2();
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

class ImagePanelBox1 extends JPanel {

	private BufferedImage imageBox1;

	public ImagePanelBox1() {
		super();

		File imageFileBox1 = new File("images/skrzynka1.jpg");

		try {
			imageBox1 = ImageIO.read(imageFileBox1);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D box1 = (Graphics2D) g;
		box1.drawImage(imageBox1, 0, 0, this);

	}
}

class ImagePanelBox2 extends JPanel {

	private BufferedImage imageBox2;

	public ImagePanelBox2() {
		super();

		File imageFileBox2 = new File("images/skrzynka2.jpg");
		try {
			imageBox2 = ImageIO.read(imageFileBox2);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D box2 = (Graphics2D) g;
		box2.drawImage(imageBox2, 0, 0, this);

	}
}
