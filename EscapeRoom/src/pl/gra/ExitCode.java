package pl.gra;

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


public class ExitCode extends JDialog {
	
	private JButton bPrompt, bAnswer, bCancel;
	private JTextField tExitCode;
	private JLabel imageExitCode;
	private JScrollPane sPrompt;
	private JTextArea lPrompt;
	private boolean okData ;
	
	
	public ExitCode(JFrame owner) {
		super(owner, "ExitCode", true);
		
		setExitCodeParametres();
		createImageParameters();
		createTextFieldExitCode();
		createButtonPrompt();
		createTextAreaWithPrompt();
		createButtonConfirmingTheAnswer();
		createButtonToCancel();

}

	public void setExitCodeParametres() {
		setBounds(350, 50, 700, 900);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}

	public void createImageParameters() {
		imageExitCode = new JLabel(new ImageIcon("images/klawiatura.jpg"));
		imageExitCode.setBounds(44, 140, 612, 630);
		add(imageExitCode);

	}

	public void createTextFieldExitCode() {
		tExitCode = new JTextField();
		tExitCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				okData = true;
				setVisible(false);
			}
		});

		tExitCode.setBounds(44, 20, 612, 120);
		tExitCode.setFont(new Font("SansSerif", Font.BOLD, 40));
		tExitCode.setForeground(new Color(255, 255, 153));
		tExitCode.setBackground(new Color(102, 51, 0));
		tExitCode.setHorizontalAlignment(JTextField.CENTER);
		tExitCode.requestFocusInWindow();
		add(tExitCode);
	}

	public void createButtonPrompt() {
		bPrompt = new JButton("Podpowiedź");
		bPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lPrompt.setVisible(true);
			}
		});
		bPrompt.setBounds(44, 780, 120, 22);
		add(bPrompt);

	}

	public void createTextAreaWithPrompt() {
		lPrompt = new JTextArea(
				"Przyjrzyj sie znakom na przyciskach" + "\nUłóż słowo z cyfr, które są odpowiedziami do zagadek."
						+ "\nWskazówkę znajdziesz w kopercie ze skrzynki!");
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

					okData = true;
					setVisible(false);	
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
	
	public String getOdp() {
		return tExitCode.getText().toUpperCase();
	}

	public void setOdp() {
		tExitCode.setText("");
		tExitCode.requestFocusInWindow();
	}

	public boolean isOK() {
		return okData;
	} 
}

