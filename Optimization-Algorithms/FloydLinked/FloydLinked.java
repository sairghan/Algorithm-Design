import java.util.Scanner;
import java.lang.Math;
public class FloydUseLinkedList {
    public static void main(String[] args) {
    int size=5;
    
    long startTime=System.currentTimeMillis();
    
    AdjMFloyd Adjmatrix=new AdjMFloyd(size);
    
    //long endTime=System.currentTimeMillis();
    
    
    Adjmatrix.printMatrixFloyd();
    long endTime=System.currentTimeMillis();
    floydAlgo(Adjmatrix.front);
    
    long endTime2=System.currentTimeMillis();
    System.out.println("Time to create adjacency matrix is: "+(endTime-startTime)/1000.00+" seconds");
    System.out.println("Time to generate input and compute shortest path: "+(endTime2-startTime)/1000+"seconds");
    System.out.println(("Total time: "+(((endTime-startTime)/1000)+((endTime2-startTime)/1000))+"seconds"));    
    }
    
     public static void floydAlgo(FloydLink[] front){ 
        int n=front.length; 
        for(int k=0;k<n;k++){ 
            for(int i=0;i<n;i++){ 
                
                FloydLink temp=front[i];  
                while(front!=null){ 
                    if(temp.getVertex()==k) 
                        break;
                    temp=temp.getNext();    
                }
                FloydLink id=front[k]; 
                
                while(id!=null){ 
                    FloydLink id1=front[i]; 
                    while(id1!=null){ 
                        if(id.getVertex()==id1.getVertex() && (temp.getWeight()+id.getWeight()<id1.getWeight())){ 
                            id1.setWeight(temp.getWeight()+id.getWeight());
                        }
                        id1=id1.getNext(); 
                    }
                    id=id.getNext(); 
                }
            }
        }
    }
}