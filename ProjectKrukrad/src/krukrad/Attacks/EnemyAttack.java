package krukrad.Attacks;

public class EnemyAttack {
	
	public String AttackSkipOrHeal(int attackNumber) {
		
		//This shows what attack actually happened
		//As the user may skip and this will handled as the integer 0 by the program
		//This is here to be used in the AttackHandler as well. 
		
		String attack = null;
		if (attackNumber == 0) {
			attack = "Skip";
		}
		if (attackNumber == 1) {
			attack = "Attack One";
		}
		if (attackNumber == 2) {
			attack = "Attack Two";
		}
		if (attackNumber == 3) {
			attack = "Attack Three";
		}
		if (attackNumber == 4) {
			attack = "Heal";
		}
		return attack;
		
	}

}
