package Oppgave3;
/**
 * Innlevering Java oppgave 3
 * Cezar Sincan Johansson
 * 02.02.2012
 */

public class StudentVO {
	private int snr;
	private String navn;
	private String adresse;
	private String fdato;

	public StudentVO(int snr, String navn, 
                       String adresse, String fdato) {
		this.snr = snr;
		this.navn = navn;
		this.adresse = adresse;
		this.fdato = fdato;
	}
	
	public int getSnr() {
		return snr;
	}

	public String getNavn() {
		return navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getFdato() {
		return fdato;
	}
		
	public String toString() {
		return snr + " " + navn + " " +
			   adresse + " " + fdato;
	}

}
