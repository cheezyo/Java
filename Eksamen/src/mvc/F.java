package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class F extends Temp {

	public F(String title, Model model) {
		super(title, model);
		setDisplay("" + model().getF());
		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setDisplay("" +model().getF());
		
	}
	
	class UpListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			model().setF(model().getF()+ 1.0);
		}
	}

	class DownListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			model().setF(model().getF() -1.0);
		}
	}
	
	class DisplayListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double val = getDisplay();
			model().setF(val);
		}
	}
}
