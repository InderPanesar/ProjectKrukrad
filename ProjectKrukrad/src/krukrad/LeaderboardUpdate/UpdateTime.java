package krukrad.LeaderboardUpdate;

import java.util.ArrayList;
import java.util.List;

import krukrad.base64.EncryptDecrypt;

public class UpdateTime {
	
	List <Double> timeInSecondsDouble = new ArrayList<Double>();
	
	//This updates the leader-board, by the amount of wins you have.
	public void LeaderBoardUpdate(double Seconds) {
		ReadLeaderBoard nc = new ReadLeaderBoard();
		List<java.lang.String> timeInSeconds = nc.list();

		//gets the time
		//parse it to a double and stores it in a new ArrayList
		for (int J = 0; J < timeInSeconds.size(); J++) {
			double total = Double.parseDouble(timeInSeconds.get(J));
			System.out.println(total);
			timeInSecondsDouble.add(total);
			System.out.println(timeInSecondsDouble.get(J));
		}
		
		BubbleSort nc1 = new BubbleSort();
		timeInSecondsDouble = nc1.list(timeInSecondsDouble, Seconds);
		//Sorts the list
		
		// encodes each of the seconds again in base 64
		for (int J = 0; J < timeInSeconds.size(); J++) {
			String total = String.valueOf(timeInSecondsDouble.get(J));
			EncryptDecrypt nc2 = new EncryptDecrypt();
			timeInSeconds.set(J, nc2.Encode(total));
			System.out.println(timeInSeconds.get(J));
		}
		
		//rights to the Leaderboard.
		
		WriteLeaderBoard nc5 = new WriteLeaderBoard();
		nc5.WriteFile(timeInSeconds);
		
	}

}
