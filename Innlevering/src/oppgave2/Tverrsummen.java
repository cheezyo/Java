package oppgave2;
/**
 * Innlevering Java oppgave 2
 * Cezar Sincan Johansson
 * 02.02.2012
 */

public class Tverrsummen {
	
	public static void main(String[] args) {
		System.out.println(tverrsum(12345));
	}
	
	public static int tverrsum(int num){
		if(num > 0){
			return num % 10 + tverrsum( num / 10 );
		}
			return 0;
	}

}
