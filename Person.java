import java.io.Serializable;
import java.text.DecimalFormat;

public class Person implements Comparable<Person>, Serializable{
	private int age;
	private String name;
	private String address;
	private int zipcode;
	private double salary;
	DecimalFormat formatter = new DecimalFormat("#,###.00");
	
	//default no-arg constructor
	public Person() {
		setAge(0);
		setName("John Smith");
		setAddress("123 Main st");
		setZipCode(12345);
		setSalary(100000000.00);
	}
	
	//convenience constructor
	public Person(int age, String name, String address, int zipcode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipcode);
		setSalary(salary);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipcode;
	}

	public void setZipCode(int zipCode) {
		this.zipcode = zipCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %d $%s", age, name, address, zipcode, formatter.format(salary));
	}

	@Override
	public int compareTo(Person o) {
		if(getSalary() > o.getSalary()) {
			return -1;
		}
		else if(getSalary() == o.getSalary()){
			return 0;
		}
		else {
			return 1;
		}
	}
}
