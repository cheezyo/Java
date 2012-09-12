package hart;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonsGui extends JFrame implements ActionListener {

	private JButton bore, excite, stopp;
	private Model model;
	private static final int INCRESE = 2;
	private static final int DECRESE = -1;
	public ButtonsGui(Model model){
		init();
		this.model = model;
	}

	
	public void init(){
		bore = new JButton("bore");
		bore.addActionListener(this);
		excite = new JButton("excite");
		excite.addActionListener(this);
		stopp = new JButton("stopp");
		stopp.addActionListener(this);
		JPanel main = new JPanel(new GridLayout(1,1));
		main.add(bore);
		main.add(excite);
		main.add(stopp);
		add(main,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == bore){
			model.adjustHart(DECRESE);
		}else if(o == excite){
			model.adjustHart(INCRESE);
			
		}else if(o == stopp){
			model.stopp();
			
		}
	}
	
	

}
