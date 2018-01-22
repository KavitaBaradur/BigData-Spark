package utils;

import java.util.Random;

public class Generator {

	public static final String UPPER_SEQUENCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWER_SEQUENCE = UPPER_SEQUENCE.toLowerCase();
	private static int CUSTOMER_ID_INDENTIFIER = 1;
	private static Random random = new Random();
	
	private static int TRANSACTIONS_ID_INDENTIFIER = 1;
	
	//for Customer file
	public static int genCustomerId()
	{
		int ID =  CUSTOMER_ID_INDENTIFIER;
		CUSTOMER_ID_INDENTIFIER++;
		return ID;
	}
	public static String genRandomString(int fromLength, int toLength)
	{
		StringBuilder nameValue = new StringBuilder(); 
		
		int textLength = random.nextInt(toLength - fromLength + 1) + fromLength;
		int i = 0;
		while (i < textLength) {
			int randomPosition = random.nextInt(LOWER_SEQUENCE.length());
			char randomChar = LOWER_SEQUENCE.charAt(randomPosition);
			nameValue.append(randomChar);
			i += 1;
		}	
		return nameValue.toString();
	}
	public static int genRandomInt(int from, int to)
	{
		return (random.nextInt(to - from + 1) + from);
	}
	public static double genRandomFloat(int from, int to)
	{
		Random r = new Random();
		double randomValue = from + (to - from) * r.nextDouble();
		return randomValue;
	}
	//for Transactions file
	public static int genTransactionsId()
	{
		int ID =  TRANSACTIONS_ID_INDENTIFIER;
		TRANSACTIONS_ID_INDENTIFIER++;
		return ID;
	}
	
}
