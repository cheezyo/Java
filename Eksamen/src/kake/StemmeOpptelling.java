package kake;

import java.util.Observable;

public class StemmeOpptelling extends Observable {
	private int jaStemmer;
	private int neiStemmer;

	/** Creates new StemmeOpptelling */
	public StemmeOpptelling() {
		setStemmer(0, 0);
	}

	public StemmeOpptelling(int ja, int nei) {
		setStemmer(ja, nei);
	}

	public void jaInc(int ja) {
		jaStemmer += ja;
		setChanged();
		notifyObservers();
	}

	public void neiInc(int nei) {
		neiStemmer += nei;
		setChanged();
		notifyObservers();
	}

	public int jaAntall() {
		return jaStemmer;
	}

	public int neiAntall() {
		return neiStemmer;
	}

	private void setStemmer(int j, int n) {
		jaStemmer = j;
		neiStemmer = n;
	}

}