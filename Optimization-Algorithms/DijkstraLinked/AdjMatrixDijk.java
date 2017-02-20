import java.util.*;
import java.util.Random;
import java.util.Scanner;
public class AdjMatrixDijk {
	int size=0;
    Random random;
    NodeClassDijk[] front;
    
    AdjMatrixDijk(int size) {
        this.size=size;
        random=new Random();
        front=new NodeClassDijk[size];
        front=generateMatrix(front);
    }
    public NodeClassDijk[] generateMatrix(NodeClassDijk[] frontList) {
    	NodeClassDijk[] back=new NodeClassDijk[frontList.length];
        for(int i=0;i<frontList.length;i++) {
            frontList[i]=new NodeClassDijk(i,0,null);
            back[i]=frontList[i];
        }
        for(int i=0;i<frontList.length;i++)
            for(int j=frontList.length-1;j>=i;j--) {
                if(i==j)
                    continue;
                else {
                    int value=random.nextInt(9)+1;
                    NodeClassDijk node1=new NodeClassDijk(j,value,null);
                    NodeClassDijk node2=new NodeClassDijk(i,value,null);
                    back[i].setNextNodeDijk(node1);
                    back[j].setNextNodeDijk(node2);
                    back[i]=node1;
                    back[j]=node2;
                }
            }
        return frontList;
    }
    public void printMatrixFloyd() {
        for(int i=0;i<front.length;i++) {
        	NodeClassDijk temp=front[i];
            while(temp!=null) {
                System.out.println(temp.getVertexGraph()+"'"+temp.getValue()+" ");
                temp=temp.getNext();
            }
            System.out.println();
        }
    }
}
