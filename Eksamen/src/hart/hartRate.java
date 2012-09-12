package hart;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class hartRate extends JFrame implements Observer{
	private JLabel label;
	private JTextField field;

	
	
	public hartRate(Model model){
		super("Hartview");
		label = new JLabel("Hartrate: ");
		field = new JTextField("1");
		model.addObserver(this);
		
		
		JPanel main = new JPanel(new GridLayout(1,1));
		main.add(label);
		main.add(field);
		
		add(main, BorderLayout.CENTER);
		pack();
		setVisible(true);
		
	}
	
	@Override
	public void update(Observable o, Object data) {
		
		field.setText(" " + data);
		
	}
	


	
}
