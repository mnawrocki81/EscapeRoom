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

	private JPanel t³o, image;
	private JButton bstart, w³¹cznik, zagadka1, zagadka2, zagadka3;
	private JLabel ltytu³, licznik, licznik1,komunikat,odpowiedzi,wpiszKod;
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

		//po klikniêciu przycisku ukrywaj¹ siê elementy ekranu startowego i pokazuj¹ elementy w³aœciwej gry, uruchamia siê timer
		bstart = new JButton("Rozpocznij grê");
		bstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ltytu³.setVisible(false);
				bstart.setVisible(false);
				ltekst.setVisible(false);
				t³o.setVisible(true);
				w³¹cznik.setVisible(true);
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

		ltytu³ = new JLabel("POKÓJ LICZB", JLabel.CENTER);
		ltytu³.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltytu³.setBounds(400, 70, 400, 200);
		ltytu³.setForeground(Color.RED);
		ltytu³.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(ltytu³);
		ltekst = new JTextArea("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "In¿ynieria Oprogramowania - Programowanie \npod kierunkiem mgr.in¿. Krzysztofa Wêzowskiego");
		ltekst.setBounds(700, 500, 350, 100);
		ltekst.setFont(new Font("SansSerif", Font.BOLD, 15));
		ltekst.setLineWrap(true);
		add(ltekst);

		//t³o na pocz¹tku jest czarne, co ma symulowaæ ciemny pokój, po zapaleniu œwiat³a przyciskiem w³¹cznik, 
		//t³o zmienia siê w obraz (image) klasy ImagePanel i pojawiaj¹ siê przyciski z zagadkami
		t³o = new JPanel();
		t³o.setBounds(50, 50, 1100, 500);
		t³o.setBackground(Color.black);
		t³o.setVisible(false);
		add(t³o);

		image = new ImagePanel0();
		image.setBounds(50, 50, 1100, 500);
		image.setVisible(false);
		add(image);

		w³¹cznik = new JButton();
		w³¹cznik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t³o.setVisible(false);
				w³¹cznik.setVisible(false);
				image.setVisible(true);
				zagadka1.setVisible(true);
				zagadka2.setVisible(true);
				zagadka3.setVisible(true);
			}
		});
		w³¹cznik.setToolTipText("W³¹cz œwiat³o"); //dymek pokazuj¹cy siê po najechaniu na ukryty przyckisk w³¹cznika œwiat³a
		w³¹cznik.setBackground(Color.black);

		w³¹cznik.setForeground(Color.black);
		w³¹cznik.setBounds(1000, 200, 10, 5);
		w³¹cznik.setVisible(false);
		add(w³¹cznik);
		
		zagadka1 = new JButton("Zagadka1");
		zagadka1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //otwarcie okna dialogowego z zagadk¹ 
				if (fib==null)
				{fib = new Zagadka (null); //tworzenie nowego obiektu klasy zagadka, gdyby wczeœniej nie by³ utworzony
				}
				
				fib.setVisible(true);
				fib.setFocus(); //funkcja ustawiaj¹ca kursor w JTextField do wpisania odpowiedzi
				
				if (fib.isOK() )
				{
					odpowiedzi.setText(text + fib.getOdp()); //dodanie poprawnej odpowiedzi do notatnika JLabel
									}
			
				text = 	odpowiedzi.getText() + "   "; 	 //ustawienie nowej wartoœci pola text									
			}
		});
		zagadka1.setBounds(300,400, 100,30);
		zagadka1.setVisible(false);
		add(zagadka1);
		
		// kolejne zagadki dzia³aj¹ analogicznie jak pierwsza
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

		//JLabele pokazuj¹ce timer, komentarze, notatnik z odpowiedziami 
		licznik = new JLabel("Pozosta³y czas:  ");
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
			
		//ustawienie timera i warunki jego zatrzymania lub dzia³anie w momencie up³yniêcia czasu
		tm = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				minuty = i / 60;
				sekundy = i % 60;

				if (i < 60) {
					if (i < 0) {
						tm.stop(); // zatrzymanie timera
						komunikat.setText("Czas min¹³, nie uda³o ci siê wyjœæ!");
						kod.setEditable(false); // po up³yniêciu czasu, nie mo¿na ju¿ wpisaæ odpowiedzi
					}

					else if (sekundy < 10) // zaprogramowanie aby sekundy od 0 do 9 , pokazywa³y siê  z dodatkowym zerem z przodu tj. 01, 02 itp.
					{
						licznik1.setForeground(Color.RED);
						Toolkit.getDefaultToolkit().beep();
						licznik1.setText(Integer.toString(minuty) + ":0" + Integer.toString(sekundy));
					} else {
						licznik1.setForeground(Color.RED); // ostatnia minuta wyœwietla siê z kolorze czerwonym
						Toolkit.getDefaultToolkit().beep(); // dla zwiêkszenia napiecia ka¿da sekunda w ostatniej minucie z dzwiêkiem
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
		//wpisanie kodu wyjœcia
		kod = new JTextField();
		kod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (kod.getText().equals(kodWyjscia) )
				{tm.stop();
				komunikat.setText("Kod poprawny, uda³o Ci siê wyjœæ");
				kod.setEditable(false);}
				
				else 
				{
					komunikat.setText("Kod b³êdny, próbuj dalej");
				}
			
			}
	       });
		kod.setBounds(180, 670, 150, 40);
		kod.setFont(new Font("SansSerif", Font.BOLD, 20));
		kod.setVisible(false);
		add(kod);
		
		
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

	//@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);

	}
	
}

