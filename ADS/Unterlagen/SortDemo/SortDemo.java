/*
 *	@(#)SortDemo.java -- Version 1.201 -- 20060119
 *
 *	Visualisierung klassischer Sort-Algorithmen nach Brown (...)
 *
 *	Arnold Aders, ZHW
 *
 *	Version 1.1 mit MergeSort
 *	Version 1.2 Bubblesort bricht ab sobald fertig sortiert ist
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class SortDemo extends Applet implements ActionListener {

	private int[] a;			// Array zum Sortieren
	private int n=150;			// Anzahl Elemente im Array
	private int groesse=300;	// Seitenlänge des Quadrates
	private int p=groesse/n;	// Seitenlänge eines Punktes,
								//   der ein Array-Element darstellt
	private int sleepTime=10;	// Wartezeit in Millisekunden
	private int cutOff=5;		// Grenze für QuickSort: kürzere Arrays werden
								//   mit SelectionSort sortiert

	private Button aufsteigend, absteigend, zufaellig,
		selectionSort, insertionSort, bubbleSort,
		shellSort, heapSort, quickSort, mergeSort;
	private Random rg;			// Pseudozufallszahlengenerator

	public void init() {
		rg = new Random();		// Pseudozufallszahlengenerator

		a = new int[n];
		
		setSize(575,400);

		selectionSort	= makeButton ("Selection Sort");
		insertionSort	= makeButton ("Insertion Sort");
		bubbleSort		= makeButton ("Bubble Sort");
		shellSort		= makeButton ("Shell Sort");
		heapSort		= makeButton ("Heap Sort");
		quickSort		= makeButton ("Quicksort");
		mergeSort		= makeButton ("Mergesort");
		aufsteigend		= makeButton ("aufsteigend");
		absteigend		= makeButton ("absteigend");
		zufaellig		= makeButton ("zufaellig");

		aufsteigend(a);
	}

	private Button makeButton (String s) {
		Button newButton = new Button (s);
		add(newButton);
		newButton.addActionListener(this);
		return newButton;
	}

	public void paint(Graphics g) {
		int xOL=70, yOL=70;
		g.drawString("Array initialisieren:", 10, 50 );
		
		g.drawRect ( xOL, yOL, groesse, groesse );
		g.clearRect ( xOL+1, yOL+1, groesse-1, groesse-1 );
		for (int i=0; i<a.length; i++)
			g.fillRect (xOL+p*a[i], yOL+p*(n-i-1), p, p );
		// (Bubble Sort macht seinem Namen Ehre ...)
		g.drawString("SortDemo Version 1.2 -- 20050117", 10, getHeight()-5 );
		g.drawString("Aders", getWidth()-100, getHeight()-5 );
	}

	public void actionPerformed (ActionEvent e) {
		if      (e.getSource()==aufsteigend)   aufsteigend(a);
		else if (e.getSource()==absteigend)    absteigend(a);
		else if (e.getSource()==zufaellig)     zufaellig(a);
		else if (e.getSource()==selectionSort) selectionSort(a);
		else if (e.getSource()==insertionSort) insertionSort(a);
		else if (e.getSource()==bubbleSort)    bubbleSort(a);
		else if (e.getSource()==shellSort)     shellSort(a);
		else if (e.getSource()==heapSort)      heapSort(a);
		else if (e.getSource()==quickSort)     quickSort(a);
		else if (e.getSource()==mergeSort)     mergeSort(a);
		
	}

	private void aufsteigend (int[] a) {
		for (int i=0; i<a.length; i++) a[i] = i;
		paint(getGraphics());
	}

	private void absteigend (int[] a) {
		for (int i=0; i<a.length; i++) a[i] = a.length-i-1;
		paint(getGraphics());
	}

	private void zufaellig (int[] a) {
		aufsteigend (a);
		sleepTime=10;
		for (int i=0; i<a.length-1; i++) {
			int j = i+rg.nextInt(a.length-i);
			swap (a, i, j);
		}
	}

	private void selectionSort (int[] a) {
		selectionSort(a, 0, a.length-1);
	}

	private void selectionSort (int[] a, int lo, int hi) {
		sleepTime=20;
		for (int i=lo; i<hi; i++) {
			int jMin=i;
			for (int j=i+1; j<hi+1; j++)
				if (a[j]<a[jMin]) jMin=j;
			swap (a, i, jMin);
		}
	}

	private void insertionSort (int[] a) {
	// benützt swap(...) nicht!
		sleepTime=20;
		for (int i=1; i<a.length; i++) {
			int temp=a[i];
			int j=i;
			for ( ; j>=1 && temp<a[j-1]; j-- )
				a[j]=a[j-1];
			a[j]=temp;
			paint(getGraphics());
			sleep(sleepTime);
		}
	}

	private void bubbleSort (int[] a) {
		sleepTime=10;
		int i=a.length-1;
		boolean nichtFertig = true;
		while (i>0 && nichtFertig) {
			nichtFertig = false;
			for (int j=0; j<i; j++)
				if (a[j+1]<a[j]) {
					swap (a, j, j+1);
					nichtFertig = true;
				}
			i--;
		}
	}

	private void shellSort (int[] a) {
	// benützt swap(...) nicht!
		sleepTime=20;
		for (int gap=a.length/2; gap>0; gap=(gap==2)?1:(int)(gap/2.2))
			for (int i=gap; i<a.length; i++) {
				int temp=a[i];
				int j=i;
				for ( ; j>=gap && temp<a[j-gap]; j-=gap )
					a[j]=a[j-gap];
				a[j]=temp;
				paint(getGraphics());
				sleep(sleepTime);
			}
	}

	private void heapSort (int[] a) {
		sleepTime=20;
		// Heap aufbauen:
		for (int links=a.length/2; links>=0; links--)
			sinkenLassen (a, links, a.length-1);
		// Heap abbauen:
		for (int rechts=a.length-1; rechts>0; rechts--) {
			swap (a, 0, rechts);
			sinkenLassen (a, 0, rechts-1);
		}
	}

	private void sinkenLassen (int[] a, int links, int rechts) {
	// Hilfsmethode zu Heapsort:
		int j=2*links+1;
		boolean weiterSinken=true;
		while (weiterSinken && j<rechts) {
			if (a[j] < a[j+1]) j++;
			if (a[(j-1)/2] < a[j]) swap (a, j, (j-1)/2);
			else weiterSinken=false;
			j=2*j+1;
		}
		if (weiterSinken && j==rechts)	// rechts ist ungerade
			if (a[(rechts-1)/2] < a[rechts])
				swap (a, rechts, (rechts-1)/2);
	}

	private void quickSort (int[] a) {
		sleepTime=20;
		quickSort(a, 0, a.length-1);	// starte die Rekursion
	}

	private void quickSort (int[] a, int lo, int hi) {
		if (hi-lo < cutOff)		// höchstens cutOff Elemente zu sortieren:
			selectionSort (a, lo, hi);
		else {		// mehr als cutOff Elemente zu sortieren:
			// Pivot bestimmen:
			int mi = (lo+hi)/2;		// Mitte
			if (a[mi] < a[lo])  swap (a, lo, mi);
			if (a[hi] < a[lo])  swap (a, lo, hi);
			if (a[hi] < a[mi])  swap (a, mi, hi);
			
			// Pivot nach a[hi-1]:
			swap (a, mi, hi-1);
			int pivot = a[hi-1];
			// Array a aufteilen:
			int i, j;
			for (i=lo, j=hi-1; ; ) {
				while (a[++i] < pivot);
				while (pivot < a[--j]);
				if (i<j) swap (a, i, j);
				else break;
			}
			// Pivot wiederherstellen:
			swap (a, i, hi-1);
			// Rekursion:
			quickSort (a, lo, i-1);
			quickSort (a, i+1, hi);
			
		}
	}

//	mergeSort, 2. Versuch: rekursiv, 'top down'
	private void mergeSort (int[] a) {
		sleepTime = 20;
		mergeSort(a, 0, a.length-1);	// Rekursion starten
	}

	private void mergeSort (int[] a, int li, int re) {
	//	rekursiver mergeSort auf Teilarray a[li] bis und mit a[re]
		if (li<re) {
			int mi = (li+re)/2;		// die Mitte
			mergeSort (a, li, mi);		// Rekursion
			mergeSort (a, mi+1, re);	// Rekursion
		//	merge Teilarrays:
			int i=li;
			int j=mi+1;
			while (i<j && j<=re) {
				if (a[i]>a[j]) {
					// a[j] nach a[i] rotieren
					rotate ( a, j, i );
					j++;
				}
				i++;
			}
		}
	}

	private void rotate (int[] a, int i, int j) {
	//	Voraussetzung: i>j	--	Hilfsmethode für mergeSort
	//	setze a[i] an die Stelle von a[j] und verschiebe die Elemente dazwischen
		int temp = a[i];
		for (int k=0;k<i-j;k++) a[i-k] = a[i-k-1];
		a[j] = temp;
		paint(getGraphics());
		sleep(sleepTime);
	}

	private void swap (int[] a, int i, int j) {
		// vertauscht a[i] und a[j]
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		paint(getGraphics());
		sleep(sleepTime);
	}

	private void sleep (int millis) {
		try { Thread.sleep(millis); }
		catch (InterruptedException e) { }
	}

}
