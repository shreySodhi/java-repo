import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class HuffmanCompressor {
    public static void main(String [] args) throws FileNotFoundException{
        long start = System.currentTimeMillis();
        String fileName  = "Text Files/Hamlet";
        compress(fileName);
        System.out.println(System.currentTimeMillis()-start);
        expand(fileName);
        System.out.println(System.currentTimeMillis()-start);
    }
    static void compress(String fileName) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(fileName+".txt"));
        int counts[] = new int[256];
        while(sc.hasNextLine()){
            String s = sc.nextLine()+"\n";
            if(!sc.hasNextLine()) s = s.substring(0, s.length()-1);
            for(int i = 0; i < s.length();i++) counts[s.charAt(i)]++;
        }
        HuffmanTree ht = new HuffmanTree(counts);
        ht.write(fileName+".code");
        ht.encode(new BitOutputStream(fileName+".short"),fileName+".txt");
        // ht.decode(new BitInputStream(fileName+".short"), fileName+".new");
    }
    static void expand(String  fileName) throws FileNotFoundException{
        HuffmanTree ht = new HuffmanTree(fileName+".code");
        ht.decode(new BitInputStream(fileName+".short"), fileName+".new");
    }

}
