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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.*;

public class Zagadka3 extends JDialog {
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JPanel imageZagadka3;
	private JLabel odpZagadka3, odpTrue, odpWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private JSlider slider;
	private boolean okData;
	private static final String result = "6";
	
	public Zagadka3(JFrame owner) {
	   super(owner, "Zagadka3", true);
	   
	   setZagadka3Parametres ();
	   createImageParameters();
	   createLabelGiveAnswer();
	   createLabelAnswerTrue();
	   createLabelAwswerWrong();
	   createSliderToEnterAnswer();
	   createTextFieldToEnterAnswer();
	   createButtonPrompt();
	   createTextAreaWithPrompt();
	   createButtonConfirmingTheAnswer ();
	   createButtonToCancel();
	}
	
	public void setZagadka3Parametres() {
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}

	public void createImageParameters() {
		imageZagadka3 = new ImagePanel3();
		imageZagadka3.setBounds(50, 30, 1000, 500);
		add(imageZagadka3);
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
		odpWrong.setBounds(470, 600, 350, 30);
		odpWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		odpWrong.setForeground(Color.RED);
		odpWrong.setVisible(false);
		add(odpWrong);
	}
	   
	public void createSliderToEnterAnswer() {
		slider = new JSlider(0, 10, 0);
		slider.setBounds(250, 550, 200, 50);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				tAnswer.setText("" + slider.getValue());
				setFocus();
			}
		});
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(1);
		add(slider);
	}

	public void createLabelGiveAnswer() {
		odpZagadka3 = new JLabel("Podaj odpowiedź:  ");
		odpZagadka3.setBounds(50, 550, 180, 30);
		odpZagadka3.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(odpZagadka3);
	}

	public void createTextFieldToEnterAnswer() {
		tAnswer = new JTextField();
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					slider.setEnabled(false);
					odpTrue.setVisible(true);
					odpWrong.setVisible(false);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});

		tAnswer.setBounds(470, 550, 100, 30);
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
		bPrompt.setBounds(600, 550, 120, 25);
		add(bPrompt);
	}
       
	public void createTextAreaWithPrompt() {

		lPrompt = new JTextArea("Przeczytaj liczby, zwróć uwagę na tło \nskojarz liczby z alfabetem. ");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(730, 550, 300, 22);
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
					slider.setEnabled(false);
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

	// @Override
	public void paintComponent(Graphics g) {

		Graphics2D zagadka3 = (Graphics2D) g;
		zagadka3.drawImage(imageZagadka3, 0, 0, this);

	}
}