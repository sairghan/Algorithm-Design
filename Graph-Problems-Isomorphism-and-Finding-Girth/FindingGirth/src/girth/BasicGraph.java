package girth;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class BasicGraph implements Graphdef
{
    
    private Map<Integer, ArrayList<Integer>> neighbours;

   
    public BasicGraph()
    {
        neighbours = new HashMap<Integer, ArrayList<Integer>>();
    }

    @Override
    public boolean addEdge(int v0, int v1)
    {
   
        ArrayList<Integer> neighbours0 = neighbours.get(v0),
                neighbours1 = neighbours.get(v1);

   
        if(neighbours0 == null)
            neighbours.put(v0, neighbours0 = new ArrayList<Integer>());
        if(neighbours1 == null)
            neighbours.put(v1, neighbours1 = new ArrayList<Integer>());

        
        if(neighbours0.contains(v1)) {
            return false;
        
        } else {
            neighbours0.add(v1);
            neighbours1.add(v0);
            return true;
        }
    }

    @Override
    public boolean removeEdge(int v0, int v1)
    {
      
        ArrayList<Integer> neighbours0 = neighbours.get(v0),
                neighbours1 = neighbours.get(v1);

        if(neighbours0 == null || neighbours1 == null)
            return false;

      
        if(neighbours0.contains(v1)) {
            neighbours0.remove(new Integer(v1));
            neighbours1.remove(new Integer(v0));
            return true;
    
        } else {
            return false;
        }
    }

    @Override
    public boolean removeVertex(int v)
    {
        
        ArrayList<Integer> vNeighbours = neighbours.get(v);

            if(vNeighbours == null)
            return false;

           for(Integer i: vNeighbours) {
            neighbours.get(i).remove(new Integer(v));
        }

             neighbours.remove(v);
        return true;
    }

    @Override
    public List<Integer> getVertices()
    {
     
        List<Integer> list = new ArrayList<Integer>();
        for(Integer i: neighbours.keySet())
            list.add(i);
        return list;
    }

    @Override
    public List<Integer> getNeighbours(int v)
    {
        return neighbours.get(v);
    }
}