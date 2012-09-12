package mvc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

abstract class Temp extends JFrame implements Observer{

	private JButton raise, lower;
	private JTextField showField;
	private JLabel label;
	private Model model;
	
	
	public Temp(String s, Model model){
		super(s + " Temperature");
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel north = new JPanel(new GridLayout(2,1));
		label = new JLabel(s + " temperature");
		showField = new JTextField(15);
		raise = new JButton("Raise");
		lower = new JButton("Lower");
		north.add(label);
		north.add(showField);
		JPanel south = new JPanel(new GridLayout(1,2));
		south.add(raise);
		south.add(lower);
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		model.addObserver(this);
		pack();
		setVisible(true);
		
		
	}
	
	public void setDisplay(String s){
		showField.setText(s);
		
	}
	
	public double getDisplay(){
		double res = 0.0;
		try{
			res = Double.valueOf(showField.getText()).doubleValue();
		}catch(NumberFormatException e){
			System.out.println("error");
		}
		return res;
	}
	
	public void addDisplayListener(ActionListener a){
		showField.addActionListener(a);
	}
	
	public void addUpListener(ActionListener a){
		raise.addActionListener(a);
	}
	
	public void addDownListener(ActionListener a){
		lower.addActionListener(a);
	}
	
	protected Model model(){
		return model;
	}
	
	
	
}
