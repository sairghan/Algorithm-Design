import java.util.Scanner;
import java.lang.Math;
import java.io.*;
public class FloydLink {
    int vertex;
    int weight;
    FloydLink next;
    
    public FloydLink(int vertex, int weight, FloydLink next) {
        super();
        this.vertex=vertex;
        this.weight=weight;
        this.next=next;
    }
    public int getVertex() {
        return vertex;
    }
    
    public void setVertex(int vertex) {
        this.vertex=vertex;
    }
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight=weight;
    }
    
    public FloydLink getNext() {
        return next;
    }
    
    public void setNext(FloydLink next) {
        this.next=next;
    }
}
