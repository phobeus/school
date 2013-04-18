package sortModes;

import interfaces.SortingModes;

public class Bubble implements SortingModes{

	public void sort(double[] a, int low, int high) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (a[i] < a[j]) {
					swap(a, i, j);
				}
			}
		}
		
	}
	
	private void swap(double[] a, int i, int j) {
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


}
