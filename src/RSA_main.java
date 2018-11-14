import java.math.BigInteger;

public class RSA_main {

	public static void main(String[] args) {
		// TODO hello Jen
		System.out.println(encrypt("Hello Jen!"));
		System.out.println(decrypt("1566 1342 1550 1550 1648 1544 169 1342 1614 1940 "));
	}
	
	public static String encrypt(String message) {
		int p = 43;
		int q = 59;
		BigInteger n = BigInteger.valueOf(p*q);
		int phi = (p-1)*(q-1);
		BigInteger e = new BigInteger("13");
		BigInteger d = new BigInteger("937");
		BigInteger numL;
		BigInteger encL;
		StringBuilder result = new StringBuilder();
		
		for(char letter : message.toCharArray()) {
			numL = BigInteger.valueOf(letter);
			encL = numL.modPow(e,n);
			result.append(encL + " ");
		}
		return result.toString();
	}
	
	public static String decrypt(String encryptedM) {
		BigInteger numL,decInt;
		char decL;
		BigInteger n = new BigInteger("2537");
		// Find d
		BigInteger d = new BigInteger("937");
		StringBuilder result = new StringBuilder();
		
		String[] letters = encryptedM.split(" ");
		for(String letter : letters) {
			numL = BigInteger.valueOf(Integer.parseInt(letter));
			decInt = numL.modPow(d, n);
			decL = (char) decInt.intValue();
			result.append(decL);
		}
		return result.toString();
	}
}
