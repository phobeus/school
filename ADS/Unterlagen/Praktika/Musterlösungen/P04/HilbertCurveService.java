package ch.zhaw.ads.services;

import ch.zhaw.ads.*;

/** HilbertCurveService  --  Praktikum ADS
 *	zeichnet eine Hilbert-Kurve rekursiv mit Turtle Graphics
 *
 @author A. Aders
 @version 1.0	20130305	Umstellung auf Turtle Graphic von früheren Versionen
 */

public class HilbertCurveService implements CommandExecuter {
	Turtle turtle;
	double d;

	private void hilbertL (int level) {
		if (level > 0) {
			turtle.turn(-90);
			hilbertR(level-1);
			turtle.move(d);
			turtle.turn(+90);
			hilbertL(level-1);
			turtle.move(d);
			hilbertL(level-1);
			turtle.turn(+90);
			turtle.move(d);
			hilbertR(level-1);
			turtle.turn(-90);
		}
	}

	private void hilbertR (int level) {
		if (level > 0) {
			turtle.turn(+90);
			hilbertL(level-1);
			turtle.move(d);
			turtle.turn(-90);
			hilbertR(level-1);
			turtle.move(d);
			hilbertR(level-1);
			turtle.turn(-90);
			turtle.move(d);
			hilbertL(level-1);
			turtle.turn(+90);
		}
	}

	public String execute(String command) {
		int k = Integer.parseInt(command);
		d = 1;
		for (int i=0; i<k; i++) d *= 0.5;
		turtle = new Turtle ( 0.5*d, 0.5*d );
		hilbertR(k);	// Start der Rekursion
		return turtle.getTrace();
	}
}
