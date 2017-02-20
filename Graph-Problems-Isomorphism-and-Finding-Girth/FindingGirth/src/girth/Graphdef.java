package girth;

import java.util.List;

public interface Graphdef {

  public boolean addEdge(int v0, int v1);

  public boolean removeEdge(int v0, int v1);

  public boolean removeVertex(int v);

  public List<Integer> getVertices();
 
  public List<Integer> getNeighbours(int v);


}