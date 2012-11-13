package oblig1;

public class Oppgaver {

	public static void main(String[] args) {
		// OPPGAVE 1
		System.out.println("**** OPPGAVE 1 ******");
		int[] a = { 100000, 9, 8, 12, 60, 32, 4, 3, 1001, 1000 };
		int[] a1 = maks(a);
		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
		System.out.println("***** OPPGAVE 1 SLUTT ******");
		// OPPGAVE 1 SLAUTT

		// OPPGAVE 3
		System.out.println("***** OPPGAVE 3 ******");
		int[] a2 = { 1, 2, 3, 3, 3, 4, 5, 5, 5, 7 };
		System.out.println(antallUlikeSortert(a2));
		System.out.println("***** OPPGAVE 3 SLUTT ******");
		// SLUTT OPPGAVE 3

		// OPPGAVE 4
		System.out.println("***** OPPGAVE 4 ******");
		int[] a3 = { 5, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
				5, 4, 2, 4, 9 };
		System.out.println(antallUlikeUSortert(a3));
		System.out.println("***** OPPGAVE 4 SLUTT ******");
		// SLUTT OPPGAVE 4

		// OPPGAVE 5
		System.out.println("***** OPPGAVE 5 ******");
		int[] a4 = { 1, 10, 2, 12, 200, 100, 4 };
		tmaks(a4);

		System.out.println("\n***** OPPGAVE 5 SLUTT ******");
		// SLUTT OPPGAVE 5

		// OPPGAVE 6
		System.out.println("***** OPPGAVE 6 ******");
		int[] a5 = { 1, 10, 2, 12, 200, 100, 4 };
		print(sorterIndex(a5));
		System.out.println();
		print(a5);

		System.out.println("\n***** OPPGAVE 6 SLUTT ******");

		// SLUTT OPPGAVE6

		// OPPGAVE 7
		System.out.println("***** OPPGAVE 7******");
		int[] a6 = { 1000, 500, 2, 12, 200, 100, 4 };
		int[] a7 = { 5 };
		int[] a8 = {};
		System.out.println(toString(a6, '[', ']', ", "));
		System.out.println(toString(a6, '<', '>', " - "));
		System.out.println(toString(a6, ' ', ' ', " + "));
		System.out.println(toString(a7, '*', '*', " "));
		System.out.println(toString(a8, '[', ']', ","));
		System.out.println("\n***** OPPGAVE7 SLUTT ******");

		// SLUTT OPPGAVE7

		// OPPGAVE 8
		System.out.println("***** OPPGAVE 8 ******");
		int[] a9 = { 100000, 6000, 2, 12, 200, 100, 4 };
		print(tredjeMaks(a9));

		System.out.println("\n***** OPPGAVE 8 SLUTT ******");

		// SLUTT OPPGAVE8

		// OPPGAVE 9
		System.out.println("***** OPPGAVE 9 ******");
		int[] a10 = { 1000, 600000, 2, 1552, 200, 100, 400 };
		print(a10);
		System.out.println();
		print(kmaks(a10, 3));
		

		System.out.println("\n***** OPPGAVE 9 SLUTT ******");

		// SLUTT OPPGAVE9
	}

	public static int[] tmaks(int[] a) {

		int rounds = (int) Math.ceil(Math.log(a.length) / Math.log(2));

		int half = a.length / 2;
		int length = a.length;

		for (int j = 0; j < rounds; j++) {
			if (half % 2 != 0) {

				half += 1;

			}
			if (length == 2 && a[0] < a[1]) {
				int t = a[0];
				a[0] = a[1];
				a[1] = t;
			} else {

				for (int i = 0; i < half; i++) {

					if (a[i] < a[length - i - 1]) {

						int temp = a[i];
						a[i] = a[length - i - 1];
						a[length - i - 1] = temp;
					}

				}
			}
			length = half;
			half = half / 2;

		}
		return a;
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}

	// OPPGAVE 1 OG 2 SJØNNER IKKE FORSKJELL
	public static int[] maks(int[] a) {

		if (a.length != 0 && a.length != 1) {

			for (int i = 0; i < a.length; i++) {

				int counter = i;
				counter++;

				if (counter != a.length) {

					if (a[i] > a[counter]) {
						int temp = a[i];
						a[i] = a[counter];
						a[counter] = temp;

						maks(a);
					}

				}
			}

		}
		return a;
	}

	// OPPGAVE 3
	public static int antallUlikeSortert(int[] a) {
		// Samme sak som den forigje oppgave om sjekker bare om den er sortert
		// hvis ikke blir det exception
		for (int i = 0; i < a.length; i++) {
			if (i + 1 != a.length && a[i] > a[i + 1]) {
				throw new IllegalStateException("Ikke sortert riktig");
			}
		}
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				total++;

			} else if (a[i] != a[i - 1]) {
				total++;
			}
		}
		return total;
	}

	// OPPGAVE 3
	public static int antallUlikeUSortert(int[] a) {

		int total = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				total++;

			} else if (a[i] != a[i - 1]) {
				boolean equals = false;

				for (int j = 0; j < i; j++) {
					if (a[i] == a[j]) {
						equals = true;
						break;
					}
				}
				if (!equals) {
					total++;
				}
			}
		}
		return total;
	}

	public static int[] kmaks(int[] a, int k) {
		int[] temp = new int[k];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = a[i];
		}

		int[] index = sorterIndex(temp);
		System.out.println();
		print(temp);
		System.out.println();
		for (int i = k-1; i < a.length; i++) {

			for (int j = 0; j < temp.length; j++) {

				if (a[i] > temp[j]) {
					int m = j;
					int iTemp = i;
					while (m != temp.length) {
						int tTemp = index[m];
						index[m] = iTemp;
						
						iTemp = tTemp;

						m++;

					}
					

				}
			}
		}

		return index;
	}

	public static int[] tredjeMaks(int[] a) {
		int[] temp = { 0, 0, 0 };

		/*
		 * for (int i = 0; i < a.length; i++){ if(a[i]> temp[0]){ temp[2] =
		 * temp[1]; temp[1] = temp[0]; temp[0] = a[i]; }else if (a[i]> temp[1]){
		 * temp[2] = temp[1]; temp[1] = a[i]; }else if(a[i]> temp[2]){ temp[2] =
		 * a[i]; } }
		 */

		return temp;
	}

	public static String toString(int[] a, char v, char h, String mellomrom) {

		StringBuilder sb = new StringBuilder();
		sb.append(v);
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);

			if (i != a.length - 1 && a.length != 1)
				sb.append(mellomrom);

		}
		sb.append(h);

		return sb.toString();

	}

	public static int[] sorterIndex(int[] a) {
		int[] index = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			index[i] = i;
		}
		for (int k = 1; k < a.length; k++) {

			for (int i = 0; i < a.length - k; i++) {

				if (a[i] < a[i + 1]) {

					int temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;

					int tempIndex = index[i + 1];
					index[i + 1] = index[i];
					index[i] = tempIndex;

				}
			}
		}

		return index;
	}

}
