import java.util.ArrayList;
class Bookstore{

	private ArrayList<Book> Inventory;
	public Bookstore(){
		Inventory = new ArrayList<>();
	}
	public void addBook(Book b){
		Inventory.add(b);
	}
	public int numBooks(){
		return Inventory.size();
	}
	public Book getBook(int index){
		if(index > -1 && index < Inventory.size())
			return Inventory.get(index);
		return null;
	}
	


}