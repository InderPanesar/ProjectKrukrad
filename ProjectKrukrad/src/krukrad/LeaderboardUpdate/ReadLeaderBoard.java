package krukrad.LeaderboardUpdate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import krukrad.base64.EncryptDecrypt;

public class ReadLeaderBoard {
	
	//Reads the leader-board, and then de-crypts the values and returns a list to updateTime
	
	public List<String> list(){  
		List<java.lang.String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("res/leaderboard/LeaderboardTimes.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		for(int i = 0; i < lines.size(); i++) {
			EncryptDecrypt nc = new EncryptDecrypt();
			lines.set(i, nc.Decode(lines.get(i)));
			System.out.println(lines.get(i));
		}

	    return lines;
	} 
}
