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

//zaprogramowanie okna z zagadkπ, dziedziczπcego po klasie JDialog
public class Zagadka extends JDialog {
	
	private JTextField tOdpowiedü;
	private JButton bPodpowiedü, bOdp, bCancel;
	private JPanel imageZagadka1;
	private JLabel odpZagadka1, odpPoprawna;
	private JTextArea lPodpowiedü;
	private JScrollPane sPodpowiedü;
	private boolean okData = false;
	private static final String wynik = "5";
	
	
	
	public Zagadka(OknoGry poczπtek) {
	   super(poczπtek, "Zagadka1", true);
	   setBounds(150, 150, 1120, 700);
	   setLayout(null);
	   setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); //zamknπÊ oknno moøna tylko przyciskiem "WrÛÊ" lub podajπc raz dobrπ odpowiedz

	   imageZagadka1 = new ImagePanel1();
	   imageZagadka1.setBounds(50, 30, 1000, 500);
	   add(imageZagadka1);
	   
	   odpZagadka1 = new JLabel("Podaj odpowiedü:  ");
	   odpZagadka1.setBounds(50, 550, 180, 30);
	   odpZagadka1.setFont(new Font("SansSerif", Font.BOLD, 20));
	   add(odpZagadka1);
	   
	   odpPoprawna = new JLabel("Odpowiedü poprawna!");
	   odpPoprawna.setBounds(50, 600, 180, 30);
	   odpPoprawna.setFont(new Font("SansSerif", Font.PLAIN ,14));
	   odpPoprawna.setVisible(false);
	   add(odpPoprawna);
       
	   //obiekt  pola tekstowego do wpisania odpowiedzi, dzia≥a po wciúniÍcie entera lub potwierdzeniu przyciskiem
	   tOdpowiedü = new JTextField();
	   tOdpowiedü.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (getOdp().equals(wynik)  )
			{
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
       
       //moøna skorzystaÊ z podpowiedzi, w przypadku problemÛw z rozwiπzaniem zadania
       bPodpowiedü = new JButton("Podpowiedü");
       bPodpowiedü.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
      
   		 lPodpowiedü.setVisible(true);
   		}
          });
       bPodpowiedü.setBounds(400, 550, 120, 25);
       add(bPodpowiedü);
       
       lPodpowiedü = new JTextArea("Skorupa úlimaka, to przyk≥ad boskiej proporcji w przyrodzie (lub z≥otego podzia≥u), "
          		+ "\nzwrÛÊ uwagÍ na ciπg liczbowy i skojarz go z popularnym ciπgiem okreúlonym przez "
           		+ "\nw≥oskiego matematyka z Pizy w 1202 r.,"
           		+ "\nktÛry nazywa≥ siÍ Fibonacci, a w jego ciπgu pierwsza + druga cyfra daje trzeciπ"
           		+ "\ndruga + trzecia daje czwartπ i tak dalej."); // podpowiedzi wyúwietlajπ siÍ po jednej linijce, stopniowo coraz bardziej szczegÛ≥owo, mozna przewijaÊ scrollem
       lPodpowiedü.setVisible(false); //podpowiedü widocznna po klikniÍciu przycisku na øyczenie gracza
       sPodpowiedü = new JScrollPane(lPodpowiedü);
       sPodpowiedü.setBounds(530, 550, 500, 22);
	   add(sPodpowiedü);
	   
	   //przyciski potwierdzajπce odpowiedz lub zamykajπce okno i powrÛt do g≥Ûwnego ekranu, 
	   //przycisk Potwierdü moøe byÊ uøyty tylko raz, pÛzniej zostaje ukryty i pojawia siÍ komunikat o poprawnej odpowiedzi
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
	
	
	//Funkcje do wspÛ≥pracy g≥Ûwnego okna gry i okna dialogowego
	public String getOdp()
    {
     return tOdpowiedü.getText();
    }
    
    public void setFocus()
    {
    	tOdpowiedü.requestFocusInWindow();
 	   
    }
    
    public boolean isOK()
    {
    	  	return okData;
    }
       
    
}

//klasa do dodawania obrazÛw do programu, jak w oknie g≥Ûwnym
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


