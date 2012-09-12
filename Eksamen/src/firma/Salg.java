package firma;

import java.io.Serializable;

public class Salg implements Serializable{
	private int salgssum;
	private int antallVarer;
	private String selgernummer;

	public Salg(String selgernummer, int antallVarer, int salgssum) {
		setSelgernummer(selgernummer);
		setAntallVarer(antallVarer);
		setSalgssum(salgssum);
	}

	public int getAntallVarer() {
		return antallVarer;
	}

	public void setAntallVarer(int antallVarer) {
		this.antallVarer = antallVarer;
	}

	public int getSalgssum() {
		return salgssum;
	}

	public void setSalgssum(int salgssum) {
		this.salgssum = salgssum;
	}

	public String getSelgernummer() {
		return selgernummer;
	}

	public void setSelgernummer(String selgernummer) {
		this.selgernummer = selgernummer;
	}

	public String toString() {
		return "Selger: " + selgernummer + "\nAntall varer: " + antallVarer
				+ "\nSalgsum: " + salgssum + "\n";
	}
}