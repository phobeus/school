package measure;

import sortModes.*;
import interfaces.SortingModes;

public class Measurements {

	public final static SortingModes P_QUICK = new Quick();
	public final static SortingModes P_BUBBLE = new Bubble();
	public final static SortingModes P_SHELL = new Shell();
	
	private double[] data;
	private SortingModes sm;
	
    public Measurements(double[] data, SortingModes sm) {
    	this.data = data;
    	this.sm = sm;
    }
	
	public static double[] createRandomData(int size, double min, double max) {
		double[] a = new double[size];
		for(int i=0; i<size; i++) {
			a[i] = min + Math.random()*(max-min);
		}
		return a;
	}
	
	public void process() {	
		sm.sort(data, 0, data.length-1);
	}
	
	public double average() {
		double average = 0;
		for(int i=0; i<data.length; i++) {
			average += data[i]/data.length;
		}
		return average;
	}
	
	public double max() {
		double max = Double.MIN_VALUE;
		for(double v : data) {
			if (v > max) max = v;
		}
		return max;
	}
	
	public double min() {
		double min = Double.MAX_VALUE;
		for(double v : data) {
			if (v < min) min = v;
		}
		return min;
	}
	
	public String toString() {
		StringBuffer out = new StringBuffer("[");
		for(int i=0; i<data.length; i++) {
			out.append(data[i]);
			if (i<data.length-1)
				out.append(", ");
		}
		out.append("]");
		return out.toString();
	}

}
