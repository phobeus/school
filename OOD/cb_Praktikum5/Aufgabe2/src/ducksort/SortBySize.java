package ducksort;

import java.util.Comparator;

public class SortBySize implements Comparator {

	public int compare(Object f, Object s) {
		Duck o1 = (Duck) f;
		Duck o2 = (Duck) s;
		
		if (o1.getDuckSize() < o2.getDuckSize())	return -1;
		if (o1.getDuckSize() == o2.getDuckSize())	return 0;
		return 1;
	}

}