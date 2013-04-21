package ducksort;

import java.util.Arrays;

public class TestDrive {

	public static void main(String[] arg) {

		// we program to interfaces, not to classes

		Duck d1 = new Duck("Ducky", 50, 33);
		Duck d2 = new Duck("Greenie", 44, 24);
		Duck d3 = new Duck("Tutsie", 1, 105);
		Duck d4 = new Duck("Lisie", 911, 87);
		Duck[] ducks = { d1, d2, d3, d4 };

		System.out.println("--- Original list of ducks:");
		display(ducks);

		Arrays.sort(ducks, new SortByNothing());
		System.out.println();
		System.out.println("--- List of ducks, sorted by default:");
		display(ducks);

		Arrays.sort(ducks, new SortByName());
		System.out.println();
		System.out.println("--- List of ducks sorted by name:");
		display(ducks);

		Arrays.sort(ducks, new SortBySize());
		System.out.println();
		System.out.println("--- List of ducks sorted by size:");
		display(ducks);
		
		Arrays.sort(ducks, new SortByWeight());
		System.out.println();
		System.out.println("--- List of ducks sorted by weight:");
		display(ducks);
		

	}

	public static void display(Duck[] ducks) {
		for (int i = 0; i < ducks.length; i++) {
			System.out.println(ducks[i]);
		}
	}

}