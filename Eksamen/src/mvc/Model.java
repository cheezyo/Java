package mvc;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {
	
	private double tempF;
	

	public double getF(){
		return tempF;
	}
	
	public double getC(){
		return (tempF -32.0) * 5.0 / 9.0;
	}
	
	public void setC(double C){
		tempF = C * 9.0 /5.0 +32.0;
		setChanged();
		notifyObservers();
	}
	
	public void setF(double F){
		tempF = F;
		setChanged();
		notifyObservers();
	}
	
}
