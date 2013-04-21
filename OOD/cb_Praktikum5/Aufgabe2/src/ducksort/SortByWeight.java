package ducksort;

import java.util.Comparator;

public class SortByWeight implements Comparator {

	public int compare(Object f, Object s) {
		Duck o1 = (Duck) f;
		Duck o2 = (Duck) s;
		
		if (o1.getDuckWeight() < o2.getDuckWeight())	return -1;
		if (o1.getDuckWeight() == o2.getDuckWeight())	return 0;
		return 1;
	}

}