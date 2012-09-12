package kakeMVC;

import javax.swing.JPanel;

public class TekstPanel extends JPanel implements StemmeListener {
	// Variables declaration
	
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField txtJa;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField txtNei;
	private int antallJa = 0;
	private int antallNei =0;

	// End of variables declaration
	/** Creates new form TekstPanel */
	public TekstPanel() {
		
		initComponents();
		txtJa.setText(String.valueOf(antallJa));
		txtNei.setText(String.valueOf(antallNei));
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

	@Override
	public void jaStemmer(StemmeEvent e) {
		antallJa += 1;
		txtJa.setText(String.valueOf(antallJa));
		
	}

	@Override
	public void NeiStemmer(StemmeEvent e) {
		antallNei += 1;
		txtNei.setText(String.valueOf(antallNei));
		
	}
}
