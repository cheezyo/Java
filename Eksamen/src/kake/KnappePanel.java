package kake;

import javax.swing.JPanel;

public class KnappePanel extends JPanel {
	// Variables declaration
	private StemmeOpptelling stemmer;
	private javax.swing.JButton btnJa;
	private javax.swing.JButton btnNei;

	public KnappePanel(StemmeOpptelling stm) {
		stemmer = stm;
		initComponents();
	}

	private void initComponents() { // initComponents
		btnJa = new javax.swing.JButton();
		btnNei = new javax.swing.JButton();
		setLayout(new java.awt.GridLayout(1, 2, 10, 10));
		btnJa.setText("Ja");
		
		btnJa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stemmer.jaInc(1);
			}
		});
		add(btnJa);
		btnNei.setText("Nei");
		btnNei.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stemmer.neiInc(1);
				
			}
		});
		add(btnNei);
	} // initComponents
}
