package ch.zhaw.ads;

/**
 * @(#)THanoi.java
 *
 * Modell für die Türme von Hanoi
 * Züge werden gezählt und in einem Trace protokolliert
 * class THanoiException extends RuntimeException
 *
 * @author	Arnold Aders
 * @version 1.00 20130228
 */

public class THanoi {
	private int N;		// Anzahl Scheiben und Anzahl Plätze pro Turm
	private int zug;
	private int[][] turm;
	private int[]   hoehe;
	private StringBuilder trace;

	public THanoi(int n) {
	//	am Anfang liegen alle n Scheiben auf turm[0]:
		N = n;
		zug = 0;
		trace = new StringBuilder();
		int i=0;
		turm  = new int[3][n];
		hoehe = new int[3];
		hoehe[0] = n;
		for (int j=0; j<n; j++) turm[0][j]=n-j;
		for (i=1; i<3; i++) {
			hoehe[i] = 0;
			for (int j=0; j<n; j++) turm[i][j]=0;
		}
	}

	public void verschiebe (int k, int von, int nach, int ueber) {
	//	verschiebe k Scheiben von Turm von nach Turm nach über Turm ueber
		if (k>0) {
			verschiebe ( k-1, von, ueber, nach );	// Rekursion!
			verschiebe1 ( von, nach );
			verschiebe ( k-1, ueber, nach, von );	// Rekursion!
		}
	}

	public void verschiebe1 (int von, int nach) {
	//	verschiebe eine Scheibe von Turm von nach Turm nach
		zug++;
		if (hoehe[von]<=0) throw new THanoiException( "THanoi.verschiebe1("
			+von+","+nach+"); hoehe("+von+")=="+hoehe[von]+" (Zug "+zug+")" );
		if (hoehe[nach]>=N) throw new THanoiException( "THanoi.verschiebe1("
			+von+","+nach+"); hoehe("+nach+")=="+hoehe[nach]+" (Zug "+zug+")" );
		if (hoehe[nach]>0 && turm[von][hoehe[von]-1] > turm[nach][hoehe[nach]-1])
			throw new THanoiException( "THanoi.verschiebe1("
				+von+","+nach+"); Scheibe "+turm[von][hoehe[von]-1]
				+" kommt auf "+turm[nach][hoehe[nach]-1]+" (Zug "+zug+")" );
		// Zug ausführen:
		turm[nach][hoehe[nach]++] = turm[von][--hoehe[von]];
		turm[von][hoehe[von]] = 0;

		trace.append("\nZug "+zug+":\n");
		trace.append(toString());
	}

	public String toString() {
	//	aktuelle Stellung als (mehrzeiliger) String
		StringBuilder sb = new StringBuilder();
		int maxHoehe=0;
		for (int i=0; i<3; i++) if (hoehe[i]>maxHoehe) maxHoehe=hoehe[i];
		for (int j=maxHoehe-1; j>=0; j--) {
			for (int k=0; k<3; k++) {
				sb.append("\t");
				if (turm[k][j]>0) sb.append(""+turm[k][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public String getTrace() { return trace.toString(); }
}

class THanoiException extends RuntimeException {
	public THanoiException() { }
	public THanoiException(String msg) { super(msg); }
}
