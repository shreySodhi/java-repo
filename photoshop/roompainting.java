import java.util.Scanner;
import java.util.Arrays;
class roompainting{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int [] sizes = new int[n];
        for(int x = 0; x < sizes.length;x++){
            sizes[x] = sc.nextInt();
        }
        Arrays.sort(sizes);
        
        int sum = 0;
        for(int x = 0; x < m;x++){

            sum+=search(sc.nextInt(), sizes);
        }
    }
    static int search(int n, int[] s ){
        int h = s.length;
        int l = 0;
        int m = (h+l)/2;
        int rem = Integer.MAX_VALUE;
        while(h > l){
            if(s[m] < n)
                l = m;
            
            if(s[m] == n)
               return 0;
              
            if(s[m] > n){
               h = m;
               if(m == 0)
               return s[m]-n;
               else{
                if(s[m]-n < s[m-1]-n)
                   return s[m]-n;
                
                   

               }
        }
    }
    return rem;
}}