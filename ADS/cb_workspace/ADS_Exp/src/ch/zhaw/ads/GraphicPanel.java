package ch.zhaw.ads;

/** GraphicPanel f�r Experimentierkasten f�r Praktikum ADS
 *	20071114
 @author K. Rege, A. Aders
 @version 1.0
 @version 1.01		20130305	Anpassung an refactored ExBox
 */

import java.awt.*;
import java.util.StringTokenizer;

public class GraphicPanel extends Panel {

	private String figure;

	public void setFigure(String figure) {
		this.figure = figure;
		paint(getGraphics());
	}

	private void drawFigure(Graphics g) {
		if (figure != null) {
			int w = getWidth();
			int h = getHeight();
			g.setColor(Color.black);
			StringTokenizer tok = new StringTokenizer(figure," <>=/,\"\n");
			while (tok.hasMoreTokens()) {
				tok.nextToken();
				tok.nextToken();
				double x1 = Double.parseDouble(tok.nextToken());
				tok.nextToken();
				double y1 = Double.parseDouble(tok.nextToken());
				tok.nextToken();
				double x2 = Double.parseDouble(tok.nextToken());
				tok.nextToken();
				double y2 = Double.parseDouble(tok.nextToken());
				g.drawLine ( (int)(x1*w), h-(int)(y1*h),
					(int)(x2*w), h-(int)(y2*h) );
			}
		}
	}

	private void clear(Graphics g) {
		g.setColor ( Color.lightGray );
		g.fillRect ( 0, 0, getWidth(), getHeight() );
	}

	public void paint(Graphics g) {
		clear(g);
		drawFigure(g);
	}
}
