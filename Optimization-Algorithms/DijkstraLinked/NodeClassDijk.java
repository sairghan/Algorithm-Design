import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.io.*;
public class NodeClassDijk {
	int vertex;
    int weight;
    NodeClassDijk Dijnext;
    
    public NodeClassDijk(int vertex, int weight, NodeClassDijk next) {
        super();
        this.vertex=vertex;
        this.weight=weight;
        this.Dijnext=next;
    }
    
    public int getVertexGraph() {
        return vertex;
    }
    
    public int getValue() {
        return weight;
    }
    
    public void setValue(int weight) {
        this.weight=weight;
    }
    
    public NodeClassDijk getNext() {
        return Dijnext;
    }
    
    public void setNextNodeDijk(NodeClassDijk next) {
        this.Dijnext=next;
    }
}
