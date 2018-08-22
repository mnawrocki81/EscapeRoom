import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class OknoStartowe extends JFrame implements ActionListener {

	JButton bstart;
	
	JLabel ltytu�;
	JTextArea ltekst;
	
	public OknoStartowe()
	{
		/*
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();
		int screenHeight = screensize.height;
		int screenWidth = screensize.width;
		
		setSize(screenWidth, screenHeight);
		setLocationByPlatform(true);
		*/
		setBounds(100,100,1200,800);
		setTitle("EscapeRoom");
	
		setLayout(null);
		
		bstart = new JButton("Rozpocznij gr�");
		bstart.setFont(new Font("SansSerif", Font.BOLD, 20));
		bstart.setBounds(500,300,200,100);
		
		add(bstart);
		bstart.addActionListener(this);
		

		ltytu� = new JLabel("Szalony matematyk",JLabel.CENTER);
		ltytu�.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltytu�.setBounds (400,100,400,200);
		ltytu�.setForeground(Color.RED);
		//ltytu�.setForeground(new Color(0,200,250));
		ltytu�.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(ltytu�);
		ltekst  = new JTextArea ("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "In�ynieria Oprogramowania - Programowanie \npod kierunkiem mgr.in�. Krzysztofa W�zowskiego");
		ltekst.setBounds(800,500, 350,100);
		ltekst.setFont(new Font("SansSerif", Font.BOLD, 15));
		ltekst.setLineWrap(true);
		add(ltekst);
		
		
	}
   //@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Object zr�d�o = e.getSource();
		if (zr�d�o == bstart)
		{}
		else if{};
		*/
		//System.out.println("Gra zaraz sie zacznie!");
		
		OknoStartowe powitanie = new OknoStartowe();
		OknoGry pocz�tek = new OknoGry();
		pocz�tek.setVisible(true);
		dispose();
		Timer tm = null;
		tm.start();
	}
}
