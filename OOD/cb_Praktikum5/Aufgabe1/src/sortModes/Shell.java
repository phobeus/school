package sortModes;

import interfaces.SortingModes;

public class Shell implements SortingModes {

	public void sort(double[] a, int low, int high) {
		
		int inner, outer;
		double temp;
		// find initial value of h
		int h = 1;
		while (h <= a.length / 3)
		h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
		while (h > 0) // decreasing h, until h=1
		{
		for (outer = h; outer < a.length; outer++) {
		temp = a[outer];
		inner = outer;
		while (inner > h - 1 && a[inner - h] >= temp) {
		a[inner] = a[inner - h];
		inner -= h;
		}
		a[inner] = temp;
		}
		h = (h - 1) / 3; // decrease h
		}
		
	}
}
