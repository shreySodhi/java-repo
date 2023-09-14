import java.util.Scanner;
import java.util.Arrays;

class gallary{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int n = sc.nextInt();
		int[][] g = new int[r][2];
		int sum = 0;
		for(int x = 0; x < r;x++){
			for(int y = 0; y < 2;y++){
				g[x][y] = sc.nextInt();
				sum+=g[x][y];
			}
		}
		int o1 = sc.nextInt();
		int o2 = sc.nextInt();
		sc.close();
		for(int x = 0; x < n;x++){
			int min = Integer.MAX_VALUE;
			int ir = 0;
		    int ic = 0;
			for(int y = 0; y < r;y++){
				if(g[y][0]< min&& g[y][0]!= -1){
					ir = y;
					ic = 0;
					min = g[y][0];
				}
				if(g[y][1] < min && g[y][1] != -1){
					ir = y;
					ic = 1;
					min = g[y][1];
				}
			}
				//System.out.println(g[ir][ic]);
				sum-=g[ir][ic];
				g[ir][ic] = -1;
				g[ir][Math.abs(ic-1)] = -1;
				if(ir > 0)
					g[ir-1][Math.abs(ic-1)] = -1;
				if(ir < r-1)
					g[ir+1][Math.abs(ic-1)] = -1;			
		}
		System.out.println(sum);
		System.out.println();
		for(int x = 0; x < g.length;x++){
			for(int y = 0; y < g[x].length;y++){
				System.out.print(g[x][y]+ " ");
			}
			System.out.println();
		}
	}}
