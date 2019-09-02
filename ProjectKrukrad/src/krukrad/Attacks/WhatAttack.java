package krukrad.Attacks;

public class WhatAttack {
	
	public char WhatAttackIsChosen (String Attack) {
		char c = ' ';
		
		//This assigns an attack a char from A to J 
		//This was used as it would be easier to troubleshoot Characters than entire Strings.
		//This returns a the C variable to the AttackHandler Class.
		
		switch (Attack) {
	    	case "Sword Attack":
	    		c = 'a';
	    		break;
	    	case "Ruthless Execution":
	    		c = 'b';
	    		break;
	    	case "Bombardment":
	    		c = 'c';
	    		break;
	    	case "Bayonet Charge":
	    		c = 'd';
	    		break;
	    	case "Poison Attack":
	    		c = 'e';
	    		break;
	    	case "Blind":
	    		c = 'f';
	    		break;
	    	case "Storm Bolt":
	    		c = 'g';
	    		break;
	    	case "Backstab":
	    		c = 'h';
	    		break;
	    	case "EarthQuake Spell":
	    		c = 'i';
	    		break;
	    	case "Teardrop Stab":
	    		c = 'j';
	    		break;
		}
		return c;
		
	}

}