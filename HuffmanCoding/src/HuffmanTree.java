import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanTree {
    Node root;
    HuffmanTree(int [] counts) throws FileNotFoundException{
        root = null;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < counts.length;i++)
            if(counts[i] > 0) pq.add(new Node<>((char) i, counts[i]));
        pq.add(new Node((char)256, 1));
        buildTree(pq);
        root = pq.poll(); 
    }
    void buildTree(PriorityQueue<Node> pq){
        if(pq.size() > 1){
            Node tree = new Node (null, 0);
            tree.left = pq.poll();
            tree.right = pq.poll();
            tree.weight = tree.left.weight+tree.right.weight;
            pq.add(tree);
            buildTree(pq);
        }
    }
    HuffmanTree(String codeFile) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(codeFile));
        root = new Node (null, 0);
        while(sc.hasNextLine()){
            Node temp = root;
            int val = sc.nextInt();
            sc.nextLine();
            String code = sc.nextLine();
            for(int i = 0; i < code.length();i++){
                if(code.charAt(i) == '0'){ 
                    if(temp.left == null) temp.left = new Node();
                    temp = temp.left;
                }
                else{
                    if(temp.right == null) temp.right = new Node();
                    temp = temp.right;
                }
            }
            temp.val = (char) val;
        }
        sc.close();
    }
    void write(String fileName) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(fileName));
        writeHelper(pw, root, "");
        pw.close();        
    }
    void writeHelper(PrintWriter pw, Node n, String s){
        if(n.val != null) pw.println((int)(char)n.val+"\n" + s);
        else{
            writeHelper(pw, n.left, s+"0");
            writeHelper(pw, n.right, s+"1");
        }
    }
    void encode(BitOutputStream out, String fileName) throws FileNotFoundException{
      Scanner sc = new Scanner(new File(fileName));
      HashMap<Character, String> hm = new HashMap<>();
      while(sc.hasNextLine()){
        String s = sc.nextLine()+"\n";
        if(!sc.hasNextLine()) s = s.substring(0,s.length()-1);
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(!hm.containsKey(c)) hm.put(c,encodeHelper(c, root));
            String huff = hm.get(c);
            // String huff = encodeHelper(s.charAt(i), root);
            for(int j = 0; j < huff.length();j++)
                out.writeBit(Integer.valueOf(huff.substring(j,j+1)));
        }
      }
      sc.close();
      String huff = encodeHelper((char) 256, root);
      for(int j = 0; j < huff.length();j++){
        out.writeBit(Integer.valueOf(huff.substring(j,j+1)));
      }
      out.close();
    }
    <T> String encodeHelper(T val, Node n){
        if(n.left == null && n.right == null){
            if((char) val == (char) n.val) return "";
            else return null;
        }
        String left = encodeHelper(val, n.left);
        String right = encodeHelper(val, n.right);
        if(left!= null) return "0"+left;
        if(right!= null) return "1"+right;
        return null;    
    }
    void decode(BitInputStream in, String outFile) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(outFile));
        Node temp = root;
        while(true){
            temp = (in.readBit() == 0) ? temp.left : temp.right;  
            if(temp.val!= null){
                if((char) temp.val == (char) 256) break;
                pw.print(temp.val);
                temp = root;
            }
        }
        pw.close();
    }
}