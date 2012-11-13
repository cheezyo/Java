package dobleLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.lang.model.element.NestingKind;

public class DobbeltLenketListe<T> implements Liste<T> {
	private static final class Node<T> // en indre nodeklasse
	{
		private T verdi;
		private Node<T> forrige, neste;

		private Node(T verdi, Node<T> forrige, Node<T> neste) // konstruktør
		{
			this.verdi = verdi;
			this.forrige = forrige;
			this.neste = neste;
		}
	}

	private Node<T> hode; // peker til den første i listen
	private Node<T> hale; // peker til den siste i listen
	private int antall; // antall noder i listen
	private int modAntall; // antall modifikasjoner i listen

	private void indeksKontroll(int indeks) {
		if (indeks < 0)
			throw new IndexOutOfBoundsException("Indeks " + indeks
					+ " er negativ!");
		else if (indeks >= antall)
			throw new IndexOutOfBoundsException("Indeks " + indeks
					+ " >= antall(" + antall + ") noder!");
	}

	private static <T> void nullSjekk(T verdi) {
		if (verdi == null) {
			throw new NullPointerException();
		}
	}

	private Node<T> finnNode(int indeks) {
		Node<T> node;

		if (indeks < antall() / 2) {
			node = hode;

			for (int i = 0; i <= indeks; i++) {

				node = node.neste;
			}
		} else {
			node = hale;

			for (int i = antall()-1; i >= indeks; i--) {
				node = node.forrige;
			}
		}

		return node; // foreløpig kode
	}

	
	public DobbeltLenketListe() // konstruktør
	{
		hode = hale = null;
		antall = 0;
		modAntall = 0;
	}

	public boolean tom() {
		if (antall == 0)
			return true;
		else
			return false;

	}

	public int antall() {
		return antall;
	}

	public void nullstill() {
		if(! tom()){
			hode.neste = null;
			hale.forrige = null;
			modAntall++;
			antall = 0;
		}
	}

	public boolean inneholder(T verdi) {
		nullSjekk(verdi);
		if (indeksTil(verdi) != -1) {
			return true;
		}
		return false; // foreløpig kode
	}

	public void leggInn(int indeks, T verdi) {
		nullSjekk(verdi);
		
		if(indeks == antall()-1 || antall() == 0){
			leggInn(verdi);
		
		}else{
		indeksKontroll(indeks);
		Node<T> node = new Node<T>(verdi, null,null);
		Node<T> current;
		if(indeks < antall()/2){
			current = hode;
			for(int i = 0; i <= indeks; i++){
				current = current.neste;
			}
			
		}else{
			current = hale;
			for(int i = antall()- 1; i >= indeks; i--){
				current = current.forrige;
			}
		}
		
		
		current.forrige.neste = node;
		node.neste = current;
		node.forrige = current.forrige;
		current.forrige = node;
		antall++;
		modAntall++;
		}
	}

	public boolean leggInn(T verdi) {
		nullSjekk(verdi);
		Node<T> node = new Node<T>(verdi, null, null);
		if (antall == 0) {
			hode = new Node<T>(null, null, node);
			hale = new Node<T>(null, node, null);
			node.forrige = hode;

		} else {
			node.forrige = hale.forrige;
			hale.forrige.neste = node;

		}
		node.neste = hale;
		hale.forrige = node;
		antall++;
		modAntall++;

		return true; // foreløpig kode
	}

	public T hent(int indeks) {
		indeksKontroll(indeks);

		return finnNode(indeks).verdi;
	}

	public int indeksTil(T verdi) {
		nullSjekk(verdi);
		Node<T> node = hode.neste;

		for (int i = 0; i < antall(); i++) {
			if (node.verdi.equals(verdi)) {
				return i;
			}
			node = node.neste;
		}
		return -1;
	}

	public T oppdater(int indeks, T nyverdi) {
		indeksKontroll(indeks);
		
		Node<T> node = finnNode(indeks);
		T temp = node.verdi;
		node.verdi = nyverdi;
		modAntall++;
		return temp;
	}

	public T fjern(int indeks) {
		indeksKontroll(indeks);
		Node<T> current;
		if(indeks < antall()/2){
			current = hode;
			for(int i = 0; i <= indeks; i++){
				current = current.neste;
			}
			
		}else{
			current = hale;
			for(int i = antall()- 1; i >= indeks; i--){
				current = current.forrige;
			}
		}
		
		Node<T> temp = current;
		
		current.forrige.neste = current.neste;
		current.neste.forrige = current.forrige;
		modAntall++;
		antall--;
		return temp.verdi;
	}

	public boolean fjern(T verdi) {
		nullSjekk(verdi);
		Node<T> current = hode; 
		
		for(int i = 0; i < antall(); i++){
			current = current.neste;
			
			if(current.verdi.equals(verdi)){
				current.forrige.neste = current.neste;
				current.neste.forrige = current.forrige;
				
				modAntall++;
				antall--;
				return true;
				
			}
		}		
		return false; // foreløpig kode
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		if (!tom()) {
			Node<T> node = hode.neste;
			for (int i = 0; i < antall(); i++) {
				sb.append(node.verdi);
				if (i + 1 < antall())
					sb.append(", ");
				node = node.neste;
			}
		}

		sb.append("]");

		return sb.toString(); // foreløpig kode
	}

	public String omvendtString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		if (!tom()) {
			Node<T> node = hale.forrige;
			for (int i = antall() - 1; i >= 0; i--) {
				sb.append(node.verdi);
				if (i > 0)
					sb.append(", ");
				node = node.forrige;
			}
		}

		sb.append("]");
		return sb.toString();
	}
	
	public Iterator<T> iterator() {
		return new DobbeltLenketListeIterator();
	}
	
	
	public Iterator<T> iterator(int indeks) {
		indeksKontroll(indeks);
		return new DobbeltLenketListeIterator(indeks); // foreløpig kode
	}

	private class DobbeltLenketListeIterator implements Iterator<T> {
		private Node<T> p;
		private boolean fjernOK;
		private int iteratorModAntall;

		private DobbeltLenketListeIterator() {
			p = hode; // p starter på den første i listen
			fjernOK = false; // blir sann når next() kalles
			iteratorModAntall = modAntall; // teller endringer
		}
		
		private DobbeltLenketListeIterator(int indeks){
			p = hode;
			for(int i = 0; i < indeks; i++ ){
				p = p.neste;
			}
			fjernOK = false; // blir sann når next() kalles
			iteratorModAntall = modAntall; // teller endringer
		}

		public boolean hasNext() {
			if(p.neste.verdi != null){
				return true;
			}
			
			return false; // foreløpig kode
		}

		public T next() {
			
			if(antall == 0 || p.neste.verdi == null ){
				throw new NoSuchElementException();
			}
			if(iteratorModAntall != modAntall){
				throw new ConcurrentModificationException();
			}
			
			fjernOK = true;
			p = p.neste;
			return p.verdi;
		}
		
	

		public void remove() {
			if(!fjernOK ){
				throw new IllegalStateException();
			}
			if(antall() == 1){
				hale = null;
				hode = null;
			}else if(p == null){
				hale.forrige = p.forrige;
				p.forrige = hale;
				
			}else if (p.forrige == hode){
				hode.neste = p.neste;
				p.neste = hode;
			}else{
				p.forrige.neste = p.neste;
				p.neste.forrige = p.forrige;
			}
			iteratorModAntall++;
			modAntall++;
			antall--;
		}
		
		

	} // class DobbeltLenketListeIterator
} // class DobbeltLenketListe