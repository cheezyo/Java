package oppgaver;

public class Ord {
	public static void main(String[] args) {
		System.out.println(kall(3));
	}

	public static String kall(int i) {
		if (i == 1)
			return "erdig";
		else {
			return "nev" + kall(i - 1);
		}
	}
}
