import java.util.ArrayList;
public class House{
	private ArrayList<Animal> animals;

	void add(Animal a ){
		animals.add(a);
	}

	House(){
		animals = new ArrayList<>();
	}
	void printAnimals(){
		System.out.println(animals.toString());
	}
	void cleanHouse(){
		for (Animal a : animals){
   			ArrayList<Toy> toys = a.getToys();
            for(int x = 0; x < toys.size();x++){
            	for(int y = x+1; y < toys.size();y++){
            		if(toys.get(x).equals(toys.get(y))){
            			toys.remove(y);
            			y--;
            		}
            	}
            }
         }

	}



}