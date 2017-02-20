public class DijkstraOneD {    
//Method to generate random graph    
static int[][] generate(int nodeSize,int[][] a){   
for(int i=0;i<nodeSize;i++)    
for(int j=0;j<nodeSize;j++)     
if(i==j)      
a[i][j]=0;     
else if(i>j){      
int value=(int) (Math.random()*10);      
if(value>0)       
a[i][j]=value;      
else       
a[i][j]=value+1;      
a[j][i]=a[i][j];     }   //uncomment this section to generate a sparse graph     /*else      a[i][j]=Integer.MAX_VALUE;*/      
/*for(int i=0;i<nodeSize;i++)    
for(int j=0;j<nodeSize;j++)     
if(i==j+1)      
a[i][j]=a[j][i];*/   //uncomment - end      //uncomment this section to print the graph 
  /*for(int i=0;i<nodeSize;i++){    
  //System.out.println(i);    
  for (int j=0;j<nodeSize;j++)     
  System.out.print(a[i][j]+"\t");    
  System.out.println();   }*/   //uncomment end   
  return a;     }  
 public static void main(String[] args){      //initialize the graph size.      //For different executions I have used different values like 100, 500, 1000, 3000, etc    
 int size=200;   
 int[][]a = new int[size][size];      //For calculating time stamp      
 double startTime=System.currentTimeMillis();      //generate a random graph   a=generate(size,a);      //Initialize start vertex to required value to get shortest path from that vertex    
 int start=1;      //Copy the lower triangular matrix   
 int[] oneD=new int[size*2];   
 for(int i=0;i<size;i++)    
 for(int j=0;j<size;j++){     
 System.out.println(i+j);     
 System.out.println(i*(i-1)/2);     
 oneD[i*(i-1)/2]=a[i][j];    }      
 double endTime=System.currentTimeMillis();     
 System.out.println("Time to create Adjacency Matrix: "+(endTime-startTime)/1000+"seconds");     
 String[] path=new String[size];   boolean[] prev=new boolean[size];      //Dijkstra algorithm to find the shortest path from start vertex   
 for(int i=0;i<size;i++)    path[i]=new String(start+"->"+i);   prev[start]=true;      
 for(int j=1;j<size-1;j++){   
 int k=-1;    
 int min=Integer.MAX_VALUE;    
 for(int i=0;i<size;i++){     
 if(!prev[i] && oneD[i*(i-1)/2+start]<min){      
 min=oneD[i*(i-1)/2+start];      
 k=i;     }    }   
 prev[k]=true;    
 for(int i=0;i<size;i++){ 
    if(!prev[i] && oneD[k*(k-1)/2+start]+oneD[k*(k-1)/2+k]<oneD[k*(k-1)/2+start]){      
    oneD[i*(i-1)/2+start]=oneD[i*(i-1)/2+start]+oneD[i*(i-1)/2+k];     
    path[i]=path[i]+"->"+"i";     }    }   }      
    double endTime2=System.currentTimeMillis();      
    System.out.println("Time to generate input and compute shortest path: "+(endTime2-startTime)/1000+"seconds");      
    System.out.println(("Total time: "+(((endTime-startTime)/1000)+((endTime2-startTime)/1000))+"seconds"));         
    /*for(int i=0;i<size;i++)    
    System.out.println("Path from "+start+" to "+i+": "+path[i]);*/  
 } }  

