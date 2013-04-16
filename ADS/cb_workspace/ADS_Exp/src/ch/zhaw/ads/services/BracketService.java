package ch.zhaw.ads.services;

import ch.zhaw.ads.CommandExecuter;
import ch.zhaw.ads.helpClasses.ImplStack;
import ch.zhaw.ads.interfaces.*;

public class BracketService implements CommandExecuter {
	private String openingBrackets = "([{";
	private String closingBrackets = ")]}";
	private String[] nextClosing = new String[100];
	private int closingCounter = 0;
	
	public String execute(String command) throws Exception {
		Stack<String> bracket = new ImplStack<String>();
		
		
		for(int i = 0; i<command.length(); i++) {
			String substring = command.substring(i,i+1);
			if (openingBrackets.contains(substring)) {
				bracket.push(substring);
				if(substring.contains("(")) {
					nextClosing[closingCounter] = ")";
					closingCounter++;
				}
				else if(substring.contains("[")) {
					nextClosing[closingCounter] = "]";
					closingCounter++;
				}
				else if(substring.contains("{")) {
					nextClosing[closingCounter] = "}";
					closingCounter++;
				}
				
			}
			else if (closingBrackets.contains(substring)) {
				if(nextClosing[closingCounter-1]!=null) {
					if (substring.contains(nextClosing[closingCounter-1])) {
						bracket.pop();
						closingCounter--;
					}
					else {
						throw new Exception("Falsche Klammer! Position:"+i);
					}
				}
			}
		}
		
		if(bracket.isEmpty()) {
			return "Wuhu";
		}
		else {
			throw new Exception("Klammeranzahl ist fehlerhaft");
		}
	}
	
}