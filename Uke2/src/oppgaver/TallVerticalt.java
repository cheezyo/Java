package oppgaver;

public class TallVerticalt {
	public static void main(String[] args) {
		skrivVertikalt(1000);
		
	

	}
	
	public static void skrivVertikalt(int tallet) {
		int tierpotens = 1;
		int temp = tallet;
		while (temp >= 10) {
			temp = temp / 10;
			tierpotens = tierpotens * 10;
		}
		for (int tiere = tierpotens; tiere > 0; tiere = tiere / 10) {
			System.out.println(tallet / tiere);
			tallet = tallet % tiere;
		}
	}

}
