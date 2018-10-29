package pl.gra.zagadki;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Letter extends JDialog  {
	
	private JLabel imageLetter;
	private JButton bCancel;
		
	public Letter(JFrame owner) {
		super(owner, "Letter", true);

		setLetterParametres();
		createImageParameters();
		createButtonToCancel();

	}
	
	public void setLetterParametres() {
		setBounds(350, 50, 700, 900);
		setLayout(null);
		// setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}

	public void createImageParameters() {
		imageLetter = new JLabel(new ImageIcon("images/list.jpg"));
		imageLetter.setBounds(20, 20, 657, 699);
		add(imageLetter);
	}

	public void createButtonToCancel() {
		bCancel = new JButton("Wróć do gry");
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		bCancel.setBounds(275, 800, 150, 30);
		add(bCancel);
	}

}

