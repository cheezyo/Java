package main;

import java.util.Iterator;

import dobleLinkedList.DobbeltLenketListe;

public class Client {
	public static void main(String[] args) {

		DobbeltLenketListe<String> list = new DobbeltLenketListe<String>();
		

		// String s = null;
		// list.leggInn(s);

		list.leggInn("a");
	/*	list.leggInn("b");
		list.leggInn("c");
		list.leggInn("d");
		list.leggInn("e");
		list.leggInn("f");
		list.leggInn("g");
		list.leggInn("h");*/

		Iterator<String> it = list.iterator();
		System.out.println(it.next());
		System.out.println(it.next());

		System.out.println(list.toString());

		/*
		 * System.out.println(list.antall()); System.out.println(list.tom());
		 * System.out.println(list.toString());
		 * /*System.out.println("Onvendt string");
		 * System.out.println(list.omvendtString());
		 * System.out.println("Hent###########");
		 * System.out.println(list.hent(5));
		 * System.out.println("Hent###############");
		 * 
		 * System.out.println(list.oppdater(1, "i"));
		 * System.out.println(list.toString());
		 * 
		 * System.out.println(list.indeksTil("g"));
		 * System.out.println(list.inneholder("3"));
		 * 
		 * System.out.println(list.antall());
		 * System.out.println("Legg inn med indeks########");
		 * list.leggInn(list.antall() - 1,"x");
		 * System.out.println(list.toString());
		 * System.out.println("#################");
		 * 
		 * 
		 * 
		 * System.out.println(list.fjern(0));
		 * System.out.println(list.toString());
		 * 
		 * System.out.println(list.fjern("x"));
		 * System.out.println(list.toString());
		 * 
		 * System.out.println(list.fjern("cdcdc"));
		 * System.out.println(list.toString());
		 * 
		 * list2.leggInn("heo"); System.out.println(list2.toString());
		 * System.out.println(list2.fjern(0));
		 * System.out.println(list2.toString()); //list.nullstill();
		 * System.out.println(list.toString());
		 */

	}
}
