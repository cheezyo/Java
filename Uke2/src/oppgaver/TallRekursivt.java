package oppgaver;

public class TallRekursivt {
	public static void main(String[] args) {
		metode(1000);
	}
	
	public static void metode(int i){
		
		
		if (i < 10){
			System.out.println(i);
		}else{
			metode( i / 10);
			System.out.println(i % 10);
		
		}
	}
	
	

}
