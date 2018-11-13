
public class RSA_main {

	public static void main(String[] args) {
		// TODO hello Jen
		System.out.println(encrypt("Hello World"));
	}
	
	public static String encrypt(String message) {
		int p = 11;
		int q = 13;
		int n = p*q;
		int phi = (p-1)*(q-1);
		int e = 23;
		int d = 47;
		
		String intM = toASCII(message);
		
		return intM;
	}
	
//	public static String decrypt(String decodedM) {
//		
//	}
	
	public static String toASCII(String message) {
		int numL;
		StringBuilder result = new StringBuilder();
		for(char letter : message.toCharArray()) {
			numL = (int) letter;
			result.append(numL + " ");
		}
		return result.toString();
	}
}
