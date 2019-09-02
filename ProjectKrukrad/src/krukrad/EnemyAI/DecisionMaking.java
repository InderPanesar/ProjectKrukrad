package krukrad.EnemyAI;

import java.util.Random;

/*
 * =========================================================================================
 * = This is a graph traversal for the AI for battling.									   =
 * = This will decide what attacks the AI uses, while it is not complex in such games      =
 * = like Pokemon, it has basic knowledge so that it can skip and choose specific attack,  =
 * = they would heal or attack if they cannot kill you.  								   =	
 * =========================================================================================
 */

public class DecisionMaking {
	int EnemyHealth = 0;
	int PlayerHealth = 0;
	int EnemyAttack1 = 0;
	int EnemyAttack2 = 0;
	int EnemyAttack3 = 0;
	String EnemyClass = null;
	int ChosenAttack = 0;
	
	//Requests all the Variables also the class which is called to get an attack back.
	public int getVariablesEnemy(int EnemyHealth, int EnemyAttack1, int EnemyAttack2, int EnemyAttack3, int PlayerHealth, String EnemyClass) {
		this.EnemyHealth = EnemyHealth;
		this.EnemyAttack1 = EnemyAttack1;
		this.EnemyAttack2 = EnemyAttack2;
		this.EnemyAttack3 = EnemyAttack3;
		this.PlayerHealth = PlayerHealth;
		this.EnemyClass = EnemyClass;
		NextMoveDeathChecker();
		
		return ChosenAttack;
	}
	
	public void NextMoveDeathChecker() {
		int CheckHealth1 = PlayerHealth - EnemyAttack1;
		int CheckHealth2 = PlayerHealth - EnemyAttack2;

		if (CheckHealth1 <= 0 || CheckHealth2 <= 0 || CheckHealth1 <= 0) {
			CheckCanIKill(true);
		}	
		
		else {
			CheckCanIKill(false);
		}
	}
	
	public String StrongestAttack() {
		String Strongest = null;
		if (EnemyAttack1 > EnemyAttack2) {
			if(EnemyAttack1 > EnemyAttack3) {
				Strongest = "1";
			}
			else {
				Strongest = "3";
			}
		}
		else {
			if(EnemyAttack2 > EnemyAttack3) {
				Strongest = "2";
			}
			else {
				Strongest = "3";
			}
		}
		return Strongest;
		
	}
	
	@SuppressWarnings("unused")
	public void CheckCanIKill(Boolean NearlyDead) {
		int CheckHealth1 = PlayerHealth - EnemyAttack1;
		int CheckHealth2 = PlayerHealth - EnemyAttack2;
		int CheckHealth3 = PlayerHealth - EnemyAttack3;

		if (CheckHealth1 <= 0 || CheckHealth2 <= 0 || CheckHealth1 <= 0) {
			if (NearlyDead && EnemyClass.equals("The Ruthless")) {
				String Move = StrongestAttack();
				int Attack = Integer.parseInt(Move);
				ChosenAttack = Attack; //Attack with most powerful attack!
			}
			if (NearlyDead) {
				String Move = StrongestAttack();
				int Attack = Integer.parseInt(Move);
				ChosenAttack = Attack; //Attack with most powerful attack!
			}
			else {
				int random = new Random().nextInt(100);
				System.out.println(random);
				if (random < 50) {
					random = new Random().nextInt(3);
					int Attack = 0;
					if (random == 0) {
						Attack = 1;
					}
					if (random == 1) {
						Attack = 2;
					}
					if (random == 2) {
						Attack = 3;
					}
					ChosenAttack = Attack; //Attack with most powerful attack!
				}
				else {
					HealOrSkip();
				}
			}
		}
		else {
				int random = new Random().nextInt(100);
				System.out.println(random);
				if (random < 50) {
					random = new Random().nextInt(3);
					int Attack = 0;
					if (random == 0) {
						Attack = 1;
					}
					if (random == 1) {
						Attack = 2;
					}
					if (random == 2) {
						Attack = 3;
					}
					ChosenAttack = Attack; //Attack with most powerful attack!
				}
				else {
					HealOrSkip();
				}
			}

		}	
		
	
	public void HealOrSkip() {
		int random = new Random().nextInt(100);
		if (random < 50) {
			Heal();
		}
		else {
			ChosenAttack = 0;
		}
	}
	
	
	public void Heal() {
		ChosenAttack = 4;
	}

	
	

}


