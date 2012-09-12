package pets;

public class DogEvent {
	private Dog source;
	
	public DogEvent (Dog source){
		this.source = source;
	}

	public Dog getSource(){
		return source;
	}
}
