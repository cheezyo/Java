package oppgaver;

public class RegneTall {
	public static void main(String[] args) {
		int n = 100;
		System.out.println(
			"Summen av de " + n + 
			" første heltallene er " + sum(n));
	}

	public static int sum(int grense) {
		if (grense > 1)
			return grense + sum(grense - 1);
		else
			return 1;
	}
}



