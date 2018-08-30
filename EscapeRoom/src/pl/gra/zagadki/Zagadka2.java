package pl.gra.zagadki;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//zasada dzia≥ania analogiczna jak w klasie Zagadka

public class Zagadka2 extends JDialog {
	
	private JTextField tOdpowiedü;
	private JButton bPodpowiedü, bOdp, bCancel;
	private JPanel imageZagadka2;
	private JLabel odpZagadka2, odpPoprawna;
	private JTextArea lPodpowiedü;
	private JScrollPane sPodpowiedü;
	private boolean okData ;
	private static final String wynik = "1";
	
	public Zagadka2(JFrame owner) {
	   super(owner, "Zagadka2", true);
	   setBounds(150, 150, 1120, 700);
	   setLayout(null);
	   setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	   imageZagadka2 = new ImagePanel2();
	   imageZagadka2.setBounds(50, 30, 1000, 500);
	   add(imageZagadka2);
	   
	   odpZagadka2 = new JLabel("Podaj odpowiedü:  ");
	   odpZagadka2.setBounds(50, 550, 180, 30);
	   odpZagadka2.setFont(new Font("SansSerif", Font.BOLD, 20));
	   add(odpZagadka2);
	   
	   odpPoprawna = new JLabel("Odpowiedü poprawna!");
	   odpPoprawna.setBounds(50, 600, 180, 30);
	   odpPoprawna.setFont(new Font("SansSerif", Font.PLAIN ,14));
	   odpPoprawna.setVisible(false);
	   add(odpPoprawna);
       
	   tOdpowiedü = new JTextField();
	  
	   tOdpowiedü.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(wynik)) {
					okData = true;
					tOdpowiedü.setEditable(false);
					odpPoprawna.setVisible(true);
					bOdp.setVisible(false);
					setVisible(false);
				}
			}
		});

	   tOdpowiedü.setBounds(250, 550, 100, 30);
	   tOdpowiedü.setFont(new Font("SansSerif", Font.BOLD, 20));
	   tOdpowiedü.setLayout(new FlowLayout(FlowLayout.CENTER));
       add(tOdpowiedü);
       
       bPodpowiedü = new JButton("Podpowiedü");
	   bPodpowiedü.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPodpowiedü.setVisible(true);
			}
		});
       bPodpowiedü.setBounds(400, 550, 120, 25);
       add(bPodpowiedü);
       
       lPodpowiedü = new JTextArea("Przyjrzyj sie umiejscowieniu znakÛw na klawiaturze komputera");
       lPodpowiedü.setVisible(false);
       sPodpowiedü = new JScrollPane(lPodpowiedü);
       sPodpowiedü.setBounds(530, 550, 500, 22);
	   add(sPodpowiedü);
	   
	   bOdp = new JButton("Potwierdü");
	   bOdp.setVisible(true);
	   bOdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(wynik)) {
					okData = true;
					tOdpowiedü.setEditable(false);
					odpPoprawna.setVisible(true);
					bOdp.setVisible(false);
					setVisible(false);
				}
			}
		});
	   bOdp.setBounds(50, 600, 120, 25);
	   add(bOdp);
	   
	   bCancel = new JButton("WrÛÊ");
	   bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				okData = false;
				setVisible(false);
			}
		});
	   bCancel.setBounds(200, 600, 120, 25);
	   add(bCancel);

	}

	public String getOdp() {
		return tOdpowiedü.getText();
	}

	public void setFocus() {
		tOdpowiedü.requestFocusInWindow();
	}

	public boolean isOK() {
		return okData;
	}

}

class ImagePanel2 extends JPanel {

	private BufferedImage imageZagadka2;

	public ImagePanel2() {
		super();

		
		File imageFile2 = new File("images/komputer.jpg");
		try {
			imageZagadka2 = ImageIO.read(imageFile2);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}

	//@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D zagadka2 = (Graphics2D) g;
		zagadka2.drawImage(imageZagadka2, 0, 0, this);
		
	}
}
