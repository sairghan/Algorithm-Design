import java.lang.Integer; 
import java.util.Scanner;  
public class DijkstraTwoD {  
 // Method to generate random graph  
 static int[][] generate(int nodeSize, int[][] a) {   
 for (int i = 0; i < nodeSize; i++)    
 for (int j = 0; j < nodeSize; j++)     
     if (i == j)      
     a[i][j] = 0;     
     else if (i > j) {      
     int value = (int) (Math.random() * 10);      
     if (value > 0)       
         a[i][j] = value;     
     else       a[i][j] = value + 1;      
 a[j][i] = a[i][j];     }   // uncomment this section to generate a sparse graph   
 /*    * else a[i][j]=Integer.MAX_VALUE;    */  
  for(int i=0; i<nodeSize;i++){
			for(int j=0; j<nodeSize; j++){
				if(i==j+1){
					a[i][j]=a[j][i];
				}
			}
			
		
	
	//uncomment this section to print the graph
	                  for(i=0;i<nodeSize;i++){
	                        System.out.println(i);
	                        for (int j=0;j<nodeSize;j++){
	                        	System.out.print(a[i][j]+"\t");
	                        }
	                        System.out.println();
	                  }

	//uncomment end 
	}
     return a;
}

 
 public static void main(String[] args) {  
     Scanner stdin = new Scanner(System.in);
  int max = Integer.MAX_VALUE;  
  //initialize the graph size.      //For different executions I have used different values like 100, 500, 1000, 3000, etc    
  int size = 5;   
  //int[][] a = new int[size][size];      //For calculating time stamp   
     int[][] a =new int[][] {{10000,7,10000,18,15},{7,10000,11,7,5},{10000,11,10000,29,10000},{18,7,29,10000,18},{15,5,10000,18,10000}};
  double startTime=System.currentTimeMillis();     
  //a = generate(size, a); 
     double endTime=System.currentTimeMillis();      
     System.out.println("Time to create Adjacency Matrix: "+(endTime-startTime)/1000+"seconds");  
  int n = a.length;  
  int i;  
  int reference_node = 1;   
  int vnear = 0;   
  int e;  
  int F = 0;   
  int touch[] = new int[n + 1];   
     int length[] = new int[n + 1];  
  // For all vertices,initialize v0 to be the last vertex on the current shortest path from v0    // and initialize length of that path to be the weight on the edge form v0   
  for (i = 1; i < n; i++) {    
  touch[i] = 0;    
  reference_node = touch[i];    
  length[i] = a[0][i];  
  }   // Repeat n-1 times ---Add all n-1 vertices to Y  
  for (int j = 1; j < n; j++) {  
   int min = Integer.MAX_VALUE;  
   for (i = 1; i < n; i++) {  
    if ((0 <= (length[i])) && (length[i] < min)) {      
    min = length[i];      
    vnear = i;     }    }    // System.out.println("The shortest distance between node"+(reference_node)+" and node-"+(vnear)+" is : "+min);    
    // e is the edge from vertex indexed by touch[vnear] to vertex indexed by vnear   
    e = a[vnear][touch[vnear]];  
   F = F + e;    
   for (int k = 1; k < n; k++) {     
   if ((length[vnear] + a[vnear][k]) < length[k]) {      
   length[k] = length[vnear] + a[vnear][k];      
   touch[k] = vnear;     }  
   }  
   length[vnear] = -1;  
  }   
  double endTime2=System.currentTimeMillis();      
  System.out.println("Time to generate input and compute shortest path: "+(endTime2-startTime)/1000+"seconds"); 
     System.out.println(("Total time: "+(((endTime-startTime)/1000)+((endTime2-startTime)/1000))+"seconds"));  
 } }   
