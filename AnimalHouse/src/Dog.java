public class Dog extends Animal{
   private boolean goodBoy;
   Dog(String name, int birthYear, boolean goodBoy){
     super(name,birthYear);
     this.goodBoy = goodBoy;


}
@Override
public String toString(){
	if(goodBoy)
		return super.toString() + "I am a good boy";
	return super.toString() + "I am not a good boy";
}
}