class Word{
	private String word;
	private int count;
	public Word(String w){
		word = w;
		count = 0;
	}
	String getWord(){
		return word;
	}
	int getCount(){
		return count;
	}
	public void increment(){
		count++;
	}
	public String toString() {
       	return word + "\t\t" + count;
	}
 



}