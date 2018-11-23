package pl.gra.zagadki;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Box extends JDialog {
	
	private JLabel imageBox1, imageBox2;
	private JButton bPrompt, bOpen, bTake, bCancel;
	private Envelope envelope;
	private JTextField openingCode;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private static final String result = "238";

	public Box(JFrame owner) {
		super(owner, "Skrzynka", true);
		
		   
		   setLetterParametres ();
		   createImage1Parameters();
		   createImage2Parameters();
		   createTextFieldCodeToOpenBox();
		   createButtonOpenBox();
		   createButtonTakeEnvelope();
		   createButtonToCancel();
		   createButtonPrompt();
		   createTextAreaWithPrompt();
}
	
	public void setLetterParametres() {
		setBounds(150, 150, 1120, 700);
		setLayout(null);
	}
	
	public void createImage1Parameters() {
		imageBox1 = new JLabel(new ImageIcon("images/skrzynka1.jpg"));
		imageBox1.setBounds(50, 30, 1000, 500);
		add(imageBox1);
	}
	
	public void createImage2Parameters() {
		imageBox2 = new JLabel(new ImageIcon("images/skrzynka2.jpg"));
		imageBox2.setBounds(50, 30, 1000, 500);
		imageBox2.setVisible(false);
		add(imageBox2);

	}
	
	public void createTextFieldCodeToOpenBox() {
		openingCode = new JTextField();
		openingCode.setBounds(520, 375, 50, 30);
		openingCode.setFont(new Font("SansSerif", Font.BOLD, 20));
		openingCode.setHorizontalAlignment(JTextField.CENTER);
		add(openingCode);
	}
	
	public void createButtonOpenBox() {
		bOpen = new JButton("Otwórz skrzynkę");
		bOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (openingCode.getText().equals(result)) {
					imageBox1.setVisible(false);
					imageBox2.setVisible(true);
					bOpen.setVisible(false);
					openingCode.setVisible(false);
					bTake.setVisible(true);
				}
				else {
				     openingCode.setText("");
				     setFocus();
				}
			}
		});
		bOpen.setBounds(470, 410, 150, 30);
		bOpen.setBackground(new Color(165, 42, 42));
		bOpen.setForeground(Color.white);
		add(bOpen);
	}
	
	public void createButtonTakeEnvelope() {
		bTake = new JButton("Weź kopertę");
		bTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (envelope == null) {
					envelope = new Envelope(null);
				}

				envelope.setVisible(true);
			}
		});
		bTake.setBounds(470, 270, 150, 30);
		bTake.setVisible(false);
		add(bTake);

	}
	
	public void createButtonToCancel() {
		bCancel = new JButton("Wróć do gry");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		bCancel.setBounds(200, 600, 120, 25);
		add(bCancel);
	}
	
	public void createButtonPrompt() {
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(550, 600, 120, 22);
		add(bPrompt);
	}
       
	public void createTextAreaWithPrompt() {

		lPrompt = new JTextArea("Otwórz skrzynkę wpisując kod \nwskazówka znajduje się na skrzynce,"
				+ "\nsą to cyfry, które będą pasować do podanego układu równań."
				+ "\nDo odpowiedzi potrzebujesz wyniku kilku zagadek,"
				+ "\njeśli żadne cyfry po podsatawieniu nie pasują, "
				+ "\nrozwiąż pozostałe zagadki i wróć w to miejsce. ");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(680, 600, 370, 22);
		add(sPrompt);
	}
	
	public void setFocus() {
		openingCode.requestFocusInWindow();
	}

}
