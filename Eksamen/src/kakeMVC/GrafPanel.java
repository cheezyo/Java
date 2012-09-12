package kakeMVC;



import javax.swing.JPanel;



public class GrafPanel extends JPanel implements StemmeListener {
	private int antallJa = 0;
	private int antallNei = 0;

	/** Creates new form GrafPanel */
	public GrafPanel() {
		
		setPreferredSize(new java.awt.Dimension(150, 100));
		repaint();
	}

	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		int totalt = antallJa + antallNei;
		if (totalt == 0) {
			g.setColor(java.awt.Color.green);
			g.fillOval(40, 20, 70, 70);
		} else {
			int vinkel = (int) Math.round(360.0 * antallJa / totalt);
			g.setColor(java.awt.Color.blue);
			g.fillArc(40, 20, 70, 70, 0, vinkel);
			g.setColor(java.awt.Color.red);
			g.fillArc(40, 20, 70, 70, vinkel, 360 - vinkel);
		}
		g.setColor(java.awt.Color.black);
		g.drawOval(40, 20, 70, 70);
	}

	@Override
	public void jaStemmer(StemmeEvent e) {
		antallJa += 1;
		repaint();
	}

	@Override
	public void NeiStemmer(StemmeEvent e) {
		antallNei += 1;
		repaint();
		
	}
}