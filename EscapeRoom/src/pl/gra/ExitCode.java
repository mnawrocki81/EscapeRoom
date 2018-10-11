package pl.gra;

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


public class ExitCode extends JDialog {
	
	private JButton bPrompt, bAnswer, bCancel;
	private JTextField tExitCode;
	private JLabel imageExitCode;
	private JScrollPane sPrompt;
	private JTextArea lPrompt;
	private boolean okData ;
	private JLabel  odpTrue, odpWrong;
	private static final String result = "TEST";
	
	
	public ExitCode(JFrame owner) {
		super(owner, "ExitCode", true);
		
		setExitCodeParametres();
		createImageParameters();
		createTextFieldExitCode();
		createButtonPrompt();
		createTextAreaWithPrompt();
		createButtonConfirmingTheAnswer();
		createButtonToCancel();
		createLabelAnswerWrong();
		createLabelAnswerTrue();

}

	public void setExitCodeParametres()
	{
		setBounds(350, 50, 700, 900);
		setLayout(null);
		//setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	
	public void createImageParameters()
	{
		imageExitCode = new JLabel(new ImageIcon("images/klawiatura3.jpg"));
		imageExitCode.setBounds(44,20, 612, 750);
		add(imageExitCode);
		
	}
	
	public void createTextFieldExitCode()
	{
		tExitCode = new JTextField();
		tExitCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					odpTrue.setVisible(true);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});

		tExitCode.setBounds(100, 40, 500, 100);
		tExitCode.setFont(new Font("SansSerif", Font.BOLD, 40));
		tExitCode.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(tExitCode);
	}
	
	
	public void createButtonPrompt()
	{
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(44, 780, 120, 22);
		add(bPrompt);
		
	}
	
	public void createTextAreaWithPrompt()
	{
		lPrompt = new JTextArea("Przyjrzyj sie znakom na przyciskach"
				+ "\nUłuż słowo z cyfr, które są odpowiedziami do zagadek."
				+ "\nWskazówke znajdziesz w kopercie ze skrzynki!");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(165, 780, 491, 22);
		add(sPrompt);
		
	}
	
	public void createButtonConfirmingTheAnswer() {
		bAnswer = new JButton("Potwierdź");
		bAnswer.setVisible(true);
		bAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					odpTrue.setVisible(true);
					bAnswer.setVisible(false);
					setVisible(false);
				} else
					odpWrong.setVisible(true);
			}
		});
		bAnswer.setBounds(44, 810, 120, 25);
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
		bCancel.setBounds(200, 810, 120, 25);
		add(bCancel);
	}
	
	public void createLabelAnswerWrong()
	{
		odpWrong = new JLabel("To nie to! Przemyśl i spróbuj ponownie!");
		odpWrong.setBounds(350, 810, 350, 30);
		odpWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		odpWrong.setForeground(Color.RED);
		odpWrong.setVisible(false);
		add(odpWrong);
		
	}
	
	public void createLabelAnswerTrue() {
		odpTrue = new JLabel("Odpowiedź poprawna!");
		odpTrue.setBounds(44, 810, 180, 30);
		odpTrue.setFont(new Font("SansSerif", Font.BOLD, 13));
		odpTrue.setVisible(false);
		add(odpTrue);
	}
	
	public String getOdp() {
		return tExitCode.getText().toUpperCase();
	}

	public void setFocus() {
		tExitCode.requestFocusInWindow();
	}

	public boolean isOK() {
		return okData;
	} 
}

