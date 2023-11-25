import java.util.Arrays;
import java.util.List;

public class BacktrackingProbs {
    public static void main(String[] args) {
        climbStairs(4);
        campSite(2, 1);
        makeChangeCombos(15);
        System.out.println(makeChange(15));
        // System.out.println(getMax (Arrays.asList(7, 30, 8, 22, 6, 1, 14) , 19));
    }
    
    static String printBinary(int n) {
        return printBinaryHelper(n, "");
    }
    static String printBinaryHelper(int n, String s){
        if(s.length() == n)
            return s + " ";
        return printBinaryHelper(n, s+0) + printBinaryHelper(n, s+1);
        
    }
   static void climbStairs(int steps){
         climbStairsHelper(steps, "");
    }
    static void climbStairsHelper(int steps, String soFar){
        if(steps >= 0){
            if(steps == 0)
                System.out.println(soFar.substring(1));
            
            climbStairsHelper(steps-1, soFar+", 1");
            climbStairsHelper(steps-2, soFar+", 2");
        }
    }
    static void campSite(int x, int y){
        campSiteHelper(x, y, "");
    }
   static void campSiteHelper(int x, int y, String soFar){
    if(x == 0 && y == 0){
        System.out.println(soFar);
        return;
    }
    if(x > 0) campSiteHelper(x-1, y, soFar+"E "); 
    if(y > 0) campSiteHelper(x, y-1, soFar+"N ");
    if(x > 0 && y > 0) campSiteHelper(x-1, y-1, soFar+"NE ");
    }
    static int getMax(List<Integer> nums, int limit){
        return getMaxHelper(nums, limit, 0,0);
    }
    static int getMaxHelper(List<Integer> nums, int limit, int i, int max){
        if(i == nums.size()) return max;
        else if(max > limit) return -1000;

        max =  Math.max(getMaxHelper(nums, limit, i+1, max+nums.get(i)), getMaxHelper(nums,limit, i+1, max));
        if(max > limit) max-= nums.get(i);

        return max;
    }
    static int makeChange(int amount){
        return makeChangeHelper(new int[]{1,5,10,25}, 0, amount);
    }

    static int makeChangeHelper(int[] coins, int coin, int amount) {// intuition: we can generate unique combos by using current coin or skipping current coin
        if (amount < 0 || coin>= coins.length) return 0; // do nothing
        if (amount == 0) return 1;// combo found
        return  makeChangeHelper(coins, coin, amount - coins[coin]) + makeChangeHelper(coins, coin+ 1, amount); // sum of combos with and without current coin
    } // the first call finds all the combos with the current coin and  second recursive call just progresses the for loop

    static void makeChangeCombos(int amounts){
        System.out.println(" P  N  D  Q\n" + "------------");
        makeChangeCombosHelper(new int[] {1,5,10,25}, 0, amounts, new int []{0,0,0,0});
    }
    static void makeChangeCombosHelper(int[] coins, int coin, int amount, int [] combo){
        if(amount >= 0 && coin < coins.length){
        if (amount == 0){ 
            System.out.println(Arrays.toString(combo));
            return;
        }
        makeChangeCombosHelper(coins, coin + 1, amount, combo);// skip coin
        combo[coin]++; // increment current coin type
        makeChangeCombosHelper(coins, coin, amount - coins[coin], combo); // include coin
        combo[coin]--; // when recursively going back set combo back to normal
    }
    }
}

