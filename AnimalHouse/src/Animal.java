import java.util.ArrayList;
class Animal{
	 private String name;
	 private int birthYear;
	 private ArrayList<Toy> toys;
	 private Animal friend = null;
	static int currentYear = 2023;

	public void addToy(Toy t) {
		toys.add(t);
		//System.out.println(toys.size());
	}
	Animal(String name, int birthYear){
		this.name = name;
		this.birthYear = birthYear;
		toys = new ArrayList<>();
	}
	void setFriend(Animal f){
		friend = f;
	}
	int getAge(){
		return (currentYear-birthYear);
	}
	public String toString(){
		if(friend!= null){
			if(toys.size() > 0)
		  		return "\nHello I am " + name +". \n I am " + getAge() +" years old \n My friends name is " + friend.getName()+ ". \nI have the following toys: " + this.toys.toString();
			
			
				return "Hello I am" + name +".\n I am " + getAge()+  " years old.\n My friends name is " + friend.getName() + ".\n I have no toys";
			
			}
		
			
				if(toys.size() > 0) 		  		
					return "Hello I am" + name +". \n I am " + getAge()+ " years old.\n I have no friends. \n I have the following toys: " + this.toys.toString();
			
				return "Hello I am" + name +". I am " + getAge()+ " years old. I have no friends " + friend.getName() + ". I have no toys";


	}

	public String getName(){
		return name;
	}
	public ArrayList<Toy> getToys(){
		return toys;
	}



}