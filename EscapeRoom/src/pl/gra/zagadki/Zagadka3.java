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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.*;

public class Zagadka3 extends JDialog {
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JLabel imageRiddle3, lAnswerRiddle3, lAnswerTrue, lAnswerWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private JSlider slider;
	private boolean okData;
	private static final String result = "6";
	
	public Zagadka3(JFrame owner) {
	   super(owner, "Liczby", true);
	   
	   setZagadka3Parametres ();
	   createImageParameters();
	   createLabelGiveAnswer();
	   createLabelAnswerTrue();
	   createLabelAnswerWrong();
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
		imageRiddle3 = new JLabel(new ImageIcon("images/liczby.jpg"));
		imageRiddle3.setBounds(50, 30, 1000, 500);
		add(imageRiddle3);
	}
	
	public void createLabelAnswerTrue() {
		lAnswerTrue = new JLabel("Odpowiedź poprawna!");
		lAnswerTrue.setBounds(50, 600, 180, 30);
		lAnswerTrue.setFont(new Font("SansSerif", Font.BOLD, 13));
		lAnswerTrue.setVisible(false);
		add(lAnswerTrue);
	}

	public void createLabelAnswerWrong() {
		lAnswerWrong = new JLabel("To nie to! Przemyśl i spróbuj ponownie!");
		lAnswerWrong.setBounds(470, 600, 350, 30);
		lAnswerWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		lAnswerWrong.setForeground(Color.RED);
		lAnswerWrong.setVisible(false);
		add(lAnswerWrong);
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
		lAnswerRiddle3 = new JLabel("Podaj odpowiedź:  ");
		lAnswerRiddle3.setBounds(50, 550, 180, 30);
		lAnswerRiddle3.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lAnswerRiddle3);
	}

	public void createTextFieldToEnterAnswer() {
		tAnswer = new JTextField();
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					slider.setEnabled(false);
					lAnswerTrue.setVisible(true);
					bAnswer.setVisible(false);
					lAnswerWrong.setVisible(false);
					setVisible(false);
				}else {
					lAnswerWrong.setVisible(true);
					slider.setValue(0);
					tAnswer.setText("");
				}
				   
			}
		});

		tAnswer.setBounds(470, 550, 100, 30);
		tAnswer.setFont(new Font("SansSerif", Font.BOLD, 20));
		tAnswer.setHorizontalAlignment(JTextField.CENTER);
		add(tAnswer);
	}

	public void createButtonPrompt() {
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(600, 550, 120, 22);
		add(bPrompt);
	}
       
	public void createTextAreaWithPrompt() {

		lPrompt = new JTextArea("Przeczytaj liczby, zwróć uwagę na tło \nskojarz liczby z alfabetem. "
				+ "\nLiczby podane są w porządku alfabetycznym,"
				+ "\nzwiększ dokładność do kolejnej litery,"
				+ "\nodpowiedź mieści się w podanym w suwaku zakresie!");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(730, 550, 320, 22);
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
					lAnswerTrue.setVisible(true);
					bAnswer.setVisible(false);
					lAnswerWrong.setVisible(false);
					setVisible(false);
				} else {
					lAnswerWrong.setVisible(true);
					slider.setValue(0);
					tAnswer.setText("");
				}
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

