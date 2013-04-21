package ducksort;

public class Duck {

	private String duckName;
	private int duckWeight;
	private int duckSize;

	public Duck(String s, int i, int x) {
		this.duckName = s;
		this.duckWeight = i;
		this.duckSize = x;
	}

	public String toString() {
		return("Duck with name '" + this.duckName + "' has weight " + this.duckWeight + " and size " + this.duckSize + ".");
	}

	public String getDuckName() {
		return this.duckName;
	}
	
	public void setDuckName(String s) {
		this.duckName = s;
	}

	public int getDuckWeight() {
		return this.duckWeight;
	}
	
	public void setDuckWeight(int i) {
		this.duckWeight = i;
	}

	public int getDuckSize() {
		return this.duckSize;
	}
	
	public void setDuckSize(int i) {
		this.duckSize = i;
	}



}