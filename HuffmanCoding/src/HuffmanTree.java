import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
public class HuffmanTree {
    Node root;
    HuffmanTree(int [] counts){
        root = null;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < counts.length;i++)
            if(counts[i] > 0) pq.add(new Node<>((char) i, counts[i]));
        pq.add(new Node(Integer.toBinaryString(counts.length), 1));
        buildTree(pq);
        root = pq.poll();
        TreePrinter tp = new TreePrinter();
        tp.printTree(root);
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
        while(sc.hasNext()){ // why add psudo edf if we know when file ends?!?
            String s = sc.next();
            for(int i = 0; i < s.length();i++){
                String huff = encodeHelper(s.charAt(i), root); 
                for(int j = 0; j < huff.length();j++) out.writeBit(s.charAt(j));
            }
        }
    }
    <T> String encodeHelper(T val, Node n){
        if(val!= null)
            if(val == n.val) return "";
            else return null;
        String left = encodeHelper(val, n.left);
        String right = encodeHelper(val, n.right);
        if(left!= null) return left+"0";
        else if(right!= null) return right+"1";
        return null;
    }
    HuffmanTree(String codeFile) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(codeFile));
        while(sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            String code = sc.nextLine();
            root = buildTree(n, code);
        }
        TreePrinter tp = new TreePrinter();
        tp.printTree(root);
    }
    Node buildTree(int n, String code){
        if(code.length() == 0) return new Node((char)n, 1);
        Node nd = new Node(null, 0);
        if(code.charAt(0) == '0') 
            nd.left = buildTree(n, code.substring(1));
        else nd.right = buildTree(n, code.substring(0)); 
        return nd;
    }
    void decode(BitInputStream in, String outFile) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(outFile));
        Node temp = root;
        while(true){
            int i = in.readBit();
            if(i == 0) temp = temp.left;
            else temp = temp.right;
            if(temp.val!= null){
                if((int)temp.val > 127) break; 
                pw.print(temp.val);
                temp = root;
            }
        }
        pw.close();
    }
}