package ch.zhaw.ads.services;

import ch.zhaw.ads.*;

/** HilbertCurveService  --  Praktikum ADS
 *	zeichnet eine Hilbert-Kurve rekursiv mit Turtle Graphics
 *
 @author A. Aders
 @version 1.0	20130305	Umstellung auf Turtle Graphic von früheren Versionen
 @version 1.1	20130305	Zusammenfassung der zwei Methoden mit zusätzlichem Parameter
 */

public class HilbertCurveService implements CommandExecuter {
	Turtle turtle;
	double d;

	private void hilbert (int level, int orientierung) {
	// orientierung muss +1 (für rechts) oder -1 (für links) sein
		if (level > 0) {
			turtle.turn ( 90*orientierung );
			hilbert ( level-1, -orientierung );
			turtle.move ( d );
			turtle.turn ( -90*orientierung );
			hilbert ( level-1, orientierung );
			turtle.move ( d );
			hilbert ( level-1, orientierung );
			turtle.turn ( -90*orientierung );
			turtle.move ( d );
			hilbert ( level-1, -orientierung );
			turtle.turn ( 90*orientierung );
		}
	}

	public String execute(String command) {
		int k = Integer.parseInt(command);
		d = 1;
		for (int i=0; i<k; i++) d *= 0.5;
		turtle = new Turtle ( 0.5*d, 0.5*d );
		hilbert ( k, +1 );	// Start der Rekursion
		return turtle.getTrace();
	}
}
