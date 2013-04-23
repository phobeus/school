package ch.zhaw.ads.services;

import ch.zhaw.ads.*;

/**
 * @(#)WellFormedXMLService.java
 *
 * Service for Praktikum02: check text for matching XML tags
 *
 * @author	Arnold Aders
 * @version 1.00 20130321 -- basic functionality: find first mismatch
 */

public class WellFormedXMLService implements CommandExecuter {
	public String execute(String command) {
		Stack<String> s = new ListStack<String>();
		String tag[] = command.split("([^<>]*<)|(>[^<>]*<)|(>[^<>]*)");
		for (int i=0; i<tag.length; i++)
			if (tag[i].length()>0) {
				if (tag[i].charAt(0)!='/') s.push(tag[i]);
				else {
					if (s.isEmpty())
						return "WellFormedXMLService: \"<"+tag[i]
							+">\" in position "+i+" is unmatched";
					String otherTag=s.pop();
					if (!otherTag.equals(tag[i].substring(1)))
						return "WellFormedXMLService: \"<"+otherTag
							+">\" and \"<"+tag[i]+">\" in position "+i
							+" do not match";
				}
			}
		if (s.isEmpty()) return "WellFormedXMLService: XML tags match ok";
		return "WellFormedXMLService: "+s.size()+" opening tags unmatched";
	}
}
