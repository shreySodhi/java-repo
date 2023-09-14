public class Toy{
	String name;
	Toy(String name){
		this.name = name;
	}
    @Override
	public String toString(){
		return "A " + name;  
	}
	
	boolean equals(Toy t){
		return t.getName().equals(this.getName());
	}
	String getName(){
		return name;
	}
}