package logic;

public class BruteForceSolver {
	private static boolean foundSolution;
	
	public static boolean versuchen(bla k) {
		if (foundSolution) return true;
		else {
			if(paaaaasst(k))
			{
				fuegeZuLoesungHinzu(l);
			}
			for(bla l in ErweiterungVonTeilloesungen(k)) { // Zahlen von 1 - 9
				if (moeglicheErweiterung(l)) { // Check if the value of l is already in a spot (in the 3*9 possible spots)
					fuegeZuLoesungHinzu(l); // If so, add it to the stack
					bla newBla = CalculateNextAvailableBla(bla); // Get the next field to validate (if none is found, set foundsolution to true and return true if no more are available)
					boolean versuch = versuchen(newBla); // try harder!
					if(versuch) return true;
					nehmeVonLoesungWeg(l); // Remove from stack
				}
			}
		return false;
		}
	}
	
	List<bla> ErweiterungVonTeilloesungen;
}
