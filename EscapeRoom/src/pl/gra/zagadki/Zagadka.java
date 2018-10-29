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

public class Zagadka extends JDialog{
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JLabel imageRiddle1,lAnswerRiddle1, lAnswerTrue, lAnswerWrong;
	private JTextArea lPrompt;
	private JScrollPane sPrompt;
	private boolean okData;
	private static final String  result = "5";
	
	
	
	public Zagadka(JFrame owner) {
	   super(owner, "Ślimak", true);
	   
	   setZagadka1Parametres ();
	   createImageParameters();
	   createLabelGiveAnswer();
	   createLabelAnswerTrue();
	   createLabelAnswerWrong();
	   createTextFieldToEnterAnswer();
	   createButtonPrompt();
	   createTextAreaWithPrompt();
	   createButtonConfirmingTheAnswer ();
	   createButtonToCancel();
	   
	}
	
	public void setZagadka1Parametres() {
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	

	public void createImageParameters() {
		imageRiddle1 = new JLabel(new ImageIcon("images/slimak.jpg"));
		imageRiddle1.setBounds(50, 30, 1000, 500);
		add(imageRiddle1);
	}

	public void createLabelGiveAnswer() {
		lAnswerRiddle1 = new JLabel("Podaj odpowiedź:  ");
		lAnswerRiddle1.setBounds(50, 550, 180, 30);
		lAnswerRiddle1.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(lAnswerRiddle1);
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
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
				}
			}
		});

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
		lPrompt = new JTextArea("Skorupa ślimaka, to przykład boskiej proporcji w przyrodzie (lub złotego podziału), "
				+ "\nzwróć uwagę na ciąg liczbowy i skojarz go z popularnym ciągiem określonym w 1202 r."
				+ "\nprzez włoskiego matematyka z Pizy,"
				+ "\nktóry nazywał się Fibonacci, a w jego ciągu pierwsza + druga cyfra daje trzecią"
				+ "\ndruga + trzecia daje czwartą i tak dalej.");
		lPrompt.setVisible(false);
		sPrompt = new JScrollPane(lPrompt);
		sPrompt.setBounds(530, 550, 500, 22);
		add(sPrompt);
	}

	public void createButtonConfirmingTheAnswer() {
		bAnswer = new JButton("Potwierdź");
		bAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		;
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

