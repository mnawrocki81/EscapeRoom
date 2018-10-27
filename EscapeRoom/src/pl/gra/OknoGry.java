package pl.gra;
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

	private JButton bStart, bSwitch, bZagadka1, bZagadka2, bZagadka3, bZagadka4, 
	bPrompt, bZagadka5, bLetter, bBox, bExitCode;
	private JLabel house, blackroom, imageroom, lTitle, lCounter, lCounter1,lKomunikat, lOdpowiedzi;
	private JTextArea lTekst, lPrompt;
	private JTextField tCode;
	private JScrollPane sPrompt;
	private Timer tm;
	private static final String exitCode = "FAVOL";
	private int i = 1199;
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
		createHouseImage();
		createLabelTitle();
		createTextAboutAuthor();
		createButtonStart();
		createImageBlackRoom();
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
	
	public void createHouseImage()
	{
		house = new JLabel(new ImageIcon("images/house1.jpg"));
		house.setBounds(242, 100, 716, 494);
		add(house);
	}
	
	public void createLabelTitle()
	{
		lTitle = new JLabel("POKÓJ LICZB", JLabel.CENTER);
		lTitle.setBounds(400, 20, 400, 50);
		lTitle.setForeground(Color.RED);
		lTitle.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(lTitle);
	}
	
	public void createTextAboutAuthor()
	{
		lTekst = new JTextArea("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "Inżynieria Oprogramowania - Programowanie \npod kierunkiem mgr.inż. Krzysztofa Węzowskiego");
		lTekst.setBounds(600, 630, 350, 100);
		lTekst.setFont(new Font("SansSerif", Font.BOLD, 15));
		lTekst.setLineWrap(true);
		add(lTekst);
		
	}
	
	public void createButtonStart()
	{
		bStart = new JButton("Rozpocznij grę");
		bStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lTitle.setVisible(false);
				bStart.setVisible(false);
				lTekst.setVisible(false);
				house.setVisible(false);
				blackroom.setVisible(true);
				bSwitch.setVisible(true);
				lCounter.setVisible(true);
				lCounter1.setVisible(true);
				lKomunikat.setVisible(true);
				lOdpowiedzi.setVisible(true);
				bPrompt.setVisible(true);
				sPrompt.setVisible(true);
				tCode.setVisible(true);
				tm.start();
			}
		});
		bStart.setFont(new Font("SansSerif", Font.BOLD, 20));
		bStart.setBackground(Color.darkGray);
		bStart.setForeground(Color.white);
		bStart.setBounds(500, 450, 200, 50);
		add (bStart); 
	}
	
	
	public void createImageBlackRoom()
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
		bSwitch.setBorderPainted(false);
		bSwitch.setBounds(1000, 200, 100, 50);
		bSwitch.setVisible(false);
		add(bSwitch);
	}
	
	public void createFirstRiddle ()
	{
		bZagadka1 = new JButton("Muszla");
		bZagadka1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //otwarcie okna dialogowego z zagadką 
				if (fib == null) {
					fib = new Zagadka(null); // tworzenie nowego obiektu klasy zagadka, gdyby wcześniej nie był
												// utworzony
					
				}
				
				fib.setVisible(true);
				//fib.setFocus(); //funkcja ustawiająca kursor w JTextField do wpisania odpowiedzi
				
				if (fib.isOK()) {
					lOdpowiedzi.setText(text + fib.getOdp()); // dodanie poprawnej odpowiedzi do notatnika JLabel
				}
			
				text = 	lOdpowiedzi.getText() + "   "; 	 //ustawienie nowej wartości pola text
				
				if (text.length()==20)
					bExitCode.setVisible(true);
			}
		});
		bZagadka1.setBounds(150,450, 100,30);
		bZagadka1.setVisible(false);
		add(bZagadka1);
	}
	
	public void createSecondRiddle()
	{
		bZagadka2 = new JButton("Znaki");
		bZagadka2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (znaki == null) {
					znaki = new Zagadka2(null);
				}
				
				znaki.setVisible(true);
				
				if (znaki.isOK()) {
					lOdpowiedzi.setText(text + znaki.getOdp());
				}
				text = lOdpowiedzi.getText() + "   ";	
				
				if (text.length()==20)
					bExitCode.setVisible(true);
				
				}
		});
		bZagadka2.setBounds(450,350, 100,30);
		bZagadka2.setVisible(false);
		add(bZagadka2);
	}
	
	public void createThirdRiddle()
	{
		bZagadka3 = new JButton("Liczby");
		bZagadka3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (liczby == null) {
					liczby = new Zagadka3(null);
				}
				
				liczby.setVisible(true);
				
				if (liczby.isOK()) {
					lOdpowiedzi.setText(text + liczby.getOdp());
				}
			
				text = 	lOdpowiedzi.getText() + "   "; 	
				
				if (text.length()==20)
					bExitCode.setVisible(true);
			}
		});
		bZagadka3.setBounds(500,250, 100,30);
		bZagadka3.setVisible(false);
		add(bZagadka3);
	}
	
	public void createFourthRiddle()
	{
		bZagadka4 = new JButton("Zegar");
		bZagadka4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (clock == null) {
					clock = new Zagadka4 (null);
				}
				
				clock.setVisible(true);
								
				if (clock.isOK()) {
					lOdpowiedzi.setText(text + clock.getOdp());
				}
			
				text = 	lOdpowiedzi.getText() + "   "; 	
				
				if (text.length() == 20)
					bExitCode.setVisible(true);
			}
		});
		bZagadka4.setBounds(700,200, 100,30);
		bZagadka4.setVisible(false);
		add(bZagadka4);
	
	}
	
	public void createFifthRiddle() 
	{
		bZagadka5 = new JButton("Kartkówka");
		bZagadka5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (card == null) {
					card = new Zagadka5 (null);
				}
				
				card.setVisible(true);
								
				if (card.isOK()) {
					lOdpowiedzi.setText(text + card.getOdp());
				}
			
				text = 	lOdpowiedzi.getText() + "   "; 
				
				if (text.length()==20)
					bExitCode.setVisible(true);
								
			}
		});
		bZagadka5.setBounds(850,400, 100,30);
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
		bLetter.setBounds(200,250, 100,30);
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
		bBox.setBounds(700,350, 100,30);
		bBox.setVisible(false);
		add(bBox);	
	}
	
	
	public void createLabelBeforeTheTimer()
	{
		lCounter = new JLabel("Pozostały czas:  ");
		lCounter.setBounds(800, 600, 200, 50);
		lCounter.setFont(new Font("SansSerif", Font.BOLD, 20));
		lCounter.setVisible(false);
		add(lCounter);
	}
	
	public void createLabelCountdownOfTime()
	{
		lCounter1 = new JLabel("20:00");
		lCounter1.setBounds(960, 600, 200, 50);
		lCounter1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lCounter1.setVisible(false);
		add(lCounter1);
	}
	
	public void createLabelMessageToTheCounter()
	{		
		lKomunikat = new JLabel("  ");
		lKomunikat.setBounds(800, 650, 300, 50);
		lKomunikat.setForeground(Color.RED);
		lKomunikat.setFont(new Font("SansSerif", Font.BOLD, 17));
		lKomunikat.setVisible(false);
		add(lKomunikat);
	}
	
	public void createLabelToCopyResultsOfRiddles()
	{
		lOdpowiedzi = new JLabel(text);
		lOdpowiedzi.setBounds(50, 600, 300,50);
		lOdpowiedzi.setFont(new Font("SansSerif", Font.BOLD, 20));
		lOdpowiedzi.setVisible(false);
		add(lOdpowiedzi);
	}
	
	public void createButtonToWriteExitCode()
	{
		bExitCode = new JButton("Wpisz kod");
		bExitCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (panelexitCode == null) {
					panelexitCode = new ExitCode(null);
				}
				
				panelexitCode.setOdp();
				panelexitCode.setVisible(true);
								
				if (panelexitCode.isOK()) {
					tCode.setEditable(true);
					tCode.setText(panelexitCode.getOdp());
					tCode.requestFocusInWindow();
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
						lKomunikat.setText("Czas minął nie udało ci się wyjść!");
						bExitCode.setVisible(false);
						tCode.setEditable(false); // po upłynięciu czasu, nie można już wpisać odpowiedzi
					}

					else if (sekundy < 10) // zaprogramowanie aby sekundy od 0 do 9 , pokazywały się z dodatkowym zerem
											// z przodu tj. 01, 02 itp.
					{
						lCounter1.setForeground(Color.RED);
						Toolkit.getDefaultToolkit().beep();
						lCounter1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
					}
					
					else {
						lCounter1.setForeground(Color.RED); // ostatnia minuta wyświetla się z kolorze czerwonym
						Toolkit.getDefaultToolkit().beep(); // dla zwiększenia napiecia każda sekunda w ostatniej
															// minucie z dzwiękiem
						lCounter1.setText(Integer.toString(minuty) + ":" + Integer.toString(sekundy));
					}

				}

				else if (sekundy < 10) {
					lCounter1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
				} 
				else {
					lCounter1.setText(Integer.toString(minuty) + ":" + Integer.toString(sekundy));
				}
				i--;

			}

		});
	}
	
	public void createTextFieltToEnterExitCode()
	{
		tCode = new JTextField();
		tCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCode.getText().equals(exitCode)) {
					tm.stop();
					lKomunikat.setText("Kod poprawny, udało Ci się wyjść!");
					bExitCode.setVisible(false);
					tCode.setEditable(false);
				}

				else {
					lKomunikat.setText("Kod błędny, próbuj dalej!");
				}

			}
		});
		tCode.setBounds(265, 650, 150, 40);
		tCode.setFont(new Font("SansSerif", Font.BOLD, 20));
		tCode.setHorizontalAlignment(JTextField.CENTER);
		tCode.setVisible(false);
		tCode.setEditable(false);
		add(tCode);
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
				+ "\nZnajdź i otwórz skrzynkę,"
				+ "\ndo kodu do skrzynki potrzebujesz wyniku trzech konkretnych zagadek"
				+ "\nw skrzynce znajdziesz wskazówkę do ostatecznego hasła! "
				+ "\nOdkryj prawdziwe nazwisko Twojego oprawcy!"
				+ "\nWyniki zagadek i nazwisko mają ze sobą coś wspólnego");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(180, 720, 400, 22);
		sPrompt.setVisible(false);
		add(sPrompt);
	}
}
