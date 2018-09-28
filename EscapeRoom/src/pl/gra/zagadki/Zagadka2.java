package pl.gra.zagadki;
import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

//zasada działania analogiczna jak w klasie Zagadka

public class Zagadka2 extends JDialog {
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JPanel imageZagadka2;
	private JLabel odpZagadka2, odpTrue, odpWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private boolean okData ;
	private static final String result = "1";
	
	public Zagadka2(JFrame owner) {
		super(owner, "Zagadka2", true);

		setZagadka2Parametres();
		createImageParameters();
		createLabelGiveAnswer();
		createLabelAnswerTrue();
		createLabelAwswerWrong();
		createTextFieldToEnterAnswer();
		createButtonPrompt();
		createTextAreaWithPrompt();
		createButtonConfirmingTheAnswer();
		createButtonToCancel();
	}
	   
	public void setZagadka2Parametres() {
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	   
	public void createImageParameters() {
		imageZagadka2 = new ImagePanel2();
		imageZagadka2.setBounds(50, 30, 1000, 500);
		add(imageZagadka2);
	}
	   
	public void createLabelGiveAnswer() {
		odpZagadka2 = new JLabel("Podaj odpowiedź:  ");
		odpZagadka2.setBounds(50, 550, 180, 30);
		odpZagadka2.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(odpZagadka2);
	}
	   
	public void createLabelAnswerTrue() {
		odpTrue = new JLabel("Odpowiedź poprawna!");
		odpTrue.setBounds(50, 600, 180, 30);
		odpTrue.setFont(new Font("SansSerif", Font.BOLD, 13));
		odpTrue.setVisible(false);
		add(odpTrue);
	}
	
	public void createLabelAwswerWrong()
	{
		odpWrong = new JLabel("To nie to! Przemyśl i spróbuj ponownie!");
		odpWrong.setBounds(400, 600, 350, 30);
		odpWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		odpWrong.setForeground(Color.RED);
		odpWrong.setVisible(false);
		add(odpWrong);
		
	}
	   
	public void createTextFieldToEnterAnswer() {
		tAnswer = new JTextField();
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					odpTrue.setVisible(true);
					odpWrong.setVisible(false);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});

		tAnswer.setBounds(250, 550, 100, 30);
		tAnswer.setFont(new Font("SansSerif", Font.BOLD, 20));
		tAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(tAnswer);
	}
       
	public void createButtonPrompt() {
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(400, 550, 120, 25);
		add(bPrompt);
	}
	   
	public void createTextAreaWithPrompt() {
		lPrompt = new JTextArea("Przyjrzyj sie umiejscowieniu znaków na klawiaturze komputera");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(530, 550, 500, 22);
		add(sPrompt);
	}
	   
	public void createButtonConfirmingTheAnswer() {
		bAnswer = new JButton("Potwierdź");
		bAnswer.setVisible(true);
		bAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					odpTrue.setVisible(true);
					odpWrong.setVisible(false);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});
		bAnswer.setBounds(50, 600, 120, 25);
		add(bAnswer);
	}
	   
	public void createButtonToCancel() {
		bCancel = new JButton("Wróć");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				okData = false;
				setVisible(false);
			}
		});
		bCancel.setBounds(200, 600, 120, 25);
		add(bCancel);
	}
	

	public String getOdp() {
		return tAnswer.getText();
	}

	public void setFocus() {
		tAnswer.requestFocusInWindow();
	}

	public boolean isOK() {
		return okData;
	}

}

class ImagePanel2 extends JPanel {

	private BufferedImage imageZagadka2;

	public ImagePanel2() {
		super();

		
		File imageFile2 = new File("images/komputer.jpg");
		try {
			imageZagadka2 = ImageIO.read(imageFile2);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}

	//@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D zagadka2 = (Graphics2D) g;
		zagadka2.drawImage(imageZagadka2, 0, 0, this);
		
	}
}
