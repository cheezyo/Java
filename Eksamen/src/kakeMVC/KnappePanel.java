package kakeMVC;

import javax.swing.JPanel;



public class KnappePanel extends JPanel  {
	// Variables declaration
	private Stemme stemmer;
	private javax.swing.JButton btnJa;
	private javax.swing.JButton btnNei;

	public KnappePanel(Stemme stemmer) {
		this.stemmer = stemmer;
		initComponents();
	}

	private void initComponents() { // initComponents
		btnJa = new javax.swing.JButton();
		btnNei = new javax.swing.JButton();
		setLayout(new java.awt.GridLayout(1, 2, 10, 10));
		btnJa.setText("Ja");
		
		btnJa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stemmer.fireJaStemmerEvent();
				
			}
		});
		add(btnJa);
		btnNei.setText("Nei");
		btnNei.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stemmer.fireNeiStemmerEvent();
				
			}
		});
		add(btnNei);
	} // initComponents

	
}