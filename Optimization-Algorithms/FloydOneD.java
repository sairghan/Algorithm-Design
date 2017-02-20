public class FloydOneD {    //Generating random graph  
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
a[j][i]=a[i][j];     }   //uncoment to generate sparse graph     /*else      a[i][j]=Integer.MAX_VALUE;*/      
/*for(int i=0;i<nodeSize;i++)    
for(int j=0;j<nodeSize;j++)    
if(i==j+1)      
a[i][j]=a[j][i];*/   //uncomment - end      
//uncomment to display the graph   
/*for(int i=0;i<nodeSize;i++){    
//System.out.println(i);    
for (int j=0;j<nodeSize;j++)     
System.out.print(a[i][j]+"\t");    
System.out.println();   }*/   //uncomment end      
return a;  }    
public static void main(String[] args){      //initialize the graph size.      //For different executions I have used different values like 100, 1000, 3000, etc   
int size=1000;   
int n=size;   
int[][]a = new int[size][size];      //For calculating time stamp      
double startTime=System.currentTimeMillis();      //generate a random graph   
a=generate(size,a);      //Create output array   
int[] oneD=new int[size*size];   
int[] next=new int[size*size]; 
     //Copy the lower triangular matrix to 1D array   
     for(int i=0;i<size;i++)    
     for(int j=0;j<size;j++){     
     //System.out.println(i+j);     
     //System.out.println(i*(i-1)/2);     
     oneD[i*(i-1)/2]=a[i][j];    }      
     double endTime=System.currentTimeMillis();      
     System.out.println("Time to create Adjacency Matrix: "+(endTime-startTime)/1000+"seconds");        
     for(int i=0;i<n;i++){    
     for (int j=0;j<n;j++){     
     if(i==n-1 && j==n-1){      
     continue;     }     
     next[i*(i-1)/2+j]=j;    }   }      //Computing Floyd's algorithm   
     for(int k=0;k<n;k++){    
     for(int i=0;i<n;i++){     
     for(int j=0;j<n;j++){     
     if(i==j || (i==n-1 && j==n-1) || (i==n-1 && k==n-1) || (j==n-1 && k==n-1)){       
     continue;      }      
     if(oneD[i*(i-1)/2+j]>oneD[i*(i-1)/2+k]+oneD[k*(k-1)/2+j]){       
     oneD[i*(i-1)/2+j]=oneD[i*(i-1)/2+k]+oneD[k*(k-1)/2+j];      
     next[i*(i-1)/2+j]=next[i*(i-1)/2+k];      }     }    }   }     
     double endTime2=System.currentTimeMillis();      
     System.out.println("Time to generate input and compute shortest path: "+(endTime2-startTime)/1000+"seconds");      
     System.out.println(("Total time: "+(((endTime-startTime)/1000)+((endTime2-startTime)/1000))+"seconds"));     } }  