package kakeMVC;

public class StemmeEvent {
	
	private Stemme source;

	
	public StemmeEvent(Stemme source){
		this.source = source;
	}
	
	public Stemme getSource(){
		return source;
	}
}
