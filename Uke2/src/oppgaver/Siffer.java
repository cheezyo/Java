package oppgaver;

public class Siffer {
	public static void main(String[] args) {
		int tall = 4523;
		skriv(tall);
	}

	public static void skriv(int tallet) {
		while (tallet > 0) {
			System.out.println(tallet % 10);
			tallet /= 10;
		}
	}
}