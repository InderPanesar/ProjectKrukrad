package krukrad.Attacks;

// This handles the attacks as if the attacks are more or less damaging according to
// the enemy/player class. This means they gives a element of surprise for
// both of the enemy attacks.
public class AttackHandler {
	
	public String Type = "";
	
	public int whatLogicToUse(String Attack, int attackDamage, String EnemyType, int EnemyHealth,int Turn) {
		WhatAttack nc = new WhatAttack();
		Type = Attack;
		char c = nc.WhatAttackIsChosen(Attack);
		
		int damage = attackDamage;
		//damage of the attack character in question is stored here.
		
		if (c == 'a') {
			if (EnemyType == "The Athletic") {
				damage = damage - 5;
				//if the attack is an 'a' attack it does 5 less damage on Athletic Class Enemies.
			}
			else if (EnemyType == "The Confident") {
				damage = damage + 5;
				//if the attack is an 'a' attack it does 5 more damage on Confident Class Enemies.
			}
		}
		
		if (c == 'b') {
			if (EnemyType == "The Ruthless") {
				damage = damage - 30;
				//if the attack is an 'b' attack it does 30 less damage on a Ruthless Class Enemies.
			}
			else if (EnemyType == "The Cowardly") {
				damage = damage + 10;
				//if the attack is an 'b' attack it does 10 more damage on a Cowardly Class Enemies.
			}
			
			if (EnemyHealth > 30) {
				damage = 0;
				//If the attack is an 'b' attack it and the enemy's health more than 30 then the damage does no damage.
				//Even if it does more damage to the Cowardly class, it also has to have a health less than 30.
			}
			
		}
		if (c == 'c') {
			if (EnemyType == "The Careless") {
				damage = damage + 5;
				//if the attack is an 'c' attack it does 5 more damage on a Careless Class Enemies.
			}
			else if (EnemyType == "The Daring") {
				damage = damage - 5;
				//if the attack is an 'c' attack it does 5 less damage on a Daring Class Enemies.
			}
			
		}
		if (c == 'd') {
			if (EnemyType == "The Athletic") {
				damage = damage - 5;
				//if the attack is an 'd' attack it does 5 less damage on a Athletic Class Enemies.
			}
			else if (EnemyType == "The Daring") {
				damage = damage - 5;
				//if the attack is an 'd' attack it does 5 less damage on a Daring Class Enemies.
			}	
			else if (EnemyType == "The Confident") {
				damage = damage + 5;
				//if the attack is an 'd' attack it does 5 more damage on a Confident Class Enemies.
			}
		}
		if (c == 'e') {
			if (EnemyType == "The Maniac") {
				damage = damage - 5;
				//if the attack is an 'e' attack it does 5 less damage on a Maniac Class Enemies.
			}
			else if (EnemyType == "The Cruel") {
				damage = damage - 5;
				//if the attack is an 'e' attack it does 5 less damage on a Cruel Class Enemies.
			}
			
		}
		if (c == 'f') {
			if (EnemyType == "The Athletic") {
				damage = damage - 5;
				//if there attack is an 'f' attack it does 5 less damage on a Athletic Class Enemies.
			}	
		}
		if (c == 'g') {
			if (EnemyType == "The Sadistic") {
				damage = damage - 5;
				//if there attack is an 'g' attack it does 5 less damage on a Sadistic Class Enemies.
			}	
		}
		if (c == 'h') {
			if (Turn > 3) {
				damage = 0;
				//if the turn three has passed this attack does no damage.
			}	
		}
		if (c == 'i') {
			if (EnemyType == "The Daring") {
				damage = damage - 5;
				//if there attack is an 'i' attack it does 5 less damage on a Daring Class Enemies.
			}
		}
		if (c == 'j') {
			//NO CLASSES OR OUTSIDE VARIABLES AFFECT THIS CLASS
		}
		
		if (damage < 0) {
			damage = 0;
			//Since we are also taking away numbers from damage,
			//It may be possible that we may end up with a negative number
			//In which case is impossible, therefore set damage as 0 if it is a negative value.
		}
		
		return damage;
	}

}
