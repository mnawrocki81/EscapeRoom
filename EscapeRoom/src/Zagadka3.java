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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.*;

public class Zagadka3 extends JDialog {
	
	private JTextField tOdpowied�;
	private JButton bPodpowied�, bOdp, bCancel;
	private JPanel imageZagadka3;
	private JLabel odpZagadka3, odpPoprawna;
	private JTextArea lPodpowied�;
	private JScrollPane sPodpowied�;
	private JSlider suwak;
	private boolean okData;
	private static final String wynik = "6";
	
	public Zagadka3(JFrame owner) {
	   super(owner, "Zagadka3", true);
	   setBounds(150, 150, 1120, 700);
	   setLayout(null);
	   setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	   imageZagadka3 = new ImagePanel3();
	   imageZagadka3.setBounds(50, 30, 1000, 500);
	   add(imageZagadka3);
	   
	   odpPoprawna = new JLabel("Odpowied� poprawna!");
	   odpPoprawna.setBounds(50, 600, 180, 30);
	   odpPoprawna.setFont(new Font("SansSerif", Font.PLAIN ,14));
	   odpPoprawna.setVisible(false);
	   add(odpPoprawna);
	   
	   //suwak u�atwiaj�cy podanie odpowiedzi, kt�ra jest liczb� od 0 do 10
	   suwak  = new JSlider(0,10,0);
	   suwak.setBounds(250, 550, 200, 50);
	   suwak.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

		   tOdpowied�.setText("" + suwak.getValue());
		   setFocus();
			}
	   });
	   //ustawienie suwaka , podzia�ki , etykiet,  dosuwania do najbli�szej kreski, 
	   suwak.setPaintTicks(true);
	   suwak.setPaintLabels(true);
	   suwak.setSnapToTicks(true); 
	   suwak.setMajorTickSpacing(1);
	   add(suwak);
	    
	   
	   odpZagadka3 = new JLabel("Podaj odpowied�:  ");
	   odpZagadka3.setBounds(50, 550, 180, 30);
	   odpZagadka3.setFont(new Font("SansSerif", Font.BOLD, 20));
	   add(odpZagadka3);
       
	   tOdpowied� = new JTextField();
	   tOdpowied�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(wynik)) {
					okData = true;
					tOdpowied�.setEditable(false);
					suwak.setEnabled(false);
					odpPoprawna.setVisible(true);
					bOdp.setVisible(false);
					setVisible(false);
				}

			}

		});

	   tOdpowied�.setBounds(470, 550, 100, 30);
	   tOdpowied�.setFont(new Font("SansSerif", Font.BOLD, 20));
	   tOdpowied�.setLayout(new FlowLayout(FlowLayout.CENTER));
       add(tOdpowied�);
       
       bPodpowied� = new JButton("Podpowied�");
       bPodpowied�.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
      
   		 lPodpowied�.setVisible(true);
   		}
          });
       bPodpowied�.setBounds(600, 550, 120, 25);
       add(bPodpowied�);
       
       lPodpowied� = new JTextArea("Przeczytaj liczby, zwr�� uwag� na t�o \nskojarz liczby z alfabetem. ");
       lPodpowied�.setVisible(false);
       sPodpowied� = new JScrollPane(lPodpowied�);
       sPodpowied�.setBounds(730, 550, 300, 22);
	   add(sPodpowied�);
	   
	   bOdp = new JButton("Potwierd�");
	   bOdp.setVisible(true);
	   bOdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(wynik)) {
					okData = true;
					tOdpowied�.setEditable(false);
					suwak.setEnabled(false);
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


class ImagePanel3 extends JPanel {

	private BufferedImage imageZagadka3;

	public ImagePanel3() {
		super();

		
		File imageFile3 = new File("images/liczby.jpg");
		try {
			imageZagadka3 = ImageIO.read(imageFile3);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}

	//@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D zagadka3 = (Graphics2D) g;
		zagadka3.drawImage(imageZagadka3, 0, 0, this);
		
	}
}