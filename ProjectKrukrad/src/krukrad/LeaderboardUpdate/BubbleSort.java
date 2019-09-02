package krukrad.LeaderboardUpdate;

import java.util.List;

public class BubbleSort {
	
	//This sorts a list for the leaderboards so it can be shown in ASCD order.
	
	public List<Double> list(List<Double> Times, double NewTime){ 
		List <Double> items = Times;
		items.add(NewTime);
		int numberofTimes = items.size() - 1;
		int FirstComparison = 0;
		int SecondComparison = 1;
		int interval = 0;
		int interval2 = 0;
		
		List<Double> tuncate;
		
		//this will continue until all values in the list are sorted.
		while (numberofTimes > 0) {
			Double Value1 = items.get(SecondComparison);
			Double Value2 = items.get(FirstComparison);
			if(Value1 < Value2) {
				items.set(FirstComparison, Value1);
				items.set(SecondComparison, Value2);
				while (interval2 < items.size()) {
					System.out.print(items.get(interval2) + " ");
					interval2++;
				}
				System.out.println();
				interval2 = 0;
			}
			FirstComparison++;
			SecondComparison++;
			interval++;
			if(interval == numberofTimes) {
				FirstComparison = 0;
				SecondComparison = 1;
				interval = 0;
				numberofTimes--;
			}
		}

		
		//the list is truncated to 5 items as the Leader-board only shows
		// the top 5 times.
		interval2 = 0;
		tuncate = items.subList(0, 5);
		
		while (interval2 < tuncate.size()) {
			System.out.println(tuncate.get(interval2) + " ");
			interval2++;
		}
		
		// the method then returns this truncated list.
		return tuncate;
	}

}
