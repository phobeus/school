package ch.zhaw.ads.services;

import ch.zhaw.ads.CommandExecuter;

/**
 * Primitive service which echoes the input command.
 * 
 * @author E. Mumprecht
 * @version 1.0 -- Geruest fuer irgendeinen Server
 * @version 1.1 F.Uzdilli -- Renaming and Javadoc changes
 */
public class EchoService implements CommandExecuter {

	private StringBuffer result;

	public String execute(String command) {
		result = new StringBuffer();
		result.append("Die Eingabe war: <");
		result.append(command);
		result.append(">");
		return (result.toString());
	}

}