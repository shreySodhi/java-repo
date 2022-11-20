class Tombstone{
	private String name;
	private String burialDate;
	private int age;
	private String address;
	Tombstone(String n, String bd, int a, String add){
		name = n;
	    burialDate = bd;
	    age = a;
	    address = add;


	}
	String getName(){
		return name;
	}
	String getBurialDate(){
		return burialDate;
	}
	int getAge(){
		return age;
	}
	String getAddress(){
		return address;
	}

}