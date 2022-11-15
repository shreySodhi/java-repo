// import java.util.Scanner;
// import java.util.Arrays;
// class roompainting{
//     public static void main(String [] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         sc.nextLine();
//         int [] sizes = new int[n];
//         for(int x = 0; x < sizes.length;x++){
//             sizes[x] = sc.nextInt();
//         }
//         Arrays.sort(sizes);
        
//         int sum = 0;
//         for(int x = 0; x < m;x++){
//             int y = sc.nextInt();
//             sum+=search(y, sizes);
           
//         }
//         System.out.println(sum);
//     }
//     static int search(int n, int[] s ){
//         int h = s.length;
//         int l = 0;
//         int m = ((h+l)/2);
//         int rem = Integer.MAX_VALUE;
//         while(h > l){
//             if(s[m] < n)
//                 l = m;
            
//             if(s[m] == n)
//                return 0;
              
//             if(s[m-1] > n){
//                h = m;
//                if(rem > s[m]-n){
//                    rem = s[m]-n;
//                }
//                else 
//                     return rem;
//         }
//     }
//     return rem;
// }} 
import java.util.Scanner;
import java.util.Arrays;
class roompainting{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] sizes = new int[n];
        for(int x = 0; x < sizes.length;x++){
            sizes[x] = sc.nextInt();
        }
        Arrays.sort(sizes);
        
        int sum = 0;
        for(int x = 0; x < m;x++){
           int y = 0;
           int f = sc.nextInt();
           while(sizes[y] <= f){
               y++;
           }
           sum+=(sizes[y]-f );
        }
        System.out.println(sum);
    }
}
   