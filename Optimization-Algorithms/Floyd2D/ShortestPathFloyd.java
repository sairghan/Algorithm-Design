import java.util.Scanner;
import java.util.Random;
public class ShortestPathFloyd {
	//calculate shortest path
	public static int[][] shortestpath(int[][] adj, int[][] path) {
		int n = adj.length;
		int[][] ans = new int[n][n]; 
		//retain the input array 
		// out(ans, adj);
		//compute the shortest path by checking the new path with the
		for (int k=0; k<n;k++) {
			for (int i=0; i<n; i++) {
				for(int j=0;j<n;j++){
					if(ans[i][k]+ans[k][j]<ans[i][j]){
						ans[i][j]=ans[i][k]+ans[k][j];
						path[i][j]=path[k][j];
					}
				}
			} 
		}
		// return shortest path.
		return ans;
		}
    
	//Copy method to retain the original array
	/*public static void out(int[][] a, int[][] b) { 
		System.out.println("Adjacent Matrix Output: ");
		for (int i=0;i<a.length;i++){
			for (int j=0;j<a[0].length;j++) {
				a[i][j] = b[i][j];
				
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}*/
		
		 
}

