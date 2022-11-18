import java.util.ArrayList;
class arrayListProbs{
	public arrayListProbs(){
	}
	public  void makeListAndPrint(int num, int limit){
		ArrayList<Integer> a = new ArrayList<>();
		for(int x = 0; x < num;x++)
			a.add((int)(Math.random()*limit+1));
		System.out.println(a);

	}
	public ArrayList<Integer>  addOne(ArrayList<Integer> list){
		for(int x  = 0; x < list.size();x++)
			list.set(x, list.get(x)+1);
		return list;
	}
	public ArrayList<Integer> minToFront(ArrayList<Integer> list){
		if(list.size() == 1)
			return list;
		int min = list.get(0);
        for(int x = 1; x < list.size(); x++)
        	min = Math.min(min, list.get(x));
        list.add(0, min);
		return list;
	}
	public ArrayList<String> removeDupes(ArrayList<String> list){
		for(int x = 0; x < list.size();x++){
			for(int y = 0; y < list.size();y++)
				if(list.get(x).equals(list.get(y))&& x!=y){
					list.remove(list.get(y));

				}
		}
		return list;
	}
	public ArrayList<Integer> swapPairs(ArrayList<Integer> list){

        
		for(int x = 0; x < list.size()-1;x+=2){
			int temp = list.get(x);
			list.set(x, list.get(x+1));
			list.set(x+1, temp);

		}
		return list;
	}
	public ArrayList<String> removeLenN(ArrayList<String> list, int n){
		int x = 0;
		while(x < list.size()){
			if(list.get(x).length() != n)
				x++;
			else
				list.remove(x);
		}
		return list;
	}
	public int dumbestPerson(ArrayList<Person> list){
		int dumb = Integer.MAX_VALUE;
		int i = 0;
		for(int x = 0; x < list.size();x++){
			if(list.get(x).getIQ() < dumb){
				dumb = list.get(x).getIQ();
				i = x;
			}
		}
		return i;
	}
	public Book highestPricedBook(ArrayList<Book> list){
		int min = list.get(0);
		int i = 0;
		for(int x = 0; x < list.size();x++)
			if(list.get(x).getPrice() < min){
				min = list.get(x).getPrice();
				i = x;
			}
			return list.get(i);
	}}