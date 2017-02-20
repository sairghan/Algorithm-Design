import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class AdjMFloyd {
    int size=0;
    Random random;
    FloydLink[] front;
    
    AdjMFloyd(int size) {
        this.size=size;
        random=new Random();
        front=new FloydLink[size];
        front=generateMatrixFloyd(front);
    }
    
    public FloydLink[] generateMatrixFloyd(FloydLink[] frontList) {
        FloydLink[] back=new FloydLink[frontList.length];
        for(int i=0;i<frontList.length;i++) {
            frontList[i]=new FloydLink(i,0,null);
            back[i]=frontList[i];
        }
        for(int i=0;i<frontList.length;i++)
            for(int j=frontList.length-1;j>=i;j--) {
                if(i==j)
                    continue;
                else {
                    int value=random.nextInt(9)+1;
                    FloydLink node1=new FloydLink(j,value,null);
                    FloydLink node2=new FloydLink(i,value,null);
                    back[i].setNext(node1);
                    back[j].setNext(node2);
                    back[i]=node1;
                    back[j]=node2;
                }
            }
        return frontList;
    }
    public void printMatrixFloyd() {
        for(int i=0;i<front.length;i++) {
            FloydLink temp=front[i];
            while(temp!=null) {
                System.out.println(temp.getVertex()+"'"+temp.getWeight()+" ");
                temp=temp.getNext();
            }
            System.out.println();
        }
    }
}