import java.io.File;
import java.io.IOException;

class Runner{
	public static void main(String[] args) throws IOException{
	WordCloud w = new WordCloud("bee-movie.txt");
		w.printStats();

		

	}
}