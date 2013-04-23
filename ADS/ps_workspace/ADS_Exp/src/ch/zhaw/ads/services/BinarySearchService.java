package ch.zhaw.ads.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch.zhaw.ads.CommandExecuter;

public class BinarySearchService implements CommandExecuter {

	private static final String RESULT_PREFIX = "Binary search: ";

	@Override
	public String execute(final String command) {
		List<String> list = new ArrayList<String>(Arrays.asList(command.split(",")));
		List<Integer> sortedIntList = new ArrayList<Integer>();
		for (int i = 0; i < list.size() - 1; i++) {
			sortedIntList.add(Integer.parseInt(list.get(i)));
		}
		int searchedValue = Integer.parseInt(list.get(list.size()-1));
		
		int result = binarySearch(sortedIntList, searchedValue, sortedIntList.size() / 2 - 1, 0, sortedIntList.size()-1);
		
		return RESULT_PREFIX + result;
	}

	private int binarySearch(List<Integer> sortedIntList, int searchedValue, int position, int min, int max) {
		int originalPosition = position;
		int originalMin = min;
		int originalMax = max;
		Integer valueAtPosition = sortedIntList.get(position);
		if(valueAtPosition == searchedValue)
		{
			return position;
		}
		
		if(valueAtPosition > searchedValue)
		{
			max = max - ((max-min) / 2);
		}
		else
		{
			min = position+1;
		}
		position = (min + max) / 2;
		
		if(position == originalPosition && min == originalMin && max == originalMax)
		{
			return -1;
		}
		
		return binarySearch(sortedIntList, searchedValue, position, min, max);
	}

}
