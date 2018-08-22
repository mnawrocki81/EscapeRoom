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
	
	JLabel ltytu³;
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
		
		bstart = new JButton("Rozpocznij grê");
		bstart.setFont(new Font("SansSerif", Font.BOLD, 20));
		bstart.setBounds(500,300,200,100);
		
		add(bstart);
		bstart.addActionListener(this);
		

		ltytu³ = new JLabel("Szalony matematyk",JLabel.CENTER);
		ltytu³.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltytu³.setBounds (400,100,400,200);
		ltytu³.setForeground(Color.RED);
		//ltytu³.setForeground(new Color(0,200,250));
		ltytu³.setFont(new Font("SansSerif", Font.ITALIC, 40));
		add(ltytu³);
		ltekst  = new JTextArea ("Marcin Nawrocki - Praca Dyplomowa \nWWSIS Horyzont Studia Podyplomowe \n"
				+ "In¿ynieria Oprogramowania - Programowanie \npod kierunkiem mgr.in¿. Krzysztofa Wêzowskiego");
		ltekst.setBounds(800,500, 350,100);
		ltekst.setFont(new Font("SansSerif", Font.BOLD, 15));
		ltekst.setLineWrap(true);
		add(ltekst);
		
		
	}
   //@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Object zród³o = e.getSource();
		if (zród³o == bstart)
		{}
		else if{};
		*/
		//System.out.println("Gra zaraz sie zacznie!");
		
		OknoStartowe powitanie = new OknoStartowe();
		OknoGry pocz¹tek = new OknoGry();
		pocz¹tek.setVisible(true);
		dispose();
		Timer tm = null;
		tm.start();
	}
}
