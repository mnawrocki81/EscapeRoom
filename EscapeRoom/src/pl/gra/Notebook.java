package pl.gra;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notebook extends JDialog {
	
	private JTextArea notebook;
	private JScrollPane scrollPane;
	private JLabel imageNotebook;
	
	public Notebook(JFrame owner) {
		super(owner, "Notatnik", false);

		setNotebookParametres();
		createImageParameters();
		createNotebook();

	}

	public void setNotebookParametres() {
		setSize(510, 830);
		setLayout(null);
	}
	
	public void createImageParameters() {
		imageNotebook = new JLabel(new ImageIcon("images/notebook.jpg"));
		imageNotebook.setSize(500, 200);
		add(imageNotebook);
	}

	public void createNotebook() {
		notebook = new JTextArea();
		notebook.setWrapStyleWord(true);
		notebook.setLineWrap(true);
		notebook.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		scrollPane = new JScrollPane(notebook);
		scrollPane.setBounds(5, 205, 480, 580);
		add(scrollPane);
	}
}