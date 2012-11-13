package oblig1;

public class sort {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 6, 8, 7, 2, -3, 4, 16, 14 };
		sort(numbers);
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + " ");
	}

	public static void fitte(int[] a) {
		int temp = 0;

		for (int j = a.length; j > 1; j--) {

			for (int i = 1; i < j; i++) {
				if (a[i - 1] < a[i]) {
					temp = a[i - 1];
					a[i - 1] = a[i];
					a[i] = temp;
				}
			}
		}
		// return a;
	}

	public static void sort(int[] list) {
		boolean nextPass = true;

		for (int k = 1; k < list.length; k++) {

			for (int i = 0; i < list.length - k; i++) {

				if (list[i] > list[i + 1]) {

					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;

				}
			}
		}
	}
}
