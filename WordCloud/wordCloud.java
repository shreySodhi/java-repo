import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class wordCloud{
	private ArrayList<Word> words;
	private ArrayList<Word>topHits;
	private int totalWords;
	private int uniqueWords;
	public wordCloud(String fileName)throws IOException{
		words = new ArrayList();
		topHits = new ArrayList();
		totalWords = 0;
		uniqueWords = 0;
	}
	private int getIndex(String str){
		for(int x = 0; x < words.size();x++){
			if(words.get(x).getWord())
				return x;
		}
		return -1;
	}
	private void load(String fileName) throws IOException{
		File f = new File(fileName);
		Scanner sc = new Scanner(f);
		int x = 0;
		while(sc.hasNext()){
			String s = (sc.next().toLowerCase());
			if(sc.hasNext()){
			   if(sc.next() == "-"){
			   	s+= " -";
			   	if(sc.hasNext()){
			   		words.add(new Word( "- " += sc.next()));
			   	}

			   }
				
			}
			if(!Character.isLetterOrDigit(s.charAt(s.length()-1))){
				 s.replace(s.charAt(s.length()-1), ' ');

			}
			if(!Character.isLetterOrDigit(s.charAt(0))){
				 s.replace(s.charAt(0), ' ');

			}
			Word w = new Word(s);
			if(getIndex(w.getWord()) ==-1){
                
				words.add(w);

			}
			else
				w.increment();
		}
		findTopHits();


	}
	private void findTopHits(){
		int f = Integer.MIN_VALUE;
		
		for(int x = 0; x < 30;x++){
			int i = 0;
			for(int y = 0; y < words.size();y++)
				if(words.get(y).getCount() > f){
					f = words.get(y).getCount();
					i = y;
				}
			topHits.add(words.get(i));
			words.remove(i);
		}
		
	}
	public ArrayList<Word> getTopHits(){
		return topHits;

	}
	
}
