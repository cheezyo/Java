package Oppgave3;

/**
 * Innlevering Java oppgave 3
 * Cezar Sincan Johansson
 * 02.02.2012
 */


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Oppg3Gui extends JFrame {
	
	private JTextField[] data = new JTextField[4];
	private Oppg3Dao resDao;
	private ResultatVO res;
	private ArrayList<StudentVO> studList;

	/** Creates a new instance of ResultatGui */
	public Oppg3Gui(String bruker, String passord) {
		super("Eksamensreultater");
		resDao = new Oppg3Dao(bruker, passord);
		
		add(new JCombo(), BorderLayout.NORTH);
		add(new Buttons(), BorderLayout.SOUTH);
		add(new TekstFelt(), BorderLayout.CENTER);
		
		resDao.hentResultatSet(1);
		res = resDao.førsteRad();
		visRad();
		
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm();
			}
		});
	}
	// JButtons klassen
	private class Buttons extends JPanel {
		private JButton første, forrige, neste, siste;

		public Buttons() {
			setLayout(new GridLayout(1, 4, 10, 10));
			første = new JButton("Første");
			første.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = resDao.førsteRad();
					if (res == null)
						slettTekstfelt();
					else
						visRad();
				}
			});
			forrige = new JButton("Forrige");
			forrige.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = resDao.forrigeRad();
					if (res == null)
						slettTekstfelt();
					else
						visRad();
				}
			});
			neste = new JButton("Neste");
			neste.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = resDao.nesteRad();
					if (res == null)
						slettTekstfelt();
					else
						visRad();
				}
			});
			siste = new JButton("Siste");
			siste.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					res = resDao.sisteRad();
					if (res == null)
						slettTekstfelt();
					else
						visRad();
				}
			});

			add(første);
			add(forrige);
			add(neste);
			add(siste);

		}
	}
	// JTextField klassen
	private class TekstFelt extends JPanel {
		private JLabel[] tekst = { new JLabel("FAG   ", SwingConstants.RIGHT),
				new JLabel("STUDIEPOENG   ", SwingConstants.RIGHT),
				new JLabel("DATO   ", SwingConstants.RIGHT),
				new JLabel("KARAKTER   ", SwingConstants.RIGHT) };
		
		public TekstFelt() {
			setLayout(new GridLayout(4, 2));

			for (int i = 0; i < 4; i++) {
				add(tekst[i]);
				data[i] = new JTextField(20);
				add(data[i]);
				data[i].setEditable(false);
			}
		}
	}
	// JComboBox klassen
	private class JCombo extends JPanel {
		private JComboBox<StudentVO> combo;
		public JCombo() {

			setLayout(new GridLayout(1, 2, 10, 10));
			studList = resDao.hentAlleStudenter();
			combo = new JComboBox<StudentVO>();
			combo.setMaximumRowCount(4);
			for (int i = 0; i < studList.size(); i++) {
				combo.addItem(studList.get(i));
			}

			add(combo);
			
			combo.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent e) {

					if (e.getStateChange() == ItemEvent.SELECTED) {
						for (int i = 0; i < studList.size(); i++) {
							if (e.getItem().equals(studList.get(i))) {
								resDao.hentResultatSet(studList.get(i).getSnr());
								break;
							}
						}
						res = resDao.førsteRad();
						if (res == null)
							slettTekstfelt();
						else
							visRad();

					}
				}
			});
		}
	}

	private void visRad() {
		data[0].setText(res.getFag());
		data[1].setText(res.getStudiepoeng() + "");
		data[2].setText(res.getDato());
		data[3].setText(res.getKarakter() + "");
	}

	private void slettTekstfelt() {
		for (int i = 0; i < 4; i++) {
			data[i].setText("");
		}
	}

	private void exitForm() {
		resDao.lukk();
		System.exit(0);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Oppg3Gui app = new Oppg3Gui("sincez10", "sincez10");
	}
}
