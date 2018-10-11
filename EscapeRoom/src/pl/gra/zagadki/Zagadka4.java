package pl.gra.zagadki;

import java.awt.Color;
import java.awt.FlowLayout;
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

public class Zagadka4 extends JDialog {
	
	private JTextField tAnswer, tHour, tMinutes;
	private JButton bPrompt, bAnswer, bCancel;
	private JLabel imageZagadka4, odpZagadka4, odpTrue, odpWrong, lHour, lMinutes, lColon;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private boolean okData;
	private static final String result = "8";
	
	public Zagadka4(JFrame owner) {
		   super(owner, "Zagadka4", true);
		   
		   setZagadka4Parametres ();
		   createImageParameters();
		   createLabelHour();
		   createLabelMinutes();
		   createLabelColonBetweenHourAndMinutes();
		   createTextFieldGiveHour();
		   createTextFieldGiveMinutes();
		   createLabelGiveAnswer();
		   createLabelAnswerTrue();
		   createLabelAwswerWrong();
		   createTextFieldToEnterAnswer();
		   createButtonPrompt();
		   createTextAreaWithPrompt();
		   createButtonConfirmingTheAnswer ();
		   createButtonToCancel();

}
	
	public void setZagadka4Parametres() {
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public void createImageParameters() {
		imageZagadka4 = new JLabel(new ImageIcon("images/zegar.jpg"));
		imageZagadka4.setBounds(50, 30, 1000, 500);
		add(imageZagadka4);
	}
	
	public void createLabelHour() {
		lHour = new JLabel("Godz. ");
		lHour.setBounds(50, 560, 180, 30);
		lHour.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(lHour);
	}

	public void createLabelMinutes() {

		lMinutes = new JLabel("Minuty");
		lMinutes.setBounds(168, 540, 180, 30);
		lMinutes.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(lMinutes);
	}
	
	public void createLabelColonBetweenHourAndMinutes()
	{
		lColon = new JLabel(" : ");
		lColon.setBounds(154, 550, 180, 30);
		lColon.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(lColon);	
	}
	
	public void createTextFieldGiveHour()
	{
		tHour = new JTextField();
		tHour.setBounds(100, 560, 50, 30);
		tHour.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(tHour);
	}
	
	public void createTextFieldGiveMinutes()
	{
		tMinutes = new JTextField();
		tMinutes.setBounds(224, 540, 50, 30);
		tMinutes.setFont(new Font("SansSerif", Font.BOLD, 15));
		add(tMinutes);		
	}
	
	public void createLabelGiveAnswer() {
		odpZagadka4 = new JLabel("Podaj odpowiedź:  ");
		odpZagadka4.setBounds(300, 550, 180, 30);
		odpZagadka4.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(odpZagadka4);
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
	
	public void createTextFieldToEnterAnswer() {
		tAnswer = new JTextField();
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					tHour.setEditable(false);
					tMinutes.setEditable(false);
					odpTrue.setVisible(true);
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
		bPrompt.setBounds(600, 550, 120, 22);
		add(bPrompt);
	}
       
	public void createTextAreaWithPrompt() {

		lPrompt = new JTextArea("Przyjrzyj się dobrze na co wskazuje wskazówka, "
				+ "\nczy wskazuje poprawną liczbą?"
				+ "\nwpisz we właściwe miejsca godzine i minuty "
				+ "\njakie równanie Ci to przypomina? "				
				+ "\nPodziel godz./min., a otrzymasz wynik zagadki. ");
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
					tHour.setEditable(false);
					tMinutes.setEditable(false);
					odpTrue.setVisible(true);
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

