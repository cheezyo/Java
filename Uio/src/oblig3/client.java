package oblig3;

import java.util.Comparator;
import java.util.Iterator;

public class client {

	public static void main(String[] args) {
		Comparator<Integer> cInt = Komparator.naturlig();
		Comparator<String> cString = Komparator.naturlig();
		Comparator<Character> cChar = Komparator.naturlig();
		SBinTre2<Integer> intTre = new SBinTre2<>(cInt);
		SBinTre2<String> stringTre = new SBinTre2<>(cString);
		SBinTre2<Character> charTre = new SBinTre2<>(cChar);
		
		intTre.leggInn(10);
		intTre.leggInn(5);
		intTre.leggInn(2);
		intTre.leggInn(8);
		intTre.leggInn(3);
		intTre.leggInn(1);
		intTre.leggInn(-10);
		intTre.leggInn(-2);
		intTre.leggInn(-3);
		intTre.leggInn(-1);
		intTre.leggInn(0);
		intTre.leggInn(10);
		intTre.leggInn(5);
		intTre.leggInn(2);
		intTre.leggInn(8);
		intTre.leggInn(3);
		intTre.leggInn(1);
		intTre.leggInn(-10);
		intTre.leggInn(-2);
		intTre.leggInn(-3);
		intTre.leggInn(-1);
		intTre.leggInn(0);
		intTre.leggInn(10);
		intTre.leggInn(5);
		intTre.leggInn(2);
		intTre.leggInn(8);
		intTre.leggInn(-300);
		intTre.leggInn(1);
		intTre.leggInn(-40);
		intTre.leggInn(-200);

		intTre.leggInn(-45);
		intTre.leggInn(56456);
		System.out.println(intTre.nestMinst());
		stringTre.leggInn("Cezar");
		charTre.leggInn('A');
		intTre.leggInn(2);
		stringTre.leggInn("Cezar1");
		charTre.leggInn('B');
		intTre.leggInn(3);
		stringTre.leggInn("Cezar2");
		charTre.leggInn('C');
		System.out.println("Antall like :" + intTre.antall(4));
		System.out.println(intTre.toString());
		System.out.println(stringTre.toString());
		System.out.println(charTre.toString());
		System.out.println("Int " + intTre.antall() + " String " + stringTre.antall() + " Char " + charTre.antall());
		
		Iterator<Integer> itInt = intTre.iterator();
		Iterator<String> itString = stringTre.iterator();
		Iterator<Character> itChar = charTre.iterator();
		
		for(int i : intTre){
			System.out.println(itInt.next());
		}
		
		for(String s : stringTre){
			System.out.println(itString.next());
		}
		
		for(char c : charTre){
			System.out.println(itChar.next());
		}
	}
}
