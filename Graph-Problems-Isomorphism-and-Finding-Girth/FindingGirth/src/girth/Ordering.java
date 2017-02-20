package girth;


public class Ordering
{
  
    private int value;

    
    private Ordering next;

   
    private Ordering first;

    private Ordering last;

      public Ordering(int value)
    {
        this.value = value;
        next = null;
        first = last = this;
    }


    public int getValue()
    {
        return value;
    }

 
    public Ordering getFirst()
    {
        return first;
    }

    public boolean isFirst()
    {
        return this == first;
    }

   
    public void append(Ordering cycle)
    {
     
        first.last = cycle.last;
        next = cycle;

        Ordering tmp = cycle.first;
   
        while(tmp != null) {
            tmp.first = first;
            tmp = tmp.next;
        }
    }

   
    public void split()
    {
  
        first.last = this;

        Ordering tmp = next;
        while(tmp != null) {
            tmp.first = next;
            tmp = tmp.next;
        }

        next = null;
    }

   
    @Override
    public String toString()
    {
        String str = "";
        Ordering tmp = first;
        while(tmp != null) {
            str += " " + tmp.value;
            tmp = tmp.next;
        }

        return str;
    }
}