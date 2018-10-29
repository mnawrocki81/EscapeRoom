package pl.gra;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Program do pracy dyplomowej, gra Escape Room
 * @version 29.10.2018
 * @author mnawrocki
 *
 */

public class EscapeRoom extends JFrame {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoGry beginning = new OknoGry();
					beginning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					beginning.setVisible(true);
					beginning.revalidate();
					beginning.repaint();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
