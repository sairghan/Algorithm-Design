
public class DijkstraLinked {

	public static void main(String[] args) {
        int size=100;
        
        long startTime=System.currentTimeMillis();
        AdjMatrixDijk matAdj=new AdjMatrixDijk(size);
        long endTime=System.currentTimeMillis();
        long time1=endTime-startTime;
        
        matAdj.printMatrixFloyd();
        Path(matAdj.front);
        long endTime2=System.currentTimeMillis();
        long time2=endTime2-startTime;
        System.out.println("Time to create adjacency matrix is: "+time1/1000.00+" seconds;");
        System.out.println("Time to generate input and compute shortest path:"+time2/1000.00+" seconds");
        System.out.println("Total time: "+(time1+time2)/1000.00+" seconds");
    }
    
    public static void Path(NodeClassDijk[] frontList) {
        for(int i=0;i<frontList.length;i++){
            algoDijkstra(frontList,i);
            }
    }
    public static void algoDijkstra(NodeClassDijk[] frontList, int start) {
        int n=frontList.length;
        String[] Dijpaths=new String[n];
        boolean[] Checked=new boolean[n];
        for(int i=0;i<n;i++){
        	Dijpaths[i]=new String(start+"->"+i);
        	}
        Checked[start]=true;
        
        for(int i=1;i<=n;i++) {
        	int k=-1;
            int min=Integer.MAX_VALUE;
            NodeClassDijk index=frontList[start];
            while(index!=null) {
            {
                if(!Checked[index.getVertexGraph()] && index.getValue()<min) {
                    min=index.getValue();
                    k=index.getVertexGraph();
                }
                else{
                	break;
                }
            }		
            Checked[k]=true;
                    NodeClassDijk id=frontList[k].getNext();
                    while(id!=null) {
                    	NodeClassDijk id1=frontList[start].getNext();
                        while(id!=null) {
                            if(id1.getVertexGraph()==id.getVertexGraph() && id1.getValue()>(min+id.getValue())) {
                                id1.setValue(min+id.getValue());
                                Dijpaths[id1.getVertexGraph()]=Dijpaths[k]+"->"+id1.getVertexGraph();
                            }
                            id1=id1.getNext();
                        }
                        id=id.getNext();
                    }
                }
    }
    }

}
