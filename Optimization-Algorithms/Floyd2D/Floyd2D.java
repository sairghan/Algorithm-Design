import java.util.Scanner;
public class Floyd2D {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		//initialize the size of graph.
		//Size varies from 100, 1000, 2000, 3000, 4000, 6000 etc
		
		int size=6000;
		int[][] a = new int[size][size];
		//int[][] a =new int[][] {{10000,7,0,18,15},{7,10000,11,7,5},{10000,11,10000,29,10000},{18,7,29,10000,18},{15,5,10000,18,10000}};
		//int[][] a= new int[][]{{10000,10000,10000,10000,10000,10000,10000,10000,10000,8,10000,10000},{10000,10000,17,13,10000,10000,10000,17,12,10000,10000,10000},{10000,17,10000,10000,10000,10000,10000,10000,10000,7,10000,9},{10000,13,10000,10000,10000,10000,15,10000,10000,13,5,13},{10000,10000,10000,10000,10000,18,10000,10000,5,10000,10000,10000},{10000,10000,10000,10000,18,10000,10000,17,10000,10000,10000,10000,10000},{10000,10000,10000,15,10000,10000,10000,17,10000,10000,8,11},{10000,17,10000,10000,10000,17,17,10000,10000,10000,10000,10000},{10000,12,10000,10000,5,10000,10000,10000,10000,10000,15,10000},{8,10000,7,13,10000,10000,10000,10000,10000,10000,10000,14},{10000,10000,10000,5,10000,10000,8,10000,15,10000,10000,10000},{10000,10000,9,13,10000,10000,11,10000,10000,14,10000,10000}};
		//int[][] a =new int[][] {{0,3,6,15},{10000,0,-2,10000},{10000,10000,0,2},{1,10000,10000,0}};
		//time stamp
		double startTime=System.currentTimeMillis(); 
		
		a=Generate.generate(size,a);
		
		double endTime=System.currentTimeMillis();
		
		
		int[][] shortpath;
		int[][] path = new int[size][size];
		
		///Marking the inputs
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				if (a[i][j] == 0) 
					path[i][j] = -1;
				else
					path[i][j] = i; 
				if (a[i][j]!=-1)
					path[i][j] = i; 
			}
		}
		
		for (int i=0; i<size; i++){
				path[i][i] = i;
		}
		shortpath = ShortestPathFloyd.shortestpath(a, path);
		
		double endTime2=System.currentTimeMillis();
		
		
	
		//Print the output
		//Uncomment the following code to print the output and to print the shortest path
		/*System.out.println("Shortest Path matrix:");
		for (int i=0; i<size;i++) {
		            for (int j=0; j<size;j++){
		            	System.out.print(shortpath[i][j]+" "); 
		            	
		            }
		            System.out.println();
		}*/
		System.out.println("Time to create Adjacency Matrix: "+(endTime- startTime)/1000+"seconds");
		System.out.println("Time to calculate shortest path: "+(endTime2-startTime)/1000+"seconds");
		System.out.println(("Total time: "+(((endTime-startTime)/1000)+((endTime2-startTime)/1000))+"seconds"));
		//System.out.println("Enter source and destination vertices:"); 
		
		int One = stdin.nextInt();
		int Two = stdin.nextInt();
		
		String myPath = Two + "";
		
		int sum=0;
		int flag=0;
		
		while (path[One][Two] != One) {
		      flag=1;
		      myPath = path[One][Two] + " -> " + myPath;
		      sum+=shortpath[One][Two]; //OneD
		      Two = path[One][Two];
		}
		
		if (flag==0)
		      sum=shortpath[One][Two]; //OneD
		myPath = One + " -> " + myPath; 
		
		System.out.println("Shortest Path: "+myPath);
		System.out.println("Distance: "+sum);  
		}
}


