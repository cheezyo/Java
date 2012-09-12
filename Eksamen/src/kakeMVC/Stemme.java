package kakeMVC;

import java.util.HashSet;
import java.util.Set;

public class Stemme {
	private int ja, nei;
	private Set<StemmeListener> listeners;
	public Stemme(int ja, int nei){
		setStemmer(ja, nei);
		listeners = new HashSet<StemmeListener>();
	}
	
	public void setStemmer(int ja, int nei){
		this.ja = ja;
		this.nei = nei;
	}

	public void addStemmeListener(StemmeListener listener){
		listeners.add(listener);
	}
	
	public void removeStemmeListener(StemmeListener listener){
		listeners.remove(listener);
	}
	
	public void fireJaStemmerEvent(){
		StemmeEvent e = new StemmeEvent(this);
		for (StemmeListener listener : listeners){
			listener.jaStemmer(e);
		}
		
	}
	
	public void fireNeiStemmerEvent(){
		StemmeEvent e = new StemmeEvent(this);
		for(StemmeListener listener : listeners){
			listener.NeiStemmer(e);	
		}
		
		
	}
	
	
}


