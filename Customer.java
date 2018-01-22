package datasets;

import utils.Generator;

public class Customer {

	private int ID;
	private String Name;
	private int Age;
	private int CountryCode;
	private float Salary;

	public static final int CUSTOMER_NAME_LEN_FROM = 10;
	public static final int CUSTOMER_NAME_LEN_TO = 20;

	public static final int CUSTOMER_AGE_FROM = 10;
	public static final int CUSTOMER_AGE_TO = 70;

	public static final int CUSTOMER_COUNTRYCODE_FROM = 1;
	public static final int CUSTOMER_COUNTRYCODE_TO = 10;

	public static final int CUSTOMER_SALARY_FROM = 10;
	public static final int CUSTOMER_SALARY_TO = 10000;

	public static final String SEPARATOR = ",";

	public Customer() {

	}

	public Customer(int ID, String Name, int Age, int CountryCode, float Salary) {
		super();
		this.ID = ID;
		this.Name = Name;
		this.Age = Age;
		this.CountryCode = CountryCode;
		this.Salary = Salary;
	}

	public static Customer newCustomerInfo() {

		int ID = Generator.genCustomerId();

		String Name = Generator.genRandomString(CUSTOMER_NAME_LEN_FROM, CUSTOMER_NAME_LEN_TO);

		int Age = Generator.genRandomInt(CUSTOMER_AGE_FROM, CUSTOMER_AGE_TO);

		int CountryCode = Generator.genRandomInt(CUSTOMER_COUNTRYCODE_FROM, CUSTOMER_COUNTRYCODE_TO);

		double Salary = Generator.genRandomFloat(CUSTOMER_SALARY_FROM, CUSTOMER_SALARY_TO);

		Customer info = new Customer(ID, Name, Age, CountryCode, (float) Salary);

		return info;
	}
	@Override
	public String toString() {
		return this.ID + SEPARATOR + this.Name + SEPARATOR +this.Age + SEPARATOR + this.CountryCode + SEPARATOR + this.Salary;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}

	public int getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(int CountryCode) {
		this.CountryCode = CountryCode;
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(Float Salary) {
		this.Salary = Salary;
	}

}
