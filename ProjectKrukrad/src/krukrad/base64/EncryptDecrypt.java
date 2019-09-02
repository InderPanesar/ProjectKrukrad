package krukrad.base64;

import java.util.Base64;

//Simply this class is to do with encrypting and decrypting text-files with Base64.
//This is to prevent the user from changing the names of weapons easily.
//As well as the number of wins being saved in a text-file which will be encrypted as well.

public class EncryptDecrypt {
	public String Decode (String Name) {
		byte[] decodedBytes = Base64.getUrlDecoder().decode(Name);
		String decodedUrl = new String(decodedBytes);
		return decodedUrl;
	}
	
	public String Encode (String Name) {
		String encodedUrl = Base64.getUrlEncoder().encodeToString(Name.getBytes());
		System.out.println(encodedUrl);
		return encodedUrl;
	}
}
