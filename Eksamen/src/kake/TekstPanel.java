package kake;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class TekstPanel extends JPanel implements Observer {
	// Variables declaration
	private StemmeOpptelling stemmer;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField txtJa;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField txtNei;

	// End of variables declaration
	/** Creates new form TekstPanel */
	public TekstPanel(StemmeOpptelling stm) {
		stemmer = stm;
		stm.addObserver(this);
		initComponents();
		txtJa.setText(String.valueOf(stemmer.jaAntall()));
		txtNei.setText(String.valueOf(stemmer.neiAntall()));
	}

	public void update(java.util.Observable obs, Object obj) {
		StemmeOpptelling s = (StemmeOpptelling) obs;
		txtJa.setText(String.valueOf(s.jaAntall()));
		txtNei.setText(String.valueOf(s.neiAntall()));
	}

	private void initComponents() { // initComponents
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtJa = new javax.swing.JTextField();
		txtJa.setEditable(false);
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		txtNei = new javax.swing.JTextField();
		txtNei.setEditable(false);
		setLayout(new java.awt.GridLayout(2, 1));

		jLabel1.setText("JA-stemmer");
		jPanel1.add(jLabel1);

		txtJa.setColumns(6);
		jPanel1.add(txtJa);
		add(jPanel1);

		jLabel2.setText("NEI-stemmer");
		jPanel2.add(jLabel2);

		txtNei.setColumns(6);
		jPanel2.add(txtNei);

		add(jPanel2);

	} // initComponents
}