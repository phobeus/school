/**
 * @(#)TestHash13.java
 *
 * Applet TestHash13
 *
 * class MyHash -- einfache Hashtable für Strings ohne Löschen und Rehash
 *
 * ADS-SEP FS2011 20110624 -- Aufg. 4 -- Musterlösung
 *
 * Die *Implementation* insbesondere des Probing muss für die Demo *flexibel*
 * sein, sie ist daher überhaupt *nicht* *effizient*!
 *
 * @author Arnold Aders
 * @version 2.01 20110626 -- mit linear, quadratic und mod.quadr. Probing
 * @version 2.11 20110626 -- mit secondary hash
 * @version 2.20 20110627 -- mit pseudozufälligem Probing
 * @version 2.32 20110630 -- *ein* Universal-ActionListener für alle Buttons
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;

public class TestHash13 extends Applet {
	private TextArea taEin, taAus;
	private TextField tf;

	public void init() {
		taEin = new TextArea ( 15, 60 );
		add(taEin);
		Panel p1 = new Panel();
		add(p1);
		p1.add(new Label("Grösse der HashTable:"));
		tf = new TextField ( "13", 3 );
		p1.add(tf);
		Panel p2 = new Panel();
		add(p2);
		p2.add(new Label("Probing:"));
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Probing p = Probing.valueOf ( e.getActionCommand() );
				int N = Integer.parseInt(tf.getText().trim());
				MyHash mh = new MyHash ( N, p );
				String[] zeile = taEin.getText().split("\n");
				try { for (String s : zeile) mh.add(s); }
				catch (RuntimeException r) { r.printStackTrace(); }
				finally { taAus.setText(mh.toString()); }
			}
		};
		for (Probing p: Probing.values()) {
			Button b = new Button(p.name());
			p2.add(b);
			b.addActionListener(al);
		}
		taAus = new TextArea ( 22, 60 );
		taAus.setEditable(false);
		add(taAus);
		add(new Label("TestHash13     v.2.32     20110630     Arnold Aders"));
		setSize ( 530, 705 );

	// Beispiel:
	//		Da stimmt irgendetwas mit den Zeichen (CR/LF ?)
	//		und dem String.split(...) noch nicht ganz!!
//		StringBuilder sb = new StringBuilder();
//		String[] zeile = { "Zürich", "Genf", "Basel", "Bern", "Lausanne",
//			"Winterthur", "St. Gallen", "Luzern", "Lugano", "Biel" };
//		for (int i=0; i<zeile.length; i++) sb.append(zeile[i]+'\n');
//		taEin.setText(sb.toString());
	}
}

enum Probing { LINEAR, QUADRATIC, MOD_QUADR, SEC_HASH, PSEUDO_RANDOM }

class MyHash {
	//	einfache Hashtable für Strings ohne Löschen und Rehash
	//	RuntimeException bei Überlauf oder unauflösbarer Kollision
	private interface Prober { public int probe(int i, String key); }

	private final int N;
	private String[] h;
	private int size;
	private Probing probingMode;
	private Prober p;
	private Random rg;

	public MyHash(final int N, Probing probingMode) {
		this.N = N;
		h = new String[N];
		size = 0;
		this.probingMode = probingMode;
		switch (probingMode) {
			case LINEAR:
				p = new Prober() {
					public int probe(int i, String key) { return i; }
				};
				break;
			case QUADRATIC:
				p = new Prober() {
					public int probe(int i, String key) { return i*i; }
				};
				break;
			case MOD_QUADR:
				p = new Prober() {
					public int probe(int i, String key) { return i*(i+1)/2; }
				};
				break;
			case SEC_HASH:
				p = new Prober() {
					public int probe(int i, String key) { return i*hash2(key); }
				};
				break;
			case PSEUDO_RANDOM:
				rg = new Random();
				p = new Prober() {
					public int probe(int i, String key) {
						if (i<1) return 0;
						int res=0;
						rg.setSeed(key.hashCode());
						for (int j=0; j<i; j++) res = rg.nextInt(N);
						return res;
					}
				};
		}
	}

	public MyHash(int N) { this ( N, Probing.QUADRATIC ); }

	public int hash(String s) { return (s.hashCode()%N+N)%N; }

	public int hash2(String s) {
		int res = 0;
		for (int i=0; i<s.length(); i++)
			res = res*127+(int)s.charAt(i);
		int n2 = N-2;
		return (res%n2+n2)%n2+2;
	}

	public void add(String key) {
		if (size >= N-1)
			throw new RuntimeException ( "MyHash table overflow: "+
				"add("+key+");" );
		int h0 = hash(key);
		int i=0, hi=h0;
		while (h[hi]!=null && i<N) hi=(h0+p.probe(++i,key))%N;		// probing
		if (h[hi]!=null)
			throw new RuntimeException ( "MyHash unresolvable collision: "+
				"add("+key+"); h0="+h0+" h2="+hash2(key)+" i="+i+
				" p.probe(i,key)="+p.probe(i,key)+" size="+size+
				", "+probingMode+" Probing" );
		h[hi] = ""+h0+'\t'+hash2(key)+'\t'+i+'\t'+p.probe(i,key)+'\t'+key;
		size++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(probingMode.name()+" Probing\n");
		sb.append("h\th0\th2\ti\tp(i)\tkey\n");
		for (int i=0; i<N; i++) sb.append(""+i+'\t'+h[i]+'\n');
		sb.append("LoadFactor="+loadFactor()+'\n');
		return sb.toString();
	}

	public int size() { return size; }

	public double loadFactor() { return (double) size/N; }
}
