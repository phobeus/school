/**
 * @(#)RankingServer.java -- ADS -- Praktikum 05 -- Fragment / Vorlage
 *
 *
 * @author Arnold Aders
 * @version 0.51 20130319
 **/
package ch.zhaw.ads.services;

import java.util.*;

import ch.zhaw.ads.CommandExecuter;

public class RankingServer implements CommandExecuter {
	private List<Competitor> list;
	private Comparator<Competitor> competitorRankComparator;

	public RankingServer() {
		list = new LinkedList<Competitor>();
		competitorRankComparator = new Comparator<Competitor>() {
			public int compare ( Competitor drEint, Competitor drAnder ) {
				return drEint.getTime()-drAnder.getTime();
			}
		};
	}

	public String execute (String command) {
		
		String[] pieces = command.split("[ |;]");
		
		for (int i = 0; i < pieces.length; i++) {
			int position = i%8;
			
				switch (position) {
					case 1: System.out.println(pieces[i]+"  Name");
					break;
					case 2: System.out.println(pieces[i]+"  Vorname");
					break;
					case 3: System.out.println(pieces[i]+"  JG");
					break;
					case 4: System.out.println(pieces[i]+"  Counrtry");
					break;
					case 5: System.out.println(pieces[i]+"  Zeit");
					break;
					case 6: System.out.println(pieces[i]+"  Sex");
					break;
					case 7: System.out.println(pieces[i]+"  sex");
					break;
				}
		}
		return pieces[0];
	}

	private void sortByName(List<Competitor> list) {
		Collections.sort ( list, new Comparator<Competitor>() {
			public int compare ( Competitor drEint, Competitor drAnder ) {
				int krit = drEint.getName().compareTo(drAnder.getName());
				if (krit!=0) return krit;
				return drEint.getFirstName().compareTo(drAnder.getFirstName());
			}
		});
	}
	
	private void sortByTime(List<Competitor> list) {
		
	}
}
