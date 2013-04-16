package ch.zhaw.ads;

/**
 * Interface which has to be implemented by the service classes.
 * 
 * @author E. Mumprecht
 * @version 1.0 -- Geruest fuer irgendeinen Server
 * @version 1.1 -- K. Rege Fehlerrueckgabe hinzugefuegt
 * @version 1.2 -- F.Uzdilli Renaming and Javadoc changes
 */
public interface CommandExecuter {

	/**
	 * Takes a command string, interpretes and executes it and returns the
	 * result.
	 * 
	 * @param command
	 *            command string
	 * @return result
	 */

	public String execute(String command) throws Exception;

}