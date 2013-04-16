package ch.zhaw.ads.services;

import ch.zhaw.ads.CommandExecuter;

/**
 * Service which finds a number in a list of numbers. The numbers must be filled
 * in, from lowest to highest number, like this example: 1,2,3,4,5,6,7,8,9,10,3
 * The last number, is the number you're looking for. The Result is the position
 * of the number.
 * 
 * @author C.Brüesch
 * @version 1.0
 */

public class SearchNumber implements CommandExecuter {

	private int searchedNumber, max, min;
	private int[] numbers;
	private String result = null;
	private boolean numberFound = false;

	public String execute(String command) throws Exception {
		numberFound=false;
		if(!(command.contains("[1-9]*")||command.contains(","))) {
			throw new NumberFormatException("Wrong Format!");
		}
		
		/* Split the input up into an array of strings */
		String[] inputNumbers = command.split(",");
		numbers = new int[inputNumbers.length];

		/* Convert String of numbers in String of int */
		for (int i = 0; i < inputNumbers.length; i++) {
			numbers[i] = Integer.parseInt(inputNumbers[i]);
		}

		searchedNumber = numbers[(numbers.length) - 1];
		min=0;
		for(int i = 0; i<numbers.length; i++) {
			if(max<numbers[i]) {
				max = numbers[i];
			}
		}
		
		while (!numberFound) {
			numberFound = lookForNumber();
		}

		return result;
	}

	private boolean lookForNumber() {

		if (searchedNumber > (max + min) / 2) {
			min = (max + min) / 2 + 1;
		}

		else if (searchedNumber < (max + min) / 2) {
			max = (max + min) / 2;
		}

		else if (searchedNumber == (max + min) / 2) {
			for (int i = 0; i < numbers.length - 1; i++) {
				if (searchedNumber == numbers[i]) {
					result = "" + (i + 1);
					return true;
				}
			}
			result = "Zahl nicht vorhanden!";
			return true;
		}
		return false;
	}

}
