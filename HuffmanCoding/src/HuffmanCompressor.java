import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class HuffmanCompressor {
    public static void main(String [] args) throws FileNotFoundException{
        compress("short.txt");
    }
    static void compress(String fileName) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(fileName));
        int counts[] = new int[256];
        while(sc.hasNext()){
            String s = sc.next();
            for(int i = 0; i < s.length();i++) counts[s.charAt(i)]++;
            HuffmanTree ht = new HuffmanTree(counts);
            ht.encode(new BitOutputStream("TextFiles\\Hamlet.short"), fileName);
        }
    }
    

}
