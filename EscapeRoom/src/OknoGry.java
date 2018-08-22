import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
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

// tworzenie okna gry
public class OknoGry extends EscapeRoom {

	private JPanel t�o, image;
	private JButton bstart, w��cznik, zagadka1, zagadka2, zagadka3;
	private JLabel ltytu�, licznik, licznik1,komunikat,odpowiedzi,wpiszKod;
	private JTextArea ltekst;
	private JTextField kod;
	private Timer tm;
	private static final String kodWyjscia = "156";
	private int i = 299;
	private int minuty, sekundy;
	private String text = "";
	private Zagadka fib;
	private Zagadka2 znaki;
	private Zagadka3 liczby;

	public OknoGry() {
		//parametry okna gry i ekran startowy
		setBounds(100, 100, 1200, 800);
		setTitle("EscapeRoom");
		setLayout(null);

		//po klikni�ciu przycisku ukrywaj� si� elementy ekranu startowego i pokazuj� elementy w�a�ciwej gry, uruchamia si� timer
		bstart = new JButton("Rozpocznij gr�");
		bstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ltytu�.setVisible(false);
				bstart.setVisible(false);
				ltekst.setVisible(false);
				t�o.setVisible(true);
				w��cznik.setVisible(true);
				licznik.setVisible(true);
				licznik1.setVisible(true);
				komunikat.setVisible(true);
				odpowiedzi.setVisible(true);
				wpiszKod.setVisible(true);
				kod.setVisible(true);
				tm.start();
			}
		});
		bstart.setFont(new Font("SansSerif", Font.BOLD, 20));
		bstart.setBounds(500, 300, 200, 50);
		add(bstart);

		ltytu� = new JLabel("POK�J LICZB", JLabel.CENTER);
		ltytu�.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltytu�.setBounds(400, 70, 400, 200);
		ltytu�.setForeground(Color.RED);
		ltytu�.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(ltytu�);
		ltekst = new JTextArea("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "In�ynieria Oprogramowania - Programowanie \npod kierunkiem mgr.in�. Krzysztofa W�zowskiego");
		ltekst.setBounds(700, 500, 350, 100);
		ltekst.setFont(new Font("SansSerif", Font.BOLD, 15));
		ltekst.setLineWrap(true);
		add(ltekst);

		//t�o na pocz�tku jest czarne, co ma symulowa� ciemny pok�j, po zapaleniu �wiat�a przyciskiem w��cznik, 
		//t�o zmienia si� w obraz (image) klasy ImagePanel i pojawiaj� si� przyciski z zagadkami
		t�o = new JPanel();
		t�o.setBounds(50, 50, 1100, 500);
		t�o.setBackground(Color.black);
		t�o.setVisible(false);
		add(t�o);

		image = new ImagePanel0();
		image.setBounds(50, 50, 1100, 500);
		image.setVisible(false);
		add(image);

		w��cznik = new JButton();
		w��cznik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t�o.setVisible(false);
				w��cznik.setVisible(false);
				image.setVisible(true);
				zagadka1.setVisible(true);
				zagadka2.setVisible(true);
				zagadka3.setVisible(true);
			}
		});
		w��cznik.setToolTipText("W��cz �wiat�o"); //dymek pokazuj�cy si� po najechaniu na ukryty przyckisk w��cznika �wiat�a
		w��cznik.setBackground(Color.black);

		w��cznik.setForeground(Color.black);
		w��cznik.setBounds(1000, 200, 10, 5);
		w��cznik.setVisible(false);
		add(w��cznik);
		
		zagadka1 = new JButton("Zagadka1");
		zagadka1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //otwarcie okna dialogowego z zagadk� 
				if (fib==null)
				{fib = new Zagadka (null); //tworzenie nowego obiektu klasy zagadka, gdyby wcze�niej nie by� utworzony
				}
				
				fib.setVisible(true);
				fib.setFocus(); //funkcja ustawiaj�ca kursor w JTextField do wpisania odpowiedzi
				
				if (fib.isOK() )
				{
					odpowiedzi.setText(text + fib.getOdp()); //dodanie poprawnej odpowiedzi do notatnika JLabel
									}
			
				text = 	odpowiedzi.getText() + "   "; 	 //ustawienie nowej warto�ci pola text									
			}
		});
		zagadka1.setBounds(300,400, 100,30);
		zagadka1.setVisible(false);
		add(zagadka1);
		
		// kolejne zagadki dzia�aj� analogicznie jak pierwsza
		zagadka2 = new JButton("Zagadka2");
		zagadka2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (znaki==null)
				{znaki = new Zagadka2 (null);
				}
				
				znaki.setVisible(true);
				znaki.setFocus();
				
				if (znaki.isOK())
				{
					odpowiedzi.setText(text + znaki.getOdp());
					
				
			
				text = 	odpowiedzi.getText() + "   "; 	
			}
				
			}
		});
		zagadka2.setBounds(400,300, 100,30);
		zagadka2.setVisible(false);
		add(zagadka2);
		
		zagadka3 = new JButton("Zagadka3");
		zagadka3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (liczby==null)
				{liczby = new Zagadka3 (null);
				}
				
				liczby.setVisible(true);
				liczby.setFocus();
				
				if (liczby.isOK())
				{
					odpowiedzi.setText(text + liczby.getOdp());
				}
			
				text = 	odpowiedzi.getText() + "   "; 	
				
			}
		});
		zagadka3.setBounds(500,200, 100,30);
		zagadka3.setVisible(false);
		add(zagadka3);

		//JLabele pokazuj�ce timer, komentarze, notatnik z odpowiedziami 
		licznik = new JLabel("Pozosta�y czas:  ");
		licznik.setBounds(800, 600, 200, 50);
		licznik.setFont(new Font("SansSerif", Font.BOLD, 20));
		licznik.setVisible(false);
		add(licznik);

		licznik1 = new JLabel("5:00");
		licznik1.setBounds(960, 600, 200, 50);
		licznik1.setFont(new Font("SansSerif", Font.BOLD, 20));
		licznik1.setVisible(false);
		add(licznik1);
		
		komunikat = new JLabel("  ");
		komunikat.setBounds(800, 670, 300,50);
		komunikat.setForeground(Color.RED);
		komunikat.setFont(new Font("SansSerif", Font.BOLD, 17));
		komunikat.setVisible(false);
		add(komunikat);
		
		odpowiedzi = new JLabel(text);
		odpowiedzi.setBounds(50, 600, 300,50);
		odpowiedzi.setFont(new Font("SansSerif", Font.BOLD, 20));
		odpowiedzi.setVisible(false);
		add(odpowiedzi);
		
		wpiszKod = new JLabel("Wpisz kod:  ");
		wpiszKod.setBounds(50, 670, 300,50);
		wpiszKod.setFont(new Font("SansSerif", Font.BOLD, 20));
		wpiszKod.setVisible(false);
		add(wpiszKod);
			
		//ustawienie timera i warunki jego zatrzymania lub dzia�anie w momencie up�yni�cia czasu
		tm = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minuty = i / 60;
				sekundy = i % 60;

				if (i < 60) {
					if (i < 0) {
						tm.stop(); // zatrzymanie timera
						komunikat.setText("Czas min��, nie uda�o ci si� wyj��!");
						kod.setEditable(false); // po up�yni�ciu czasu, nie mo�na ju� wpisa� odpowiedzi
					}

					else if (sekundy < 10) // zaprogramowanie aby sekundy od 0 do 9 , pokazywa�y si�  z dodatkowym zerem z przodu tj. 01, 02 itp.
					{
						licznik1.setForeground(Color.RED);
						Toolkit.getDefaultToolkit().beep();
						licznik1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
					} else {
						licznik1.setForeground(Color.RED); // ostatnia minuta wy�wietla si� z kolorze czerwonym
						Toolkit.getDefaultToolkit().beep(); // dla zwi�kszenia napiecia ka�da sekunda w ostatniej minucie z dzwi�kiem
						licznik1.setText(Integer.toString(minuty) + ":" + Integer.toString(sekundy));
					}

				}

				else if (sekundy < 10) {
					licznik1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
				} else {
					licznik1.setText(Integer.toString(minuty) + ":" + Integer.toString(sekundy));
				}
				i--;

			}

		});
		//wpisanie kodu wyj�cia
		kod = new JTextField();
		kod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (kod.getText().equals(kodWyjscia) )
				{tm.stop();
				komunikat.setText("Kod poprawny, uda�o Ci si� wyj��");
				kod.setEditable(false);}
				
				else 
				{
					komunikat.setText("Kod b��dny, pr�buj dalej");
				}
			
			}
	       });
		kod.setBounds(180, 670, 150, 40);
		kod.setFont(new Font("SansSerif", Font.BOLD, 20));
		kod.setVisible(false);
		add(kod);
		
		
	}
}
//klasa do dodawania obraz�w do programu, 
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

	//@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);

	}
	
}

