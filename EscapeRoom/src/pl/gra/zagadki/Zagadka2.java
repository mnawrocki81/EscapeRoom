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


public class Zagadka2 extends JDialog implements ActionListener {
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JLabel imageRiddle2,lAnswerRiddle2, lAnswerTrue, lAnswerWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private boolean okData;
	private static final String result = "3";
	
	public Zagadka2(JFrame owner) {
		super(owner, "Komputer", true);

		setZagadka2Parametres();
		createImageParameters();
		createLabelGiveAnswer();
		createLabelAnswerTrue();
		createLabelAnswerWrong();
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
		imageRiddle2 =  new JLabel(new ImageIcon("images/komputer.jpg"));
		imageRiddle2.setBounds(50, 30, 1000, 500);
		add(imageRiddle2);
	}
	   
	public void createLabelGiveAnswer() {
		lAnswerRiddle2 = new JLabel("Podaj odpowiedź:  ");
		lAnswerRiddle2.setBounds(50, 550, 180, 30);
		lAnswerRiddle2.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lAnswerRiddle2);
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
	   
	public void createTextFieldToEnterAnswer() {
		tAnswer = new JTextField();
		tAnswer.addActionListener(this);
		tAnswer.setBounds(250, 550, 100, 30);
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
		bPrompt.setBounds(400, 550, 120, 22);
		add(bPrompt);
	}
	   
	public void createTextAreaWithPrompt() {
		lPrompt = new JTextArea("Przyjrzyj sie umiejscowieniu znaków na klawiaturze komputera"
				+ "\nco jest pod nimi?"
				+ "\nWykonaj odpowiednie działania arytmetyczne.");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(530, 550, 500, 22);
		add(sPrompt);
	}
	   
	public void createButtonConfirmingTheAnswer() {
		bAnswer = new JButton("Potwierdź");
		bAnswer.addActionListener(this);
		bAnswer.setBounds(50, 600, 120, 25);
		add(bAnswer);
	}
	   
	public void createButtonToCancel() {
		bCancel = new JButton("Wróć");
		bCancel.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z == bAnswer || z == tAnswer) {
			if (getOdp().equals(result)) {
				okData = true;
				tAnswer.setEditable(false);
				lAnswerTrue.setVisible(true);
				bAnswer.setVisible(false);
				lAnswerWrong.setVisible(false);
				setVisible(false);
			} else {
				lAnswerWrong.setVisible(true);
				tAnswer.setText("");
				tAnswer.requestFocusInWindow();
			}
			    
		}

		else if (z == bCancel) {
			okData = false;
			setVisible(false);
		}

	
	}
}

