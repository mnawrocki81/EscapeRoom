package pl.gra;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Program do pracy dyplomowej, gra Escape Room
 * @version 30.08.2018
 * @author mnawrocki
 *
 */
public class EscapeRoom extends JFrame {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoGry pocz¹tek = new OknoGry();
					pocz¹tek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					pocz¹tek.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
