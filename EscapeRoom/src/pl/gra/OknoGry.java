package pl.gra;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import pl.gra.zagadki.Box;
import pl.gra.zagadki.Letter;
import pl.gra.zagadki.Zagadka;
import pl.gra.zagadki.Zagadka2;
import pl.gra.zagadki.Zagadka3;
import pl.gra.zagadki.Zagadka4;
import pl.gra.zagadki.Zagadka5;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoGry extends EscapeRoom {

	private JButton bstart, bSwitch, bZagadka1, bZagadka2, bZagadka3, bZagadka4, 
	bPrompt, bZagadka5, bLetter, bBox, bExitCode;
	private JLabel blackroom, imageroom, ltitle, lcounter, lcounter1,komunikat,odpowiedzi;
	private JTextArea ltekst, lPrompt;
	private JTextField code;
	private JScrollPane sPrompt;
	private Timer tm;
	private static final String exitCode = "TEST";
	private int i = 299;
	private int minuty, sekundy;
	private String text = "";
	private Zagadka fib;
	private Zagadka2 znaki;
	private Zagadka3 liczby;
	private Zagadka4 clock;
	private Zagadka5 card;
	private Letter letter;
	private ExitCode panelexitCode;
	private Box box;

	public OknoGry() {
		
		setWindowParameters();
		createButtonStart();
		createLabelTitle();
		createTextAboutAuthor();
		createBlackRoom();
		createImageRoom();
		createButtonSwitch();
		createFirstRiddle ();
		createSecondRiddle();
		createThirdRiddle();
		createFourthRiddle();
		createFifthRiddle();
		createButtonLetter();
		createButtonBox();
		createLabelBeforeTheTimer();
		createLabelCountdownOfTime();
		createLabelMessageToTheCounter();
		createLabelToCopyResultsOfRiddles();
		createButtonToWriteExitCode();
		createTimer();
		createTextFieltToEnterExitCode();
		createButtonPrompt();
		createTextAreaWithPrompt();
		
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
				blackroom.setVisible(true);
				bSwitch.setVisible(true);
				lcounter.setVisible(true);
				lcounter1.setVisible(true);
				komunikat.setVisible(true);
				odpowiedzi.setVisible(true);
				bPrompt.setVisible(true);
				sPrompt.setVisible(true);
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
	
	public void createBlackRoom()
	{
		blackroom = new JLabel(new ImageIcon("images/blackroom.jpg"));
		blackroom.setBounds(50, 50, 1100, 500);
		blackroom.setVisible(false);
		add(blackroom);
	}
	
	public void createImageRoom()
	{
		imageroom = new JLabel(new ImageIcon("images/obraztest.jpg"));
		imageroom.setBounds(50, 50, 1100, 500);
		imageroom.setVisible(false);
		add(imageroom);
	}
	
	public void createButtonSwitch()
	{
		bSwitch = new JButton();
		bSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blackroom.setVisible(false);
				bSwitch.setVisible(false);
				imageroom.setVisible(true);
				bZagadka1.setVisible(true);
				bZagadka2.setVisible(true);
				bZagadka3.setVisible(true);
				bZagadka4.setVisible(true);
				bZagadka5.setVisible(true);
				bLetter.setVisible(true);
				bBox.setVisible(true);
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
		bZagadka1 = new JButton("Zagadka1");
		bZagadka1.addActionListener(new ActionListener() {
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
				
				if (text.length()==20)
					bExitCode.setVisible(true);
			}
		});
		bZagadka1.setBounds(300,400, 100,30);
		bZagadka1.setVisible(false);
		add(bZagadka1);
	}
	
	public void createSecondRiddle()
	{
		bZagadka2 = new JButton("Zagadka2");
		bZagadka2.addActionListener(new ActionListener() {
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
				
				if (text.length()==20)
					bExitCode.setVisible(true);
				
				}
		});
		bZagadka2.setBounds(400,300, 100,30);
		bZagadka2.setVisible(false);
		add(bZagadka2);
	}
	
	public void createThirdRiddle()
	{
		bZagadka3 = new JButton("Zagadka3");
		bZagadka3.addActionListener(new ActionListener() {
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
				
				if (text.length()==20)
					bExitCode.setVisible(true);
			}
		});
		bZagadka3.setBounds(500,200, 100,30);
		bZagadka3.setVisible(false);
		add(bZagadka3);
	}
	
	public void createFourthRiddle()
	{
		bZagadka4 = new JButton("Zagadka4");
		bZagadka4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (clock == null) {
					clock = new Zagadka4 (null);
				}
				
				clock.setVisible(true);
				clock.setFocus();
				
				if (clock.isOK()) {
					odpowiedzi.setText(text + clock.getOdp());
				}
			
				text = 	odpowiedzi.getText() + "   "; 	
				
				if (text.length() == 20)
					bExitCode.setVisible(true);
			}
		});
		bZagadka4.setBounds(700,150, 100,30);
		bZagadka4.setVisible(false);
		add(bZagadka4);
	
	}
	
	public void createFifthRiddle() 
	{
		bZagadka5 = new JButton("Zagadka5");
		bZagadka5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (card == null) {
					card = new Zagadka5 (null);
				}
				
				card.setVisible(true);
				card.setFocus();
				
				if (card.isOK()) {
					odpowiedzi.setText(text + card.getOdp());
				}
			
				text = 	odpowiedzi.getText() + "   "; 
				
				if (text.length()==20)
					bExitCode.setVisible(true);
								
			}
		});
		bZagadka5.setBounds(800,450, 100,30);
		bZagadka5.setVisible(false);
		add(bZagadka5);
		
	}
	
	public void createButtonLetter ()
	{
		bLetter = new JButton("List");
		bLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (letter == null) {
					letter = new Letter(null);
				}

				letter.setVisible(true);
									
			}
		});
		bLetter.setBounds(600,250, 100,30);
		bLetter.setVisible(false);
		add(bLetter);
		
	}
	
	
	public void createButtonBox()
	{
		bBox = new JButton("Skrzynka");
		bBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (box == null) {
					box = new Box(null);
				}
				
				box.setVisible(true);
									
			}
		});
		bBox.setBounds(700,300, 100,30);
		bBox.setVisible(false);
		add(bBox);	
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
		komunikat.setBounds(800, 650, 300, 50);
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
	
	public void createButtonToWriteExitCode()
	{
		bExitCode = new JButton("Wpisz kod");
		bExitCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (panelexitCode == null) {
					panelexitCode = new ExitCode(null);
				}
				
				panelexitCode.setVisible(true);
				
				if (panelexitCode.isOK()) {
					code.setEditable(true);
					code.setText(panelexitCode.getOdp());
					code.requestFocusInWindow();
				}
			
													
			}
		});
		bExitCode.setBounds(50, 650, 200, 40);
		bExitCode.setFont(new Font("SansSerif", Font.BOLD, 20));
		bExitCode.setVisible(false);
		add(bExitCode);
	}
	
		
	public void createTimer()
	{
		tm = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minuty = i / 60;
				sekundy = i % 60;

				if (i < 60) {
					if (i < 0) {
						tm.stop(); 
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
					komunikat.setText("Kod poprawny, udało Ci się wyjść!");
					code.setEditable(false);
				}

				else {
					komunikat.setText("Kod błędny, próbuj dalej!");
				}

			}
		});
		code.setBounds(265, 650, 150, 40);
		code.setFont(new Font("SansSerif", Font.BOLD, 20));
		code.setVisible(false);
		code.setEditable(false);
		add(code);
	}
	
	public void createButtonPrompt() {
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(50, 720, 120, 22);
		bPrompt.setVisible(false);
		add(bPrompt);
	}
	   
	public void createTextAreaWithPrompt() {
		lPrompt = new JTextArea("Tu masz podpowiedzi do gry, korzystaj gdy nie wiesz co robić dalej,"
				+ "\nkażda kolejna podpowiedź dotyczy kolejnego etapu gry "
				+ "\nlub jest coraz bardziej szczegółowa!"
				+ "\n"
				+ "\nZnajdź włącznik światła!"
				+ "\nZnajdź i przeczytaj list!"
				+ "\nZnajdź w pokoju zagadki i rozwiąż je, jest ich 5!"
				+ "\nPo rozwiązaniu zagadek będziesz mógł wpisać kod wyjścia!"
				+ "\nZnajdź i otwórz skrzynke,"
				+ "\ndo kodu do skrzynki potrzebujesz wyniku trzech konkretnych zagadek"
				+ "\nw skrzynce znajdziesz wskazówke do ostateczneg hasła! ");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(180, 720, 400, 22);
		sPrompt.setVisible(false);
		add(sPrompt);
	}
}
