/**
 * @(#)TestXHochK.java
 *
 * TestXHochK -- Beispiel für Invariante
 *
 * @author Arnold Aders
 * @version 1.00 20110426
 */

public class TestXHochK {
	public static void main(String[] args) {
		double x=1.25;
	//	double x=1.1;
		int kmax=100;
		for (int k=0; k<=kmax; k++) {
			if (xHochK1(x,k)!=xHochK2(x,k)) {
				double x1=xHochK1(x,k), x2=xHochK2(x,k);
				System.out.println(""+k+": "+(x1-x2)/x2); // rel.Fehler
			}
		}
		System.out.println("x^k verglichen für k von 0 bis "+kmax);
	}

	private static double xHochK1 (double x, int k) {
		double r=1;
		while (k>0) {	// Invariante  x^k * r == c
			r = r*x;
			k--;
		}
		return r;
	}

	private static double xHochK2 (double x, int k) {
		double r=1;
		int j=1;	// j=2^m; m=0;
		while (j<=k) j=2*j; // m++;
		// j ist die kleinste 2er-Potenz >k
		while (j>1) {	// Invariante r==x^(k/j)
			r = r*r;
			j = j/2;
			if ((k&j)>0) r = r*x;
		}
		return r;
	}
}
