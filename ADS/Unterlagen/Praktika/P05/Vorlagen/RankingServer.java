/**
 * @(#)RankingServer.java -- ADS -- Praktikum 05 -- Fragment / Vorlage
 *
 *
 * @author Arnold Aders
 * @version 0.51 20130319
 */

import java.util.*;

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
		return "";
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
}
