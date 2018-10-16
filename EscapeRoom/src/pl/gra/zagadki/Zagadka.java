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

//zaprogramowanie okna z zagadką, dziedziczącego po klasie JDialog
public class Zagadka extends JDialog{
	
	private JTextField tAnswer;
	private JButton bPrompt, bAnswer, bCancel;
	private JLabel imageZagadka1,odpZagadka1, odpTrue, odpWrong;
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
	
	public void setZagadka1Parametres ()
	{
		setBounds(150, 150, 1120, 700);
		setLayout(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // zamknąć okno można tylko przyciskiem "Wróć" lub
																// podając raz dobrą odpowiedz
	} 
	
	public void createImageParameters()
	{
		   imageZagadka1 = new JLabel(new ImageIcon("images/slimak.jpg"));
		   imageZagadka1.setBounds(50, 30, 1000, 500);
		   add(imageZagadka1);
	}
	
	public void createLabelGiveAnswer()
	{
		odpZagadka1 = new JLabel("Podaj odpowiedź:  ");
		odpZagadka1.setBounds(50, 550, 180, 30);
		odpZagadka1.setFont(new Font("SansSerif", Font.BOLD, 20));
		add(odpZagadka1);
	}
	
	public void createLabelAnswerTrue()
	{
		odpTrue = new JLabel("Odpowiedź poprawna!");
		odpTrue.setBounds(50, 600, 180, 30);
		odpTrue.setFont(new Font("SansSerif", Font.BOLD, 13));
		odpTrue.setVisible(false);
		add(odpTrue);
		
	}
	
	
	public void createLabelAnswerWrong()
	{
		odpWrong = new JLabel("To nie to! Przemyśl i spróbuj ponownie!");
		odpWrong.setBounds(400, 600, 350, 30);
		odpWrong.setFont(new Font("SansSerif", Font.BOLD, 16));
		odpWrong.setForeground(Color.RED);
		odpWrong.setVisible(false);
		add(odpWrong);
		
	}
	
	public void createTextFieldToEnterAnswer()
	{
		tAnswer = new JTextField();
		tAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					odpTrue.setVisible(true);
					bAnswer.setVisible(false);
					odpWrong.setVisible(false);
					setVisible(false);
				} else {
					odpWrong.setVisible(true);
					tAnswer.setText("");
				}
			}
		});

		tAnswer.setBounds(250, 550, 100, 30);
		tAnswer.setFont(new Font("SansSerif", Font.BOLD, 20));
		tAnswer.setHorizontalAlignment(JTextField.CENTER);
		add(tAnswer);
	}
	
	public void createButtonPrompt()
	{
	       bPrompt = new JButton("Podpowiedź");
	       bPrompt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					lPrompt.setVisible(true);
				}
			});
	       bPrompt.setBounds(400, 550, 120, 22);
	       add(bPrompt);
	}
	
	public void createTextAreaWithPrompt()
	{
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
	
	public void createButtonConfirmingTheAnswer ()
	{
		//przycisk Potwierdź może być użyty tylko raz, pózniej zostaje ukryty i pojawia się komunikat o poprawnej odpowiedzi
		bAnswer = new JButton("Potwierdź");
		bAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getOdp().equals(result)) {
					okData = true;
					tAnswer.setEditable(false);
					odpTrue.setVisible(true);
					bAnswer.setVisible(false);
					odpWrong.setVisible(false);
					setVisible(false);
				} else {
					odpWrong.setVisible(true);
					tAnswer.setText("");
					tAnswer.requestFocusInWindow();
				}
			}
		});
		bAnswer.setBounds(50, 600, 120, 25);
		add(bAnswer);
		
	}
	
	public void createButtonToCancel()
	{
		bCancel = new JButton("Wróć");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				okData = false;
				setVisible(false);
			}
		});;
		bCancel.setBounds(200, 600, 120, 25);
		add(bCancel);
	}
	
	//Funkcje do współpracy głównego okna gry i okna dialogowego
	public String getOdp() {
		return tAnswer.getText();
	}
        
	public boolean isOK() {
		return okData;
	}

	       
    
}

