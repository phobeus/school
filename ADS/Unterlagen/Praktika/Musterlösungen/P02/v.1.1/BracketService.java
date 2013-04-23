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
 */

public class BracketService implements CommandExecuter {
	public String execute(String command) {
//		Stack<Character> s = new ArrayStack<Character>(command.length());
		Stack<Character> s = new ListStack<Character>();
		for (int i=0; i<command.length(); i++) {
			char c, c2;
			switch (c=command.charAt(i)) {
				case '(': case '{': case'[': s.push(c); break;
				case ')': case '}': case']':
					if (s.isEmpty())
						return "BracketService: '"+c+"' in position "+i
							+" is unmatched";
					c2=s.pop();
					if (!( c2=='(' && c==')'
						|| c2=='{' && c=='}'
						|| c2=='[' && c==']' ))
							return "BracketService: '"+c2+"' and '"+c
								+"' in position "+i+" do not match";
			}
		}
		if (s.isEmpty()) return "BracketService: brackets match ok";
		return "BracketService: "+s.size()+" left brackets unmatched";
	}
}
