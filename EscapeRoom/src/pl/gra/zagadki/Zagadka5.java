package pl.gra.zagadki;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Zagadka5 extends JDialog {
	
	private JButton bPrompt, bAnswer, bCancel;
	private JLabel imageRiddle5,lAnswerRiddle5, lAnswerTrue, lAnswerWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private JComboBox <Integer> cbNumber;
	private boolean okData ;
	private static final String result = "2";
	
	public Zagadka5(JFrame owner) {
		super(owner, "Kartka", true);

		setZagadka2Parametres();
		createImageParameters();
		createLabelGiveAnswer();
		createLabelAnswerTrue();
		createLabelAnswerWrong();
		createComboBoxToEnterAnswer();
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
		imageRiddle5 = new JLabel(new ImageIcon("images/kartka1.jpg"));
		imageRiddle5.setBounds(50, 30, 1000, 500);
		add(imageRiddle5);
	}
	   
	public void createLabelGiveAnswer() {
		lAnswerRiddle5 = new JLabel("Podaj odpowiedź:  ");
		lAnswerRiddle5.setBounds(50, 550, 180, 30);
		lAnswerRiddle5.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lAnswerRiddle5);
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
		lAnswerWrong.setBounds(400, 600, 350, 30);
		lAnswerWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		lAnswerWrong.setForeground(Color.RED);
		lAnswerWrong.setVisible(false);
		add(lAnswerWrong);

	}

	public void createComboBoxToEnterAnswer() {
		cbNumber = new JComboBox<>();

		for (int i = 0; i <= 10; i++) {
			cbNumber.addItem(i);
		}
		cbNumber.setBounds(250, 550, 100, 30);
		cbNumber.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(cbNumber);

	}
	
       
	public void createButtonPrompt() {
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(400, 550, 120, 22);
		add(bPrompt);
	}
	   
	public void createTextAreaWithPrompt() {
		lPrompt = new JTextArea("Jaką cyfrę musisz wpisać, aby dostać 6 z kartkówki?"
				+ "\nPrzyjrzyj się cyfrom po obu stronach znaku równości i znajdź logikę!"
				+ "\nPrzjrzyj się ocenie, tam znajdziesz podpowiedź!"
				+ "\nPodnieś cyfrę po lewej do trzeciej potęgi i dodaj ją do wyniku.");
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
					cbNumber.setEnabled(false);
					lAnswerTrue.setVisible(true);
					bAnswer.setVisible(false);
					lAnswerWrong.setVisible(false);
					setVisible(false);
				} else {
					lAnswerWrong.setVisible(true);
					cbNumber.setSelectedItem(0);
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
		int Number = cbNumber.getSelectedIndex();
		String IntToString=String.valueOf(Number);
		return IntToString;
	}

	public boolean isOK() {
		return okData;
	} 

}

