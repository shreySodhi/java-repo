import java.util.Scanner;
import java.util.HashMap;

class gridmap {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("How many tries do you want? ");
    int l = sc.nextInt();

    for(int x = 0;x < l;x++){
     
    System.out.print("\nEnter number 1 ");
    int n = sc.nextInt();
    System.out.print("\nEnter number 2 ");
    int n2 = sc.nextInt();
    long startTime1 = System.currentTimeMillis();
    HashMap<String, Long> h = new HashMap<>();
    System.out.println(grid(n, n2, h));
    System.out.println("method 1 time in milliseconds : " + (System.currentTimeMillis() - startTime1));
    long startTime2 = System.currentTimeMillis();
    System.out.println(grid(n, n2));
    
    System.out.println("method 2 time in milliseconds : " + (System.currentTimeMillis() - startTime2));

    }
    
  }

  public static Long grid(int n, int n2, HashMap<String, Long> h) {
    if (n == 0 || n2 == 0)
      return (long) 0;
    if (n == 1 || n2 == 1)
      return (long) 1;
    String s = n+ "," +n2;
 
    if (h.containsKey(s)){

       return h.get(s); 
    }
    String s1 = n2+ ","+ n;
     if (h.containsKey(s1)){

       return h.get(s1); 
    }
    long r = grid(n - 1, n2, h) + grid(n, n2 - 1, h);
    h.put(s, r);
    return r;

  }
  public static Long grid(int n, int n2) {
    if (n == 0 || n2 == 0)
      return (long) 0;
    if (n == 1 || n2 == 1)
      return (long) 1;

    return grid(n-1,n2) + grid(n,n2-1);

  }
}

  

          