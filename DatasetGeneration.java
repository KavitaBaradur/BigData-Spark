package datasets;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DatasetGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub				
		try {
			PrintWriter out = new PrintWriter("Customers.csv");
			
			for (int i = 1; i <= 50000; i++) {
				out.println(Customer.newCustomerInfo().toString());

			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter out = new PrintWriter("Transactions.csv");
		
			for (int i = 1; i <= 5000000; i++) {
				out.println(Transaction.newTransactionInfo().toString());

			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}

