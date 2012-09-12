package oppgaver;

public class Ararat {
	
	public static void main(String[] args) {
		System.out.println(metode(3));
		
	}
	
	public static String metode(int i){
		if(i == 1){
			return "at";
		}else{
			return "ar" + metode(i - 1);
		}
	}

}
