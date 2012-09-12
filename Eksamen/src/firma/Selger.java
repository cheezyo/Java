package firma;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Selger extends JFrame implements ActionListener {
	private JTextField txtVarer;
	private JTextField txtSalgssum;
	private JTextField txtSelgernummer;
	private JButton btnSend;
	private JButton btnAvslutt;
	private JTextArea display;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket firma;
	private String ip = "192.168.0.190";
	private int port = 8000;
	private ArrayList<Salg> salgsListe;
	
	public Selger() {
		super("Selgerrapport");
		salgsListe = new ArrayList<Salg>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display = new JTextArea(20, 20);
		JPanel north = new JPanel(new GridLayout(4, 2));
		txtSelgernummer = new JTextField(10);
		txtVarer = new JTextField(10);
		txtSalgssum = new JTextField(10);
		btnAvslutt = new JButton("Avslutt");
		btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		btnAvslutt.addActionListener(this);
		north.add(new JLabel("Selgernummer"));
		north.add(txtSelgernummer);
		north.add(new JLabel("Antall varer solgt"));
		north.add(txtVarer);
		north.add(new JLabel("Samlet salgssum"));
		north.add(txtSalgssum);
		north.add(btnSend);
		north.add(btnAvslutt);
		add(north, BorderLayout.NORTH);
		add(new JScrollPane(display), BorderLayout.CENTER);
		pack();
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object pressed = e.getSource();
		
		if(pressed == btnAvslutt){
			System.exit(0);
		}else if (pressed == btnSend){
			sendSalg();
		}
		
	}
	
	public void sendSalg(){
		int varer = Integer.parseInt(txtSalgssum.getText().toString());
		int sum = Integer.parseInt(txtSalgssum.getText().toString());
		String selger = txtSelgernummer.getText().toString();
	
		Salg s = new Salg(selger, varer, sum);
		
		
		try {
			firma = new Socket(ip, port);
			output = new ObjectOutputStream(firma.getOutputStream());
			input = new ObjectInputStream(firma.getInputStream());
			System.out.println("for while");
			
				System.out.println("strat while");
				output.flush();
				output.writeObject(s);
				output.flush();
				salgsListe = (ArrayList) input.readObject();
				
				System.out.println("end whiile");
				String list = null;
				
				for (int i =0; i < salgsListe.size(); i++){
					list+= salgsListe.get(i).toString();
				}
				display.removeAll();
				display.append(list);
				
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Selger s = new Selger();
	}
	
}
