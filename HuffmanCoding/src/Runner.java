import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("TextFiles/Hamlet.txt");
        Scanner sc = new Scanner(f);
        String s = sc.nextLine();
        int [] counts = new int[256];
        for(int i = 0; i < s.length();i++) counts[s.charAt(i)]++;
        HuffmanTree ht = new HuffmanTree(counts);
        // ht.write();
    }
}
