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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//zaprogramowanie okna z zagadk�, dziedzicz�cego po klasie JDialog
public class Zagadka extends JDialog {
	
	private JTextField tOdpowied�;
	private JButton bPodpowied�, bOdp, bCancel;
	private JPanel imageZagadka1;
	private JLabel odpZagadka1, odpPoprawna;
	private JTextArea lPodpowied�;
	private JScrollPane sPodpowied�;
	private boolean okData = false;
	private static final String wynik = "5";
	
	
	
	public Zagadka(OknoGry pocz�tek) {
	   super(pocz�tek, "Zagadka1", true);
	   setBounds(150, 150, 1120, 700);
	   setLayout(null);
	   setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); //zamkn�� oknno mo�na tylko przyciskiem "Wr��" lub podaj�c raz dobr� odpowiedz

	   imageZagadka1 = new ImagePanel1();
	   imageZagadka1.setBounds(50, 30, 1000, 500);
	   add(imageZagadka1);
	   
	   odpZagadka1 = new JLabel("Podaj odpowied�:  ");
	   odpZagadka1.setBounds(50, 550, 180, 30);
	   odpZagadka1.setFont(new Font("SansSerif", Font.BOLD, 20));
	   add(odpZagadka1);
	   
	   odpPoprawna = new JLabel("Odpowied� poprawna!");
	   odpPoprawna.setBounds(50, 600, 180, 30);
	   odpPoprawna.setFont(new Font("SansSerif", Font.PLAIN ,14));
	   odpPoprawna.setVisible(false);
	   add(odpPoprawna);
       
	   //obiekt  pola tekstowego do wpisania odpowiedzi, dzia�a po wci�ni�cie entera lub potwierdzeniu przyciskiem
	   tOdpowied� = new JTextField();
	   tOdpowied�.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (getOdp().equals(wynik)  )
			{
				    okData = true;
				    tOdpowied�.setEditable(false);
				    odpPoprawna.setVisible(true);
					bOdp.setVisible(false);
					setVisible(false);
			   
				  				   				    
				}	
																	
				}
       });
     
	   tOdpowied�.setBounds(250, 550, 100, 30);
	   tOdpowied�.setFont(new Font("SansSerif", Font.BOLD, 20));
	   tOdpowied�.setLayout(new FlowLayout(FlowLayout.CENTER));
       add(tOdpowied�);
       
       //mo�na skorzysta� z podpowiedzi, w przypadku problem�w z rozwi�zaniem zadania
       bPodpowied� = new JButton("Podpowied�");
       bPodpowied�.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
      
   		 lPodpowied�.setVisible(true);
   		}
          });
       bPodpowied�.setBounds(400, 550, 120, 25);
       add(bPodpowied�);
       
       lPodpowied� = new JTextArea("Skorupa �limaka, to przyk�ad boskiej proporcji w przyrodzie (lub z�otego podzia�u), "
          		+ "\nzwr�� uwag� na ci�g liczbowy i skojarz go z popularnym ci�giem okre�lonym przez "
           		+ "\nw�oskiego matematyka z Pizy w 1202 r.,"
           		+ "\nkt�ry nazywa� si� Fibonacci, a w jego ci�gu pierwsza + druga cyfra daje trzeci�"
           		+ "\ndruga + trzecia daje czwart� i tak dalej."); // podpowiedzi wy�wietlaj� si� po jednej linijce, stopniowo coraz bardziej szczeg�owo, mozna przewija� scrollem
       lPodpowied�.setVisible(false); //podpowied� widocznna po klikni�ciu przycisku na �yczenie gracza
       sPodpowied� = new JScrollPane(lPodpowied�);
       sPodpowied�.setBounds(530, 550, 500, 22);
	   add(sPodpowied�);
	   
	   //przyciski potwierdzaj�ce odpowiedz lub zamykaj�ce okno i powr�t do g��wnego ekranu, 
	   //przycisk Potwierd� mo�e by� u�yty tylko raz, p�zniej zostaje ukryty i pojawia si� komunikat o poprawnej odpowiedzi
	   bOdp = new JButton("Potwierd�");
	   bOdp.setVisible(true);
		bOdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(wynik)) {
					okData = true;
					tOdpowied�.setEditable(false);
					odpPoprawna.setVisible(true);
					bOdp.setVisible(false);
					setVisible(false);

				}

			}
		});
	   bOdp.setBounds(50, 600, 120, 25);
	   add(bOdp);
	   
	   bCancel = new JButton("Wr��");
	   bCancel.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	      
	   			okData = false;
	   			setVisible(false);
	   		}
	          });
	   bCancel.setBounds(200, 600, 120, 25);
	   add(bCancel);

	}
	
	
	//Funkcje do wsp�pracy g��wnego okna gry i okna dialogowego
	public String getOdp()
    {
     return tOdpowied�.getText();
    }
    
    public void setFocus()
    {
    	tOdpowied�.requestFocusInWindow();
 	   
    }
    
    public boolean isOK()
    {
    	  	return okData;
    }
       
    
}

//klasa do dodawania obraz�w do programu, jak w oknie g��wnym
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

	//@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D zagadka1 = (Graphics2D) g;
		zagadka1.drawImage(imageZagadka1, 0, 0, this);
		
	}
}


