public class Cat extends Animal{
	private int numLives;
	Cat(String name, int birthYear, int numLives){
		super(name,birthYear);
		this.numLives = numLives;
	}
	Cat(String name, int birthYear){
		super(name,birthYear);
	}

	@Override
	public String toString(){
	
	return super.toString() + "I have "+ numLives+ " lives";
}


}