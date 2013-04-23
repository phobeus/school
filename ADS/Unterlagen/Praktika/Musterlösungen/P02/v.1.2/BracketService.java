package ch.zhaw.ads.services;

import ch.zhaw.ads.*;

/**
 * @(#)BracketService.java
 *
 * Service for Praktikum02: check String for matching brackets
 *
 * @author	Arnold Aders
 * @version 1.00 20130226 -- basic functionality: find first mismatch
 * @version 1.10 20130314 -- use ListStack instead of ArrayStack
 * @version 1.20 20130320 -- String constants
 */

public class BracketService implements CommandExecuter {

	private static final String OPEN_BRACKET  = "([{";
	private static final String CLOSE_BRACKET = ")]}";

	public String execute(String command) {
//		Stack<Character> s = new ArrayStack<Character>(command.length());
		Stack<Character> s = new ListStack<Character>();
		for (int i=0; i<command.length(); i++) {
			char c, c2;
			int j;
			c=command.charAt(i);
			if (OPEN_BRACKET.indexOf(c)>=0) s.push(c);
			else if ((j=CLOSE_BRACKET.indexOf(c))>=0) {
				if (s.isEmpty())
					return "BracketService: '"+c+"' in position "+i
						+" is unmatched";
				c2=s.pop();
				if (j!=OPEN_BRACKET.indexOf(c2))
					return "BracketService: '"+c2+"' and '"+c
						+"' in position "+i+" do not match";
			}
		}
		if (s.isEmpty()) return "BracketService: brackets match ok";
		return "BracketService: "+s.size()+" left brackets unmatched";
	}
}
