package krukrad.LeaderboardUpdate;

import java.io.PrintWriter;
import java.util.List;

/*
 * The leaderboard is written to a textFile here where it can be looked at later,
 * it will be read in either the next game or in the ,
 * UI Class.
 */

public class WriteLeaderBoard {
	
	public void WriteFile(List<java.lang.String> Times) {
		int interval2 = 0;
		PrintWriter writer = null;
		//New PrintWriter is intialised
		try {
			writer = new PrintWriter("res/Leaderboard/LeaderboardTimes.txt", "UTF-8");
			//Writer then opens a new textFile
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		while (interval2 < Times.size()) {
			writer.println(Times.get(interval2));
			interval2++;
			//The writer then writes each time from the list
		}
	
		writer.close();
		//Then closes file
	}
 

}

