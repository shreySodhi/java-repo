import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

public class WordLadder {
    public static void main(String[] args) throws Exception {
        Scanner dict = new Scanner(new File("dictionary.txt"));
        HashSet<String> hs = new HashSet<>();
        while(dict.hasNext())
            hs.add(dict.next());

        Queue<Stack<String>> queue = new LinkedList<>();
        Scanner sc = new Scanner(new File("input.txt"););
        Stack<String>s = new Stack<>();
        s.push(sc.next());
        queue.offer(s);
        String end = sc.next();

        while(!queue.peek().peek().equals(end)){
            
        }
        

    }
    private static ArrayList<String> OneOfWords(String start) {
        return null;

    }
    
}
