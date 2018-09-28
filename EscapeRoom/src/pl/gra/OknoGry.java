package pl.gra;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import pl.gra.zagadki.Zagadka;
import pl.gra.zagadki.Zagadka2;
import pl.gra.zagadki.Zagadka3;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class OknoGry extends EscapeRoom {

	private JPanel background, image;
	private JButton bstart, bSwitch, zagadka1, zagadka2, zagadka3;
	private JLabel ltitle, lcounter, lcounter1,komunikat,odpowiedzi,enterCode;
	private JTextArea ltekst;
	private JTextField code;
	private Timer tm;
	private static final String exitCode = "156";
	private int i = 299;
	private int minuty, sekundy;
	private String text = "";
	private Zagadka fib;
	private Zagadka2 znaki;
	private Zagadka3 liczby;

	public OknoGry() {
		
		setWindowParameters();
		createButtonStart();
		createLabelTitle();
		createTextAboutAuthor();
		createBlackBackground();
		createImageParameters();
		createButtonSwitch();
		createFirstRiddle ();
		createSecondRiddle();
		createThirdRiddle();
		createLabelBeforeTheTimer();
		createLabelCountdownOfTime();
		createLabelMessageToTheCounter();
		createLabelToCopyResultsOfRiddles();
		createLabelToWriteExitCode();
		createTimer();
		createTextFieltToEnterExitCode();
		
	}
	
	public void setWindowParameters()
	{
		setBounds(100, 100, 1200, 800);
		setTitle("EscapeRoom");
		setLayout(null);
	}
	
	public void createButtonStart()
	{
		bstart = new JButton("Rozpocznij grę");
		bstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ltitle.setVisible(false);
				bstart.setVisible(false);
				ltekst.setVisible(false);
				background.setVisible(true);
				bSwitch.setVisible(true);
				lcounter.setVisible(true);
				lcounter1.setVisible(true);
				komunikat.setVisible(true);
				odpowiedzi.setVisible(true);
				enterCode.setVisible(true);
				code.setVisible(true);
				tm.start();
			}
		});
		bstart.setFont(new Font("SansSerif", Font.BOLD, 20));
		bstart.setBounds(500, 300, 200, 50);
		add (bstart); 
	}
	
	public void createLabelTitle()
	{
		ltitle = new JLabel("POKÓJ LICZB", JLabel.CENTER);
		ltitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltitle.setBounds(400, 70, 400, 200);
		ltitle.setForeground(Color.RED);
		ltitle.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(ltitle);
	}
	
	public void createTextAboutAuthor()
	{
		ltekst = new JTextArea("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "Inżynieria Oprogramowania - Programowanie \npod kierunkiem mgr.inż. Krzysztofa Węzowskiego");
		ltekst.setBounds(700, 500, 350, 100);
		ltekst.setFont(new Font("SansSerif", Font.BOLD, 15));
		ltekst.setLineWrap(true);
		add(ltekst);
		
	}
	
	public void createBlackBackground()
	{
		background = new JPanel();
		background.setBounds(50, 50, 1100, 500);
		background.setBackground(Color.black);
		background.setVisible(false);
		add(background);
	}
	
	public void createImageParameters()
	{
		image = new ImagePanel0();
		image.setBounds(50, 50, 1100, 500);
		image.setVisible(false);
		add(image);
	}
	
	public void createButtonSwitch()
	{
		bSwitch = new JButton();
		bSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				bSwitch.setVisible(false);
				image.setVisible(true);
				zagadka1.setVisible(true);
				zagadka2.setVisible(true);
				zagadka3.setVisible(true);
			}
		});
		bSwitch.setToolTipText("Włącz światło"); 
		bSwitch.setBackground(Color.black);

		bSwitch.setForeground(Color.black);
		bSwitch.setBounds(1000, 200, 10, 5);
		bSwitch.setVisible(false);
		add(bSwitch);
	}
	
	public void createFirstRiddle ()
	{
		zagadka1 = new JButton("Zagadka1");
		zagadka1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //otwarcie okna dialogowego z zagadką 
				if (fib == null) {
					fib = new Zagadka(null); // tworzenie nowego obiektu klasy zagadka, gdyby wcześniej nie był
												// utworzony
				}
				
				fib.setVisible(true);
				fib.setFocus(); //funkcja ustawiająca kursor w JTextField do wpisania odpowiedzi
				
				if (fib.isOK()) {
					odpowiedzi.setText(text + fib.getOdp()); // dodanie poprawnej odpowiedzi do notatnika JLabel
				}
			
				text = 	odpowiedzi.getText() + "   "; 	 //ustawienie nowej wartości pola text									
			}
		});
		zagadka1.setBounds(300,400, 100,30);
		zagadka1.setVisible(false);
		add(zagadka1);
	}
	
	public void createSecondRiddle()
	{
		zagadka2 = new JButton("Zagadka2");
		zagadka2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (znaki == null) {
					znaki = new Zagadka2(null);
				}
				
				znaki.setVisible(true);
				znaki.setFocus();
				
				if (znaki.isOK()) {
					odpowiedzi.setText(text + znaki.getOdp());
				}
				text = odpowiedzi.getText() + "   ";
					
			}
		});
		zagadka2.setBounds(400,300, 100,30);
		zagadka2.setVisible(false);
		add(zagadka2);
	}
	
	public void createThirdRiddle()
	{
		zagadka3 = new JButton("Zagadka3");
		zagadka3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (liczby == null) {
					liczby = new Zagadka3(null);
				}
				
				liczby.setVisible(true);
				liczby.setFocus();
				
				if (liczby.isOK()) {
					odpowiedzi.setText(text + liczby.getOdp());
				}
			
				text = 	odpowiedzi.getText() + "   "; 	
				
			}
		});
		zagadka3.setBounds(500,200, 100,30);
		zagadka3.setVisible(false);
		add(zagadka3);
	}
	
	public void createLabelBeforeTheTimer()
	{
		lcounter = new JLabel("Pozostały czas:  ");
		lcounter.setBounds(800, 600, 200, 50);
		lcounter.setFont(new Font("SansSerif", Font.BOLD, 20));
		lcounter.setVisible(false);
		add(lcounter);
	}
	
	public void createLabelCountdownOfTime()
	{
		lcounter1 = new JLabel("5:00");
		lcounter1.setBounds(960, 600, 200, 50);
		lcounter1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lcounter1.setVisible(false);
		add(lcounter1);
	}
	
	public void createLabelMessageToTheCounter()
	{		
		komunikat = new JLabel("  ");
		komunikat.setBounds(800, 670, 300, 50);
		komunikat.setForeground(Color.RED);
		komunikat.setFont(new Font("SansSerif", Font.BOLD, 17));
		komunikat.setVisible(false);
		add(komunikat);
	}
	
	public void createLabelToCopyResultsOfRiddles()
	{
		odpowiedzi = new JLabel(text);
		odpowiedzi.setBounds(50, 600, 300,50);
		odpowiedzi.setFont(new Font("SansSerif", Font.BOLD, 20));
		odpowiedzi.setVisible(false);
		add(odpowiedzi);
	}
	
	public void createLabelToWriteExitCode()
	{
		enterCode = new JLabel("Wpisz kod:  ");
		enterCode.setBounds(50, 670, 300,50);
		enterCode.setFont(new Font("SansSerif", Font.BOLD, 20));
		enterCode.setVisible(false);
		add(enterCode);	
	}
	
	public void createTimer()
	{
		tm = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minuty = i / 60;
				sekundy = i % 60;

				if (i < 60) {
					if (i < 0) {
						tm.stop(); // zatrzymanie timera
						komunikat.setText("Czas minął nie udało ci się wyjść!");
						code.setEditable(false); // po upłynięciu czasu, nie można już wpisać odpowiedzi
					}

					else if (sekundy < 10) // zaprogramowanie aby sekundy od 0 do 9 , pokazywały się z dodatkowym zerem
											// z przodu tj. 01, 02 itp.
					{
						lcounter1.setForeground(Color.RED);
						Toolkit.getDefaultToolkit().beep();
						lcounter1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
					}
					
					else {
						lcounter1.setForeground(Color.RED); // ostatnia minuta wyświetla się z kolorze czerwonym
						Toolkit.getDefaultToolkit().beep(); // dla zwiększenia napiecia każda sekunda w ostatniej
															// minucie z dzwiękiem
						lcounter1.setText(Integer.toString(minuty) + ":" + Integer.toString(sekundy));
					}

				}

				else if (sekundy < 10) {
					lcounter1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
				} 
				else {
					lcounter1.setText(Integer.toString(minuty) + ":" + Integer.toString(sekundy));
				}
				i--;

			}

		});
	}
	
	public void createTextFieltToEnterExitCode()
	{
		code = new JTextField();
		code.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (code.getText().equals(exitCode)) {
					tm.stop();
					komunikat.setText("Kod poprawny, udało Ci się wyjść");
					code.setEditable(false);
				}
				
				else {
					komunikat.setText("Kod błędny, próbuj dalej");
				}
			
			}
	       });
		code.setBounds(180, 670, 150, 40);
		code.setFont(new Font("SansSerif", Font.BOLD, 20));
		code.setVisible(false);
		add(code);
	}
}
//klasa do dodawania obrazów do programu, 
class ImagePanel0 extends JPanel {

	private BufferedImage image;

	public ImagePanel0() {
		super();

		File imageFile = new File("images/obraztest.jpg");
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

	}

	// @Override
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);

	}

}

