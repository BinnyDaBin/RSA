import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSA_main {
	private final static SecureRandom random = new SecureRandom();
	
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger e;
	private BigInteger d;

	public static void main(String[] args)throws FileNotFoundException {
		// TODO hello Jen
		System.out.println(encrypt("Tired"));
//		RSA_main myInf = new RSA_main(5);
//		System.out.println(myInf.toString());
		File file = new File("/Users/dabinlee/RSA/message.txt");
		Scanner scanner = new Scanner(file);
		String s1;
		String s2 = "";
		while(scanner.hasNext()) {
			s1 = scanner.next();
			s2 += s1 + " ";
		}
		System.out.println(decrypt(s2));
		scanner.close();
	}
	
	RSA_main(int N){
		p = BigInteger.probablePrime(N, random);
		q = BigInteger.probablePrime(N, random);
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		n = p.multiply(q);
		e = BigInteger.probablePrime(N/2, random);
		while(phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
			e.add(BigInteger.ONE);
		}
		d = e.modInverse(phi);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("p= " + p + "\n");
		s.append("q= " + q + "\n");
		s.append("n= " + n + "\n");
		s.append("e= " + e + "\n");
		s.append("d= " + d + "\n");
		return s.toString();
	}
	
	public static String encrypt(String message) {
//		int p = 43;
//		int q = 59;
//		BigInteger n = BigInteger.valueOf(p*q);
		BigInteger n = new BigInteger("769750914680484372200078422578788743792190453917708306205411");
		BigInteger e = new BigInteger("823738732813999");
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
		BigInteger n = new BigInteger("769750914680484372200078422578788743792190453917708306205411");
		// Find d
		BigInteger d = new BigInteger("353343052159423642183327550893401946314922128579120163105999");
		StringBuilder result = new StringBuilder();
		
		String[] letters = encryptedM.split(" ");
		for(String letter : letters) {
			numL = new BigInteger(letter);
			decInt = numL.modPow(d, n);
			decL = (char) decInt.intValue();
			result.append(decL);
		}
		return result.toString();
	}
}
