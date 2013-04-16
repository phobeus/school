package ch.zhaw.ads.services;

public class Competitor implements Comparable<Competitor> {
	private String name;
	private String firstName;
	private String country;
	private char sex;
	private int time;
	private int jg;
	private int startNr;
	private int rank;

	public Competitor (String name, String firstName, int jg, String country, int time, char sex, int startNr){
		this.name = name;
		this.firstName = firstName;
		this.jg = jg;
		this.country = country;
		this.time = time;
		this.sex = sex;
		this.startNr = startNr;
		
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public int getJg() {
		return jg;
	}
	
	public int getStartNr () {
		return startNr;
	}

	public int compareTo(Competitor o) {
		if (this.time >= o.getTime()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public String toString() {
		int hours = time/3600;
		int minutes = (time - hours*3600) / 60;
		int seconds = time % 60;
		return rank + " " +  name + " " + firstName + " " + sex + " " +  country + " " +
				hours + ":" + minutes + ":" + seconds;
	}

}
