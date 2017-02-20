package girth;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

/** A graph vertex.
 */
public class Vertices implements Comparable
{
   
    private int id;

    private int[] neighbours;

 
    private Ordering[][] orders;

    
    private int numberOfOrders;

   
    private boolean candidates;

   
    public Vertices(int id, Ordering[][] orders)
    {
        this.id = id;
        this.orders = orders;
    }

    
    public int[] getNeighbours()
    {
        return neighbours;
    }

    
    public void setNeighbours(ArrayList<Vertices> neighbours)
    {
        this.neighbours = new int[neighbours.size()];
        for(int i = 0; i < this.neighbours.length; i++)
            this.neighbours[i] = neighbours.get(i).getId();

        for(Vertices neighbour: neighbours) {
            Ordering order = new Ordering(neighbour.getId());
            orders[id][neighbour.getId()] = order;
        }

        numberOfOrders = neighbours.size();

        candidates = this.neighbours.length >= 1;
    }

    
    public int getId()
    {
        return id;
    }
  
    public boolean hasCandidates()
    {
        return candidates;
    }


    public boolean connect(int from, int destination)
    {
        if(from < 0)
            return true;

        if(numberOfOrders > 1) {
            Ordering fromOrder = orders[id][from],
                    destinationOrder = orders[id][destination];

            if(fromOrder.getFirst() == destinationOrder.getFirst()) {
                return false;
            } else {
                numberOfOrders--;

                
                fromOrder.append(destinationOrder);
            }
        } else {
            candidates = false;
        }

        return true;
    }

   
    public void split(int from, int destination)
    {
        if(from < 0)
            return;

        if(!candidates) {
            candidates = true;
        } else {
            Ordering fromOrder = orders[id][from];
            fromOrder.split();

            numberOfOrders++;
        }
    }

   
    public boolean isCandidate(int from, int destination)
    {
        if(from < 0 || numberOfOrders == 1) {
           
            return orders[id][destination].getFirst().getValue() ==
                    destination;
        } else {
            
            return orders[id][destination].getFirst().getValue() ==
                    destination &&
                    destination != orders[id][from].getFirst().getValue();
        }
    }

 
    public int getCandidate()
    {
        return orders[id][neighbours[0]].getFirst().getValue();
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object object)
    {
        return (object instanceof Vertices) && ((Vertices) object).id == id;
    }

    @Override
    public int compareTo(Object object)
    {
        return id - ((Vertices) object).id;
    }
}