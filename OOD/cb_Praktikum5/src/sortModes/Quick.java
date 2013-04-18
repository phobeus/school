package sortModes;

import interfaces.SortingModes;

public class Quick implements SortingModes {

	public void sort(double[] a, int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		double pivot = a[(low+high)/2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (a[i] < pivot) i++;
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (a[j] > pivot) j--;

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			sort(a, low, j);
		if (i < high)
			sort(a, i, high);
		
	}
	
	private void swap(double[] a, int i, int j) {
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
