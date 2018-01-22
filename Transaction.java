package datasets;

import utils.Generator;

public class Transaction {
	private int TransID;
	private int CustID;
	private float TransTotal;
	private int TransNumItems;
	private String TransDesc;
	public static final String SEPARATOR = ",";

	public Transaction() {

	}
	public Transaction(int TransID, int CustID, float TransTotal, int TransNumItems, String TransDesc) {
		super();
		this.TransID = TransID;
		this.CustID = CustID;
		this.TransTotal = TransTotal;
		this.TransNumItems = TransNumItems;
		this.TransDesc = TransDesc;
	}
	public static Transaction newTransactionInfo() {

		int TransID = Generator.genTransactionsId();

		int CustID = Generator.genRandomInt(1, 50000);

		double TransTotal = Generator.genRandomFloat(10, 1000);

		int TransNumItems = Generator.genRandomInt(1, 10);

		String TransDesc = Generator.genRandomString(20,50);	

		Transaction info = new Transaction(TransID, CustID, (float)TransTotal, TransNumItems, TransDesc);

		return info;

	}
	@Override
	public String toString()
	{
		return this.TransID + SEPARATOR +
				this.CustID + SEPARATOR +
				this.TransTotal + SEPARATOR +
				this.TransNumItems + SEPARATOR +
				this.TransDesc;
	}

	public int getTransID() {
		return TransID;
	}
	public void setTransID(int TransID) {
		this.TransID = TransID;
	}
	public int getCustID() {
		return CustID;
	}
	public void setCustID(int CustID) {
		this.CustID = CustID;
	}
	public float getTransTotal() {
		return TransTotal;
	}
	public void setTransTotal(float TransTotal) {
		this.TransTotal = TransTotal;
	}
	public int getTransNumItems() {
		return TransNumItems;
	}
	public void setTransNumItems(int TransNumItems) {
		this.TransNumItems = TransNumItems;
	}
	public String getTransDesc() {
		return TransDesc;
	}
	public void setTransDesc(String TransDesc) {
		this.TransDesc = TransDesc;
	}

}
