package girth;

import java.util.Queue;
import java.util.LinkedList;

public class Girthcalc
{
    
    public Girthcalc()
    {
    }

    
    public int findGirth(DefaultGraph graph)
    {
        
        class Node
        {
            public int vertex, depth;

            public Node(int vertex, int depth)
            {
                this.vertex = vertex;
                this.depth = depth;
            }
        }

      
        int[] labels = new int[graph.getNumberOfVertices()];

       
        int best = graph.getNumberOfVertices() - 1;

       
        Queue<Node> queue = new LinkedList<Node>();

        
        int root = 0;
        while(root < graph.getNumberOfVertices() - 2 && best > 3) {

            /* Reset labels. */
            for(int i = 0; i < labels.length; i++)
                labels[i] = -1;

          
            labels[root] = 0;
            queue.add(new Node(root, 0));
    
           
            Node node = queue.poll();
            while(node != null && best > 3 && (node.depth + 1) * 2 - 1 < best) {

                
                int depth = node.depth + 1;

                
                for(int neighbour:
                            graph.getVertex(node.vertex).getNeighbours()) {
                   
                    if(labels[neighbour] < 0) {
                        queue.add(new Node(neighbour, depth));
                        labels[neighbour] = depth;
                    
                    } else if(labels[neighbour] == depth - 1) {
                        if(depth * 2 - 1 < best)
                            best = depth * 2 - 1;
                    
                    } else if(labels[neighbour] == depth) {
                        if(depth * 2 < best)
                            best = depth * 2;
                    }
                }

                
                node = queue.poll();
            }

          
            queue.clear();
            root++;
        }

     
        return best > 0 ? best : 1;
    }
}