package game;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Obj o = new Obj();
		f.add(o);
		f.setSize(400, 200);
		f.setVisible(true);
		
		
	}

}
