package hart;

import java.util.Observable;

public class Model extends Observable{
	private int hartRate;
	public Model(){
		
	}
	
	public int getHartRate(){
		return hartRate;
	}
	
	public void adjustHart(int delta){
		hartRate += delta;
		if(hartRate < 1){
			hartRate = 1;
		}
		setChanged();
		notifyObservers();
	}
	
	public void stopp(){
		hartRate = 0;
		setChanged();
		notifyObservers();
	}

	
	

}
