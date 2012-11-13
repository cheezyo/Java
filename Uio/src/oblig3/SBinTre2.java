package oblig3;

import java.util.*;

public class SBinTre2<T> implements Beholder<T> {
	private static final class Node<T> // en indre nodeklasse
	{
		private T verdi; // nodens verdi
		private Node<T> venstre, høyre; // venstre og høyre barn

		private Node(T verdi, Node<T> v, Node<T> h) // konstruktør
		{
			this.verdi = verdi;
			venstre = v;
			høyre = h;
		}

		private Node(T verdi) // konstruktør
		{
			this(verdi, null, null);
		}

		public String toString() {
			return "" + verdi;
		}

	} // class Node

	private Node<T> rot; // peker til rotnoden
	private int antall; // antall noder
	private int endringer;
	private final Comparator<? super T> comp; // komparator

	public SBinTre2(Comparator<? super T> c) // konstruktør
	{
		rot = null;
		antall = 0;
		endringer = 0;
		comp = c;
	}

	public int antall() // antall verdier i treet
	{
		return antall;
	}

	public boolean tom() // er treet tomt?
	{
		return antall == 0;
	}

	public void nullstill() {
		rot = null;
		antall = 0;
	}

	public boolean leggInn(T verdi) // skal ligge i class SBinTre
	{
		if (verdi == null)
			throw new NullPointerException("Ulovlig nullverdi!");

		Node<T> p = rot, q = null; // p starter i roten
		int cmp = 0; // hjelpevariabel

		while (p != null) // fortsetter til p er ute av treet
		{
			q = p; // q forelder til p
			cmp = comp.compare(verdi, p.verdi); // bruker komparatoren
			p = cmp < 0 ? p.venstre : p.høyre; // flytter p
		}

		p = new Node<>(verdi); // oppretter en ny node

		if (q == null)
			rot = p; // rotnoden
		else if (cmp < 0)
			q.venstre = p; // til venstre for q
		else
			q.høyre = p; // til høyre for q

		endringer++;
		antall++; // én verdi mer i treet

		return true;
	}

	public boolean inneholder(T verdi) // skal ligge i klassen SBinTre
	{
		Node<T> p = rot; // starter i roten
		while (p != null) // sjekker p
		{
			int cmp = comp.compare(verdi, p.verdi); // sammenligner
			if (cmp < 0)
				p = p.venstre; // går til venstre
			else if (cmp > 0)
				p = p.høyre; // går til høyre
			else
				return true; // cmp == 0, funnet
		}
		return false; // ikke funnet
	}

	public boolean fjern(T verdi) // hører til klassen SBinTre
	{
		Node<T> p = rot, q = null; // q skal være forelder til p

		while (p != null) // leter etter verdi
		{
			int cmp = comp.compare(verdi, p.verdi); // sammenligner
			if (cmp < 0) {
				q = p;
				p = p.venstre;
			} // går til venstre
			else if (cmp > 0) {
				q = p;
				p = p.høyre;
			} // går til høyre
			else
				break; // den søkte verdien ligger i p
		}
		if (p == null)
			return false; // finner ikke verdi

		if (p.venstre == null || p.høyre == null) // Tilfelle 1) og 2)
		{
			Node<T> b = p.venstre != null ? p.venstre : p.høyre; // b for barn
			if (p == rot)
				rot = b;
			else if (p == q.venstre)
				q.venstre = b;
			else
				q.høyre = b;
		} else // Tilfelle 3)
		{
			Node<T> s = p, r = p.høyre; // finner neste i inorden
			while (r.venstre != null) {
				s = r; // s er forelder til r
				r = r.venstre;
			}

			p.verdi = r.verdi; // kopierer verdien i r til p

			if (s != p)
				s.venstre = r.høyre;
			else
				s.høyre = r.høyre;
		}

		endringer++;
		antall--; // det er nå én node mindre i treet
		return true;
	}

	private class InordenIterator implements Iterator<T> {
		private Stakk<Node<T>> s = new TabellStakk<>(); // for traversering
		private Node<T> p = null; // nodepeker
		private int iteratorendringer; // iteratorendringer

		private Node<T> først(Node<T> q) // en hjelpemetode
		{
			while (q.venstre != null) // starter i q
			{
				s.leggInn(q); // legger q på stakken
				q = q.venstre; // går videre mot venstre
			}
			return q; // q er lengst ned til venstre
		}

		public InordenIterator() // konstruktør
		{
			if (rot == null)
				return; // treet er tomt
			p = først(rot); // bruker hjelpemetoden
			iteratorendringer = endringer; // setter treets endringer
		}

		public T next() {
			if (iteratorendringer != endringer)
				throw new ConcurrentModificationException();

			if (!hasNext())
				throw new NoSuchElementException();

			T verdi = p.verdi; // tar vare på verdien i noden p

			if (p.høyre != null)
				p = først(p.høyre); // p har høyre subtre
			else if (!s.tom())
				p = s.taUt(); // p har ikke høyre subtre
			else
				p = null; // stakken er tom

			return verdi; // returnerer verdien
		}

		public boolean hasNext() {
			return p != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<T> iterator() {
		return new InordenIterator();
	}

	public String toString() {
		StringBuilder s = new StringBuilder(); // StringBuilder
		s.append('['); // starter med [
		if (!tom())
			toString(rot, s); // den rekursive metoden
		s.append(']'); // avslutter med ]
		return s.toString(); // returnerer
	}

	private static <T> void toString(Node<T> p, StringBuilder s) {
		if (p.venstre != null) // p har et venstre subtre
		{
			toString(p.venstre, s); // komma og mellomrom etter
			s.append(',').append(' '); // den siste i det venstre
		} // subtreet til p

		s.append(p.verdi); // verdien i p

		if (p.høyre != null) // p har et høyre subtre
		{
			s.append(',').append(' '); // komma og mellomrom etter
			toString(p.høyre, s); // p siden p ikke er den
		} // siste noden i inorden
	}

	public int antall(T verdi) {
		Node<T> p = rot; // starter i roten
		int antallFunn = 0;
		int cmp;
		while (p != null) // sjekker p
		{
			cmp = comp.compare(verdi, p.verdi); // sammenligner
			if (cmp < 0)
				p = p.venstre; // går til venstre
			else if (cmp > 0)
				p = p.høyre; // går til høyre
			else{
				antallFunn++;// cmp == 0, funnet
				p = p.høyre;
			}
		}
		
		return antallFunn; // foreløpig kode
	}

	public T nestMinst() {
		Node<T> p = rot;
		Node<T>temp = null; 
		//int cmp
		boolean run = true;
		while(run){
			
			if(p.venstre != null){
			temp = p;
			p = p.venstre;
			}else if(p.høyre != null && p.høyre.venstre != null){
				
				p = p.høyre;
			}else{
				return temp.verdi;
			}
			
		}
		
		
		
		return temp.verdi; // foreløpig kode
	}

	public T maksFjern() {
		return null; // foreløpig kode
	}

	public String høyreGren() {
		return null; // foreløpig kode
	}

	public String omvendtString() {
		return null; // foreløpig kode
	}

	public String[] grener() {
		return null; // foreløpig kode
	}

	private class BladnodeIterator implements Iterator<T> {
		// Instansvariabler, konstruktør og eventuelle
		// hjelpemetoder skal inn her

		public boolean hasNext() {
			return false; // foreløpig kode
		}

		public T next() {
			return null; // foreløpig koden
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	} // BladnodeIterator

	public Iterator<T> bladnodeiterator() {
		return new BladnodeIterator();
	}

} // SBinTre2