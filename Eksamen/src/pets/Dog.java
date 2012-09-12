package pets;

import java.util.HashSet;
import java.util.Set;

public class Dog {

	private Thread life = new Thread(){
		public void run(){
			while(true){
				int roll = (int) (Math.random()* 4.0);
				switch(roll){
				case 0: fireDogHungryEvent(); break;
				case 1: fireDogLonleyEvent(); break;
				case 2: fireDogSleepsEvent(); break;
				case 3: fireDogThirstyEvent(); break;
				}
				try{
					sleep(5000);
				}catch(Exception e){
					
				}
			}
		}
	};
	private Set<DogListener>listeners;
	private String name;
	
	public Dog (String name){
		this.name = name;
		listeners = new HashSet<DogListener>();
		life.start();
	}
	
	public String getName(){
		return name;
	}
	
	public synchronized void addDogListener(DogListener listener){
		listeners.add(listener);
	}
	
	public synchronized void removeDogListener(DogListener listener){
		listeners.remove(listener);
	}
	
	protected synchronized void fireDogHungryEvent(){
		System.out.println(name + " is hungry");
		DogEvent e = new DogEvent(this);
		for(DogListener listener : listeners){
			listener.dogHungry(e);
		}
	}
	
	protected synchronized void fireDogThirstyEvent(){
		System.out.println(name + " is thirsty");
		DogEvent e = new DogEvent(this);
		for(DogListener listener : listeners){
			listener.dogThirsty(e);
		}
	}
	
	protected synchronized void fireDogSleepsEvent(){
		System.out.println(name + " is sleeping");
		DogEvent e = new DogEvent(this);
		for(DogListener listener : listeners){
			listener.dogSleeps(e);
		}
	}
	
	protected synchronized void fireDogLonleyEvent(){
		System.out.println(name + " is lonley");
		DogEvent e = new DogEvent(this);
		for(DogListener listener : listeners){
			listener.dogLonley(e);
		}
	}
}
