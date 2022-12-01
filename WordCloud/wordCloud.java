import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class WordCloud{
	private ArrayList<Word> words;
	private ArrayList<Word>topHits;
	private int totalWords;
	private int uniqueWords;
	public WordCloud(String fileName)throws IOException{
		words = new ArrayList();
		topHits = new ArrayList();
		totalWords = 0;
		uniqueWords = 0;
		load(fileName);
	}
	private int getIndex(String str){
		for(int x = 0; x < words.size();x++){
			if(words.get(x).getWord().equals(str)){
				return x;
			}
		}
		return -1;
	}
	private void load(String fileName) throws IOException{
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		int x = 0;
		while(sc.hasNext()){
			String s = sc.next().toLowerCase();

			
			
			if(!Character.isLetterOrDigit(s.charAt(0))){
				 	s = s.substring(1);
			}
			if(s.length() == 0)
				continue;
			if(!Character.isLetterOrDigit(s.charAt(s.length()-1)))
				s = s.substring(0, s.length()-1);
			
			
			if(getIndex(s) ==-1){
				words.add(new Word(s));
			}
			else{
				words.get(getIndex(s)).increment();
			}
			totalWords++;
		}
		findTopHits();


	}
	private void findTopHits(){
		
		
		for(int x = 0; x < 30;x++){
			int i = 0;
			int f = Integer.MIN_VALUE;
			for(int y = 0; y < words.size();y++){
				if(words.get(y).getCount() > f){
					f = words.get(y).getCount();
					i = y;
				}
			}
			topHits.add(words.get(i));
			words.remove(i);
		}
		
	}
	public ArrayList<Word> getTopHits(){
		return topHits;

	}
	public void printStats(){
		System.out.println("Number of unique words >>> " + (words.size()+topHits.size()));
		System.out.println("total # of words  >>> " + totalWords);
		System.out.println("\t word \t Frequency ");

		for(int x = 0; x < 30;x++){

			System.out.println((x+1)+") \t" + topHits.get(x));

		}
	}
	
}
