package models;

public class Contact {
	private String name;
	private	String phone;
	private int age;
	private String address;

	public Contact(String name, String phone, int age, String address) {
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.address = address;
	}

	public void setName(String value) {this.name = value;}

	public String getName(){return this.name;}

	public void setPhone(String value){this.phone = value;}

	public String getPhone(){return this.phone;}

	public void setAge(int value){this.age=value;}

	public int getAge(){return this.age;}

	public void setAddress(String value) {this.address = value;}

	public String getAddress() {return this.address;}

	@Override
	public String toString(){
		return this.name +"("+ this.phone +"):" + "\n" + "	Endereço: "+ this.address +"\n"+ "	Idade: " + this.age;
	}
}

