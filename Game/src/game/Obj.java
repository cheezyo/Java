package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Obj extends JPanel {
private int x = 20 ,y = 20;	
	
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 100, 50);
	}
	
	
}