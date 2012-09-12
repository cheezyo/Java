package kake;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class GrafPanel extends JPanel implements Observer {
	private StemmeOpptelling stemmer;

	/** Creates new form GrafPanel */
	public GrafPanel(StemmeOpptelling stm) {
		stemmer = stm;
		stm.addObserver(this);
		setPreferredSize(new java.awt.Dimension(150, 100));
		repaint();
	}

	public void update(java.util.Observable obs, Object obj) {
		repaint();
	}

	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		int totalt = stemmer.jaAntall() + stemmer.neiAntall();
		if (totalt == 0) {
			g.setColor(java.awt.Color.green);
			g.fillOval(40, 20, 70, 70);
		} else {
			int vinkel = (int) Math.round(360.0 * stemmer.jaAntall() / totalt);
			g.setColor(java.awt.Color.blue);
			g.fillArc(40, 20, 70, 70, 0, vinkel);
			g.setColor(java.awt.Color.red);
			g.fillArc(40, 20, 70, 70, vinkel, 360 - vinkel);
		}
		g.setColor(java.awt.Color.black);
		g.drawOval(40, 20, 70, 70);
	}
}