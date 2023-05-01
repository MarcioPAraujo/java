import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	MyFrame(){
		
		this.setVisible(true);
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("jframe intoduction");
		
		this.getContentPane().setBackground(Color.pink);
		
	}

}
