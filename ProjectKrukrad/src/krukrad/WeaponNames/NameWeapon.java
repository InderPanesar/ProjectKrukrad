package krukrad.WeaponNames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import krukrad.base64.EncryptDecrypt;

//this class gets the name of the weapon
//from the three textFiles as seen below.
//all of those textFiles are encrypted with Base64

public class NameWeapon {
	int NumberOfChoices = 0;
	EncryptDecrypt nc = new EncryptDecrypt();
	String[] Names = new String[10];
	String FileName = "";
	
	public String[] getName(int Level) {
		//According to the different levels, there are a different set of names.
		if (Level == 1) {
			FileName = "res/weapon/normalWeapon.txt";
		}
		if (Level == 2) {
			FileName = "res/weapon/rareWeapon.txt";
		}
		if (Level == 3) {
			FileName = "res/weapon/ultrarareWeapon.txt";
		}
		ReadFile();
		//Calls ReadFile method.
		return Names;
		//This getName class returns an array of names (10 names)
		
	}
	
	public void ReadFile() {
		//This will get the names from the text file, decode them and store them,
		try (BufferedReader br = new BufferedReader(new FileReader(FileName))) {
			String sCurrentLine;
			String Decoded;
			int i = 0;
			//The while loop will continue until there is a empty line
			while ((sCurrentLine = br.readLine()) != null) {
				Decoded= nc.Decode(sCurrentLine);
				Names[i] = Decoded;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}