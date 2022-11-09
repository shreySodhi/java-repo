public class t{
	public static void main(String[] args){
		
		int[][] a ={{3, 5}, {6, 8}};
		sumRows(a);
		
		

	}
	public static void sumRows(int[][] num){
		for (int[] r : num){
			int sum = 0;
			
			for (int j = 0; j < num.length; j++){
				sum += r[j];
			}
			System.out.print(sum + " ");
		}
	}
	// public static void Rows(int[] a){
	// 	for(int x = 0; x < a.length;x++)
	// 		System.out.println(a[x]);
	// }

}