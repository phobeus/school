package ch.zhaw.ads.services;


/** Turtle Grahics (Schildkr�tengrahik)
 *	f�r Experimentierkasten f�r Praktikum ADS
 *	20071114
 @author K. Rege, A. Aders
 @version 1.0
 */

public class Turtle {

	private StringBuilder b;
	private double x, y, angle;

	public Turtle() { this(0,0); }
	public Turtle(double x, double y) { reset(x,y); }

	public void reset(double x, double y) {
		b = new StringBuilder();
		this.x = x;
		this.y = y;
		angle = 0;
	}

	private double round(double d) { return Math.round(d*10000)/10000.0; }

	public void move(double dist) {
		b.append("<line x1=\"");
		b.append(Double.toString(round(x))+"\" y1=\"");
		b.append(Double.toString(round(y))+"\" ");
		x += Math.cos(angle)*dist;
		y += Math.sin(angle)*dist;
		b.append("x2=\"");
		b.append(Double.toString(round(x))+"\" y2=\"");
		b.append(Double.toString(round(y))+"\"/>\n");
	}

	public void turn(double turnAngle) { angle += turnAngle*Math.PI/180; }

	public String getTrace() { return b.toString(); }
}
