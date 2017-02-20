import java.util.Scanner;
import java.util.Random;
public class Generate {
	//Method to generate random graph
	static int[][] generate(int nodeSize,int[][] a){ 
		for(int i=0;i<nodeSize;i++){
			for(int j=0;j<nodeSize;j++) 
				if(i==j)
					a[i][j]=0; 
				else if(i>j){
					int value=(int) (Math.random()*10);	
					if(value>0){
						a[i][j]=value;
					}
					else{
						a[i][j]=value+1;
					}
					a[j][i]=a[i][j];
				}
				/*else{
					a[i][j]=Integer.MAX_VALUE;
				}*/
		}
		for(int i=0; i<nodeSize;i++){
			for(int j=0; j<nodeSize; j++){
				if(i==j+1){
					a[i][j]=a[j][i];
				}
			}
			
		}
	
	//uncomment this section to print the graph
	                /*  for(int i=0;i<nodeSize;i++){
	                        //System.out.println(i);
	                        for (int j=0;j<nodeSize;j++){
	                        	System.out.print(a[i][j]+"\t");
	                        }
	                        System.out.println();
	                  }*/

	//uncomment end 
	return a;
	}
}
