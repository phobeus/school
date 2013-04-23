package ch.zhaw.ads.services;

import ch.zhaw.ads.*;

/** SnowflakeServer  --  Praktikum ADS
 *	zeichnet Koch's fraktale Schneeflockenkurve rekursiv mit Turtle Graphics
 *
 @author K. Rege, A. Aders
 @version 1.0		20110315
 @version 1.01		20130305	Anpassung an refactored ExBox
 */

public class SnowflakeServer implements CommandExecuter {
	Turtle turtle;

	private void snowFlake (int level, double dist) {
		if (level <= 0) {
			turtle.move(dist);
		}
		else {	// recursion:
			dist/=3;
			level--;
			snowFlake(level,dist);
			turtle.turn(60);
			snowFlake(level,dist);
			turtle.turn(-120);
			snowFlake(level,dist);
			turtle.turn(60);
			snowFlake(level,dist);
		}
	}

	public String execute(String command) {
		turtle = new Turtle ( 0.1, 0.7 );
		int k = Integer.parseInt(command);
		snowFlake ( k, 0.8 );
		turtle.turn(-120);
		snowFlake ( k, 0.8 );
		turtle.turn(-120);
		snowFlake ( k, 0.8 );
		return turtle.getTrace();
	}
}
