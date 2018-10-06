package pl.gra.zagadki;

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

public class Letter extends JDialog  {
	
	private JPanel imageLetter;
	private JButton bCancel;
		
	public Letter(JFrame owner) {
		super(owner, "Letter", true);

		setLetterParametres();
		createImageParameters();
		createButtonToCancel();

	}
	
	public void setLetterParametres ()
	{
		setBounds(350, 50, 700,900);
		setLayout(null);
		//setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public void  createImageParameters()
	{
		imageLetter = new ImagePanelLetter();
		imageLetter.setBounds(20,20, 660, 843);
		add(imageLetter);
	}
	
	public void createButtonToCancel()
	{
		bCancel = new JButton("Wróć do gry");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		bCancel.setBounds(275, 750, 150, 30);
		add(bCancel);
	}
	
}

class ImagePanelLetter extends JPanel {

	private BufferedImage imageLetter;

	public ImagePanelLetter() {
		super();

		File imageFileLetter = new File("images/list.jpg");
		try {
			imageLetter = ImageIO.read(imageFileLetter);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

	}

	 @Override
	public void paintComponent(Graphics g) {

		Graphics2D letter = (Graphics2D) g;
		letter.drawImage(imageLetter, 0, 0, this);

	}
}
