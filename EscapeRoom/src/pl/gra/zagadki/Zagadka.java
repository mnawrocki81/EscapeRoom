package pl.gra.zagadki;
import java.awt.Color;
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

//zaprogramowanie okna z zagadką, dziedziczącego po klasie JDialog
public class Zagadka extends JDialog {
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JPanel imageZagadka1;
	private JLabel odpZagadka1, odpTrue, odpWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private boolean okData = false;
	private static final String  result = "5";
	
	
	
	public Zagadka(JFrame owner) {
	   super(owner, "Zagadka1", true);
	   
	   setZagadka1Parametres ();
	   createImageParameters();
	   createLabelGiveAnswer();
	   createLabelAnswerTrue();
	   createLabelAwswerWrong();
	   createTextFieldToEnterAnswer();
	   createButtonPrompt();
	   createTextAreaWithPrompt();
	   createButtonConfirmingTheAnswer ();
	   createButtonToCancel();
	   
	}
	
	public void setZagadka1Parametres ()
	{
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // zamknąć okno można tylko przyciskiem "Wróć" lub
																// podając raz dobrą odpowiedz
	}
	
	public void createImageParameters()
	{
		   imageZagadka1 = new ImagePanel1();
		   imageZagadka1.setBounds(50, 30, 1000, 500);
		   add(imageZagadka1);
	}
	
	public void createLabelGiveAnswer()
	{
		odpZagadka1 = new JLabel("Podaj odpowiedź:  ");
		odpZagadka1.setBounds(50, 550, 180, 30);
		odpZagadka1.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(odpZagadka1);
	}
	
	public void createLabelAnswerTrue()
	{
		odpTrue = new JLabel("Odpowiedź poprawna!");
		odpTrue.setBounds(50, 600, 180, 30);
		odpTrue.setFont(new Font("SansSerif", Font.BOLD, 13));
		odpTrue.setVisible(false);
		add(odpTrue);
		
	}
	
	
	public void createLabelAwswerWrong()
	{
		odpWrong = new JLabel("To nie to! Przemyśl i spróbuj ponownie!");
		odpWrong.setBounds(400, 600, 350, 30);
		odpWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		odpWrong.setForeground(Color.RED);
		odpWrong.setVisible(false);
		add(odpWrong);
		
	}
	
	public void createTextFieldToEnterAnswer()
	{
		tAnswer = new JTextField();
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					odpTrue.setVisible(true);
					odpWrong.setVisible(false);
					odpWrong.setVisible(false);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});

		   tAnswer.setBounds(250, 550, 100, 30);
		   tAnswer.setFont(new Font("SansSerif", Font.BOLD, 20));
		   tAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
	       add(tAnswer);
	}
	
	public void createButtonPrompt()
	{
	       bPrompt = new JButton("Podpowiedź");
	       bPrompt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					lPrompt.setVisible(true);
				}
			});
	       bPrompt.setBounds(400, 550, 120, 25);
	       add(bPrompt);
	}
	
	public void createTextAreaWithPrompt()
	{
		lPrompt = new JTextArea("Skorupa ślimaka, to przykład boskiej proporcji w przyrodzie (lub złotego podziału), "
				+ "\nzwróć uwagę na ciąg liczbowy i skojarz go z popularnym ciągiem określonym przez "
				+ "\nwłoskiego matematyka z Pizy w 1202 r.,"
				+ "\nktóry nazywał się Fibonacci, a w jego ciągu pierwsza + druga cyfra daje trzecią"
				+ "\ndruga + trzecia daje czwartą i tak dalej."); // podpowiedzi wyświetlają się po jednej linijce,
																	// stopniowo coraz bardziej szczegółowo, mozna
																	// przewijać scrollem
		lPrompt.setVisible(false); // podpowiedź widocznna po kliknięciu przycisku na życzenie gracza
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(530, 550, 500, 22);
		add(sPrompt);
	}
	
	public void createButtonConfirmingTheAnswer ()
	{
		//przycisk Potwierdź może być użyty tylko raz, pózniej zostaje ukryty i pojawia się komunikat o poprawnej odpowiedzi
		bAnswer = new JButton("Potwierdź");
		bAnswer.setVisible(true);
		bAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					odpTrue.setVisible(true);
					odpWrong.setVisible(false);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});
		bAnswer.setBounds(50, 600, 120, 25);
		add(bAnswer);
		
	}
	
	public void createButtonToCancel()
	{
		bCancel = new JButton("Wróć");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				okData = false;
				setVisible(false);
			}
		});
		bCancel.setBounds(200, 600, 120, 25);
		add(bCancel);
	}
	
	//Funkcje do współpracy głównego okna gry i okna dialogowego
	public String getOdp() {
		return tAnswer.getText();
	}
    
	public void setFocus() {
		tAnswer.requestFocusInWindow();

	}
    
	public boolean isOK() {
		return okData;
	}
       
    
}

//klasa do dodawania obrazów do programu, jak w oknie głównym
class ImagePanel1 extends JPanel {

	private BufferedImage imageZagadka1;

	public ImagePanel1() {
		super();

		File imageFile1 = new File("images/slimak.jpg");
		try {
			imageZagadka1 = ImageIO.read(imageFile1);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

	}

	// @Override
	public void paintComponent(Graphics g) {

		Graphics2D zagadka1 = (Graphics2D) g;
		zagadka1.drawImage(imageZagadka1, 0, 0, this);

	}
}

