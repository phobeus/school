package ch.zhaw.ads.services;

import ch.zhaw.ads.*;

/**
 * @(#)THanoiService.java
 *
 * Service for Praktikum03: towers of Hanoi
 *
 * @author	Arnold Aders
 * @version 1.00 20130228 -- basic functionality
 */

public class THanoiService implements CommandExecuter {
	public String execute(String command) {
		int n = Integer.parseInt(command.trim());
		THanoi th = new THanoi(n);
		StringBuilder sb = new StringBuilder(th.toString());	// Anfangsstellung
		th.verschiebe ( n, 0, 1, 2 );	// Rekursion starten
		return sb.append(th.getTrace()).toString();
	}
}
