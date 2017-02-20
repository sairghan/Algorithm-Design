package girth;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


public class DefaultGraph
{
  
    private Vertices[] vertices;

   
    private int numberOfEdges;

    
    private Ordering[][] orders;

    
    public int girth;

    
    public DefaultGraph(final Graphdef graph)
    {
       
        Map<Integer, Integer> translation = new HashMap<Integer, Integer>();
        vertices = new Vertices[graph.getVertices().size()];

        orders = new Ordering[vertices.length][vertices.length];

        
        List<Integer> sortedVertices = graph.getVertices();
        sort(sortedVertices, graph);

      
        int index = 0;
        for(int id: sortedVertices) {
            translation.put(id, index);
            vertices[index] = new Vertices(index, orders);
            index++;
        }

        for(int id: graph.getVertices()) {
            Vertices vertex = vertices[translation.get(id)];
            ArrayList<Vertices> neighbours = new ArrayList<Vertices>();

            for(int neighbourId: graph.getNeighbours(id)) {
                Vertices neighbour = vertices[translation.get(neighbourId)];
                neighbours.add(neighbour);
                numberOfEdges++;
            }

            vertex.setNeighbours(neighbours);
        }

  
        Girthcalc findGirth = new Girthcalc();
        girth = findGirth.findGirth(this);
    }

    
    public int getNumberOfVertices()
    {
        return vertices.length;
    }

    
    public int getVertexWithCandidates()
    {
        for(int i = 0; i < vertices.length; i++) {
            if(vertices[i].hasCandidates())
                return i;
        }

        return -1;
    }

    
    public Vertices getVertex(int id)
    {
        return vertices[id];
    }

    
    public int getNumberOfEdges()
    {
        return numberOfEdges;
    }

    
    public boolean hasEdge(int v0, int v1)
    {
        return v0 >= 0 && v1 >= 0 && orders[v0][v1] != null;
    }

    
    public boolean isCompleteGraph()
    {
        int completeEdges = (vertices.length - 1) * vertices.length;
        return numberOfEdges == completeEdges;
    }

    
    public int getGirth()
    {
        return girth;
    }

    
    public void sort(List<Integer> vertices, final Graphdef graph)
    {
    }
}