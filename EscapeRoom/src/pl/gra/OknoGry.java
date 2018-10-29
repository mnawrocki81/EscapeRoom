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

	private JButton bStart, bSwitch, bRiddle1, bRiddle2, bRiddle3, bRiddle4, bRiddle5,
	bPrompt, bLetter, bBox, bExitCode, bNotebook;
	private JLabel imageHouse, imageBlackroom, imageRoom, imageOpendoor, lTitle, lCounter, lCounter1,lInfo, lAnswers;
	private JTextArea lText, lPrompt;
	private JTextField tCode;
	private JScrollPane sPrompt;
	private Timer tm;
	private static final String exitCode = "FAVOL";
	private int i = 1799;
	private int minutes, seconds;
	private String text = "";
	private Zagadka fib;
	private Zagadka2 signs;
	private Zagadka3 numbers;
	private Zagadka4 clock;
	private Zagadka5 card;
	private Letter letter;
	private ExitCode panelexitCode;
	private Box box;
	private Notebook notebook;

	public OknoGry() {
		
		setWindowParameters();
		createHouseImage();
		createLabelTitle();
		createTextAboutAuthor();
		createButtonStart();
		createImageBlackRoom();
		createImageRoom();
		createImageOpenDoor();
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
		createNotebook();
		
	}
	
	public void setWindowParameters() {
		setBounds(100, 100, 1200, 800);
		setTitle("EscapeRoom");
		setLayout(null);
	}

	public void createHouseImage() {
		imageHouse = new JLabel(new ImageIcon("images/house1.jpg"));
		imageHouse.setBounds(242, 100, 716, 494);
		add(imageHouse);
	}

	public void createLabelTitle() {
		lTitle = new JLabel("POKÓJ LICZB", JLabel.CENTER);
		lTitle.setBounds(400, 20, 400, 50);
		lTitle.setForeground(Color.RED);
		lTitle.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(lTitle);
	}

	public void createTextAboutAuthor() {
		lText = new JTextArea("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "Inżynieria Oprogramowania - Programowanie \npod kierunkiem mgr.inż. Krzysztofa Węzowskiego");
		lText.setBounds(600, 630, 350, 100);
		lText.setFont(new Font("SansSerif", Font.BOLD, 15));
		lText.setLineWrap(true);
		add(lText);
	}

	public void createButtonStart() {
		bStart = new JButton("Rozpocznij grę");
		bStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lTitle.setVisible(false);
				bStart.setVisible(false);
				lText.setVisible(false);
				imageHouse.setVisible(false);
				imageBlackroom.setVisible(true);
				bSwitch.setVisible(true);
				lCounter.setVisible(true);
				lCounter1.setVisible(true);
				lInfo.setVisible(true);
				lAnswers.setVisible(true);
				bPrompt.setVisible(true);
				sPrompt.setVisible(true);
				tCode.setVisible(true);
				bNotebook.setVisible(true);
				tm.start();
			}
		});
		bStart.setFont(new Font("SansSerif", Font.BOLD, 20));
		bStart.setBackground(Color.darkGray);
		bStart.setForeground(Color.white);
		bStart.setBounds(500, 450, 200, 50);
		add(bStart);
	}

	public void createImageBlackRoom() {
		imageBlackroom = new JLabel(new ImageIcon("images/blackroom.jpg"));
		imageBlackroom.setBounds(50, 50, 1100, 500);
		imageBlackroom.setVisible(false);
		add(imageBlackroom);
	}

	public void createImageRoom() {
		imageRoom = new JLabel(new ImageIcon("images/obraztest.jpg"));
		imageRoom.setBounds(50, 50, 1100, 500);
		imageRoom.setVisible(false);
		add(imageRoom);
	}
	
	public void createImageOpenDoor() {
		imageOpendoor = new JLabel(new ImageIcon("images/opendoor.jpg"));
		imageOpendoor.setBounds(50, 50, 1100, 500);
		imageOpendoor.setVisible(false);
		add(imageOpendoor);
	}

	public void createButtonSwitch() {
		bSwitch = new JButton();
		bSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageBlackroom.setVisible(false);
				bSwitch.setVisible(false);
				imageRoom.setVisible(true);
				bRiddle1.setVisible(true);
				bRiddle2.setVisible(true);
				bRiddle3.setVisible(true);
				bRiddle4.setVisible(true);
				bRiddle5.setVisible(true);
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

	public void createFirstRiddle() {
		bRiddle1 = new JButton("Muszla");
		bRiddle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fib == null) {
					fib = new Zagadka(null); 
				}

				fib.setVisible(true);
				fib.setFocus();
				
				if (fib.isOK()) {
					lAnswers.setText(text + fib.getOdp()); 
					text = lAnswers.getText() + "   "; 
				}

				if (text.length() == 20)
					bExitCode.setVisible(true);
				
			}
		});
		bRiddle1.setBounds(150, 450, 100, 30);
		bRiddle1.setVisible(false);
		add(bRiddle1);
	}

	public void createSecondRiddle() {
		bRiddle2 = new JButton("Znaki");
		bRiddle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (signs == null) {
					signs = new Zagadka2(null);
				}

				signs.setVisible(true);
				signs.setFocus();

				if (signs.isOK()) {
					lAnswers.setText(text + signs.getOdp());
					text = lAnswers.getText() + "   ";
				}
				
				if (text.length() == 20)
					bExitCode.setVisible(true);
				
			}
		});
		bRiddle2.setBounds(450, 350, 100, 30);
		bRiddle2.setVisible(false);
		add(bRiddle2);
	}

	public void createThirdRiddle() {
		bRiddle3 = new JButton("Liczby");
		bRiddle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (numbers == null) {
					numbers = new Zagadka3(null);
				}

				numbers.setVisible(true);
				
				if (numbers.isOK()) {
					lAnswers.setText(text + numbers.getOdp());
					text = lAnswers.getText() + "   ";
				}

				if (text.length() == 20)
					bExitCode.setVisible(true);
				
			}
		});
		bRiddle3.setBounds(500, 250, 100, 30);
		bRiddle3.setVisible(false);
		add(bRiddle3);
	}

	public void createFourthRiddle() {
		bRiddle4 = new JButton("Zegar");
		bRiddle4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (clock == null) {
					clock = new Zagadka4(null);
				}

				clock.setVisible(true);

				if (clock.isOK()) {
					lAnswers.setText(text + clock.getOdp());
					text = lAnswers.getText() + "   ";
				}

				if (text.length() == 20)
					bExitCode.setVisible(true);
				
			}
		});
		bRiddle4.setBounds(700, 200, 100, 30);
		bRiddle4.setVisible(false);
		add(bRiddle4);
	}

	public void createFifthRiddle() {
		bRiddle5 = new JButton("Kartkówka");
		bRiddle5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (card == null) {
					card = new Zagadka5(null);
				}

				card.setVisible(true);

				if (card.isOK()) {
					lAnswers.setText(text + card.getOdp());
					text = lAnswers.getText() + "   ";
				}

				if (text.length() == 20)
					bExitCode.setVisible(true);
				
			}
		});
		bRiddle5.setBounds(850, 400, 100, 30);
		bRiddle5.setVisible(false);
		add(bRiddle5);

	}

	public void createButtonLetter() {
		bLetter = new JButton("List");
		bLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (letter == null) {
					letter = new Letter(null);
				}

				letter.setVisible(true);

			}
		});
		bLetter.setBounds(200, 250, 100, 30);
		bLetter.setBackground(Color.gray);
		bLetter.setVisible(false);
		add(bLetter);
	}

	public void createButtonBox() {
		bBox = new JButton("Skrzynka");
		bBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (box == null) {
					box = new Box(null);
				}

				box.setVisible(true);
				box.setFocus();
			}
		});
		bBox.setBounds(700, 350, 100, 30);
		bBox.setBackground(Color.green);
		bBox.setVisible(false);
		add(bBox);
	}

	public void createLabelBeforeTheTimer() {
		lCounter = new JLabel("Pozostały czas:  ");
		lCounter.setBounds(800, 600, 200, 50);
		lCounter.setFont(new Font("SansSerif", Font.BOLD, 20));
		lCounter.setVisible(false);
		add(lCounter);
	}
	
	public void createLabelCountdownOfTime() {
		lCounter1 = new JLabel("30:00");
		lCounter1.setBounds(960, 600, 200, 50);
		lCounter1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lCounter1.setVisible(false);
		add(lCounter1);
	}

	public void createLabelMessageToTheCounter() {
		lInfo = new JLabel("  ");
		lInfo.setBounds(800, 650, 300, 50);
		lInfo.setForeground(Color.RED);
		lInfo.setFont(new Font("SansSerif", Font.BOLD, 17));
		lInfo.setVisible(false);
		add(lInfo);
	}
	
	public void createLabelToCopyResultsOfRiddles() {
		lAnswers = new JLabel(text);
		lAnswers.setBounds(50, 600, 300, 50);
		lAnswers.setFont(new Font("SansSerif", Font.BOLD, 20));
		lAnswers.setVisible(false);
		add(lAnswers);
	}
	
	public void createButtonToWriteExitCode() {
		bExitCode = new JButton("Wpisz hasło");
		bExitCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (panelexitCode == null) {
					panelexitCode = new ExitCode(null);
				}

				panelexitCode.setOdp();
				panelexitCode.setVisible(true);
				lInfo.setText("");

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
	
		
	public void createTimer() {
		tm = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minutes = i / 60;
	            seconds = i % 60;

	                if (i < 60) {
	                    if (i < 0) {
	                        stopTimer();
	                        lInfo.setText("Czas minął, nie udało ci się wyjść!");
	                    }

	                    else if (seconds < 10) {
	                    	setTimerLastMinute();
	                    	showSecondsWithZero();
	                    }

	                    else {
	                    	setTimerLastMinute();
	                    	showSecondsWithoutZero();
	                    }
	                }

	                else if (seconds < 10) {
	                	showSecondsWithZero();
	                } else {
	                	showSecondsWithoutZero();
	                }
	                i--;
	            }
	        });
	    }
	
	public void setTimerLastMinute(){
		lCounter1.setForeground(Color.RED);
		Toolkit.getDefaultToolkit().beep();
	}
	
	public void stopTimer() {
		tm.stop();
		bExitCode.setVisible(false);
		tCode.setEditable(false);
	}
	
	public void showSecondsWithZero(){
		lCounter1.setText(Integer.toString(minutes) + ":0" + Integer.toString(seconds));
	}
	
	public void showSecondsWithoutZero() {
		lCounter1.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));
	}

	public void createTextFieltToEnterExitCode() {
		tCode = new JTextField();
		tCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCode.getText().equals(exitCode)) {
					stopTimer();
					lInfo.setText("Hasło poprawne, udało Ci się wyjść!");
					openDoor();
				}

				else {
					lInfo.setText("Hasło błędne, próbuj dalej!");
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
	
	public void openDoor() {
		imageRoom.setVisible(false);
		imageOpendoor.setVisible(true);
		bRiddle1.setVisible(false);
		bRiddle2.setVisible(false);
		bRiddle3.setVisible(false);
		bRiddle4.setVisible(false);
		bRiddle5.setVisible(false);
		bLetter.setVisible(false);
		bBox.setVisible(false);
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
	
	
	public void createNotebook() {
		bNotebook = new JButton("Notatnik");
		bNotebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (notebook == null) {
					notebook = new Notebook(null);
				}

				notebook.setVisible(true);
				}
		});
		bNotebook.setBounds(600, 720, 100, 22);
		bNotebook.setVisible(false);
		add(bNotebook);
	
	}
}
