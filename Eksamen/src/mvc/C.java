package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class C extends Temp{

	public C(String title, Model model) {
		super(title, model);
		setDisplay("" + model.getC());
		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());
	}

	@Override
	public void update(Observable o, Object arg) {
		setDisplay("" + model().getC());
		
	}
	class UpListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			model().setC(model().getC()+ 1.0);
		}
		
	}
	
	class DownListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			model().setC(model().getC() - 1.0);
		}
	}
	
	class DisplayListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double val = getDisplay();
			model().setC(val);
		}
	}
}
