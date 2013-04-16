package ch.zhaw.ads.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple service for sorting integers with built-in Java features. Command
 * should contain comma separated numbers. i.e.: <br>
 * <code>3,63,74,23,47,843,54,2</code>
 * 
 * @author F.Uzdilli
 * 
 */
public class BuiltInJavaSort extends EchoService {

	private static final String RESULT_PREFIX = "Sorted List: ";

	@Override
	public String execute(final String command) {
		List<String> list = new ArrayList<String>(Arrays.asList(command.split(",")));
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				try {
					return Integer.parseInt(o1) - Integer.parseInt(o2);
				} catch (NumberFormatException e) {
					throw new RuntimeException("Input not valid:" + command);
				}
			}
		});
		return RESULT_PREFIX + list.toString();
	}
}
