package ducksort;

import java.util.Comparator;

public class SortByName implements Comparator {

	public int compare(Object f, Object s) {
		Duck o1 = (Duck) f;
		Duck o2 = (Duck) s;
		
		if (o1.getDuckName().compareTo(o2.getDuckName()) < 0)	return -1;
		if (o1.getDuckName().compareTo(o2.getDuckName()) > 0)	return 1;
		return 0;
	}

}