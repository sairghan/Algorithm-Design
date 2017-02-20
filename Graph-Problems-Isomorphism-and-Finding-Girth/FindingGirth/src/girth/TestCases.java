package girth;
import java.util.Random;

public class TestCases {

	public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
		Graphdef basicGrph = new BasicGraph();
		
		//(Uncomment this section for random undirected graph implementation)
		/*int n=15000;   //Various number of nodes n=500,1000,....etc.
		int i,j;
		Random rand = new Random();
		for(i=1; i<=n; i++){
			j=rand.nextInt(n)+1;
			while (i==j)
				j=rand.nextInt(n)+1;
			basicGrph.addEdge(i, j);
		}*/
         		
		//testcase1 (Uncomment this section for Test Case 1 implementation)
		basicGrph.addEdge(1, 4);
		basicGrph.addEdge(1, 6);
		basicGrph.addEdge(4, 3);
		basicGrph.addEdge(4, 2);
		basicGrph.addEdge(6, 2);
		basicGrph.addEdge(2, 5);
		
        //testcase2 (Uncomment this section for Test Case 2 implementation)
        /*basicGrph.addEdge(1, 2);
        basicGrph.addEdge(1, 3);
        basicGrph.addEdge(1, 4);
        basicGrph.addEdge(1, 5);
		basicGrph.addEdge(1, 7);
        basicGrph.addEdge(1, 8);
        basicGrph.addEdge(1, 9);
        basicGrph.addEdge(1, 10);
        basicGrph.addEdge(1, 11);
        basicGrph.addEdge(1, 12);
        basicGrph.addEdge(1, 14);
        basicGrph.addEdge(1, 15);
        basicGrph.addEdge(2, 1);
        basicGrph.addEdge(2, 4);
        basicGrph.addEdge(2, 5);
        basicGrph.addEdge(2, 9);
        basicGrph.addEdge(2, 10);
        basicGrph.addEdge(2, 11);
        basicGrph.addEdge(2, 12);
        basicGrph.addEdge(2, 13);
        basicGrph.addEdge(2, 15);
        basicGrph.addEdge(3, 1);
        basicGrph.addEdge(3, 4);
        basicGrph.addEdge(3, 5);
        basicGrph.addEdge(3, 6);
        basicGrph.addEdge(3, 7);
        basicGrph.addEdge(3, 8);
        basicGrph.addEdge(3, 11);
        basicGrph.addEdge(3, 12);
        basicGrph.addEdge(3, 14);
        basicGrph.addEdge(4, 1);
        basicGrph.addEdge(4, 2);
        basicGrph.addEdge(4, 3);
        basicGrph.addEdge(4, 5);
        basicGrph.addEdge(4, 6);
        basicGrph.addEdge(4, 7);
        basicGrph.addEdge(4, 8);
        basicGrph.addEdge(4, 9);
        basicGrph.addEdge(4, 11);
        basicGrph.addEdge(4, 12);
        basicGrph.addEdge(4, 13);
        basicGrph.addEdge(4, 14);
        basicGrph.addEdge(5, 1);
        basicGrph.addEdge(5, 2);
        basicGrph.addEdge(5, 3);
        basicGrph.addEdge(5, 4);
        basicGrph.addEdge(5, 8);
        basicGrph.addEdge(5, 9);
        basicGrph.addEdge(5, 11);
        basicGrph.addEdge(5, 13);
        basicGrph.addEdge(5, 15);
        basicGrph.addEdge(6, 3);
        basicGrph.addEdge(6, 4);
		basicGrph.addEdge(6, 7);
        basicGrph.addEdge(6, 8);
        basicGrph.addEdge(6, 10);
        basicGrph.addEdge(6, 11);
        basicGrph.addEdge(6, 12);
        basicGrph.addEdge(6, 14);
        basicGrph.addEdge(7, 1);
         basicGrph.addEdge(7, 3);
         basicGrph.addEdge(7, 4);
         basicGrph.addEdge(7, 6);
         basicGrph.addEdge(7, 8);
         basicGrph.addEdge(7, 9);
         basicGrph.addEdge(7, 10);
         basicGrph.addEdge(7, 11);
         basicGrph.addEdge(7, 12);
         basicGrph.addEdge(7, 13);
         basicGrph.addEdge(7, 14);
         basicGrph.addEdge(7, 15);
        basicGrph.addEdge(8, 1);
        basicGrph.addEdge(8, 3);
        basicGrph.addEdge(8, 4);
        basicGrph.addEdge(8, 5);
        basicGrph.addEdge(8, 6);
        basicGrph.addEdge(8, 7);
        basicGrph.addEdge(8, 9);
        basicGrph.addEdge(8, 10);
        basicGrph.addEdge(8, 11);
        basicGrph.addEdge(8, 12);
        basicGrph.addEdge(8, 14);
        basicGrph.addEdge(8, 15);
         basicGrph.addEdge(9, 1);
         basicGrph.addEdge(9, 2);
         basicGrph.addEdge(9, 4);
         basicGrph.addEdge(9, 5);
         basicGrph.addEdge(9, 7);
         basicGrph.addEdge(9, 8);
         basicGrph.addEdge(9, 10);
         basicGrph.addEdge(9, 11);
         basicGrph.addEdge(9, 15);
         basicGrph.addEdge(10, 1);
         basicGrph.addEdge(10, 2);
         basicGrph.addEdge(10, 6);
         basicGrph.addEdge(10, 7);
         basicGrph.addEdge(10, 8);
         basicGrph.addEdge(10, 9);
         basicGrph.addEdge(10, 11);
         basicGrph.addEdge(10, 12);
         basicGrph.addEdge(10, 13);
         basicGrph.addEdge(10, 14);
         basicGrph.addEdge(11, 1);
         basicGrph.addEdge(11, 2);
         basicGrph.addEdge(11, 3);
         basicGrph.addEdge(11, 4);
         basicGrph.addEdge(11, 5);
         basicGrph.addEdge(11, 6);
         basicGrph.addEdge(11, 7);
         basicGrph.addEdge(11, 8);
         basicGrph.addEdge(11, 9);
         basicGrph.addEdge(11, 10);
         basicGrph.addEdge(11, 12);
         basicGrph.addEdge(11, 13);
         basicGrph.addEdge(11, 14);
         basicGrph.addEdge(11, 15);
         basicGrph.addEdge(12, 1);
        basicGrph.addEdge(12, 2);
        basicGrph.addEdge(12, 3);
        basicGrph.addEdge(12, 4);
        basicGrph.addEdge(12, 6);
        basicGrph.addEdge(12, 7);
        basicGrph.addEdge(12, 8);
        basicGrph.addEdge(12, 10);
        basicGrph.addEdge(12, 11);
        basicGrph.addEdge(12, 13);
        basicGrph.addEdge(12, 14);
        basicGrph.addEdge(12, 15);
        basicGrph.addEdge(13, 2);
        basicGrph.addEdge(13, 4);
        basicGrph.addEdge(13, 5);
        basicGrph.addEdge(13, 7);
        basicGrph.addEdge(13, 10);
        basicGrph.addEdge(13, 11);
        basicGrph.addEdge(13, 12);
        basicGrph.addEdge(13, 15);
        basicGrph.addEdge(14, 1);
        basicGrph.addEdge(14, 3);
        basicGrph.addEdge(14, 4);
        basicGrph.addEdge(14, 6);
        basicGrph.addEdge(14, 7);
        basicGrph.addEdge(14, 8);
        basicGrph.addEdge(14, 10);
        basicGrph.addEdge(14, 11);
        basicGrph.addEdge(14, 12);
        basicGrph.addEdge(14, 15);
        basicGrph.addEdge(15, 1);
        basicGrph.addEdge(15, 2);
        basicGrph.addEdge(15, 5);
        basicGrph.addEdge(15, 7);
        basicGrph.addEdge(15, 8);
        basicGrph.addEdge(15, 9);
        basicGrph.addEdge(15, 11);
        basicGrph.addEdge(15, 12);
        basicGrph.addEdge(15, 13);
        basicGrph.addEdge(15, 14); */
        DefaultGraph defGraph = new DefaultGraph(basicGrph);
		
		System.out.println("Girth of given graph G is:  " +defGraph.getGirth()); 
        long stoptime = System.currentTimeMillis();
        long elapsedTime = stoptime - starttime;
       System.out.println("Time elapsed:  "  +elapsedTime); 
        
		
	}

}
