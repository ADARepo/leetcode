import java.io.*;
import java.util.*;

class Stack
{
    private List<Integer> arr;
    public int size;
    
    public Stack(int q)
    {
        this.size = 0;
        this.arr = new ArrayList<Integer>(q);
    }
    
    private boolean stackEmpty()
    {
        if (size == 0) return true;
        else return false;
    }

    public void push(int n, int pos)
    {
        this.size++;
        arr.add(pos, n);
    }

    public int pop()
    {
        if (stackEmpty())
            return -1;
        else 
        {
            this.size--;
            int ret = arr.get(this.size);
            arr.remove(this.size);
            return ret;
        }
    }
    
    public int peek()
    {
        return arr.get(size - 1);
    }
}

class Queue
{
    private List<Integer> arr;
    private int size;
    private Stack stack1;
    private Stack stack2;
    
    public Queue(int q)
    {
        this.size = 0;
        this.arr = new ArrayList<>(q);
        this.stack1 = new Stack(q);
        this.stack2 = new Stack(q);
    }
    
    public void enqueue(int n)
    {
        stack1.push(n, stack1.size);
        stack2.push(n, 0);
        this.size++;
    }
    
    public int dequeue()
    {
        stack1.pop();
        return stack2.pop();
    }
    
    public void printFront()
    {
        System.out.println(stack2.peek());
    }
}


public class QueueAsStacks 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int numQueries = sc.nextInt();
        
        Queue q = new Queue(numQueries);
        
        for (int i = 0; i < numQueries; i++)
        {
            int queryType = sc.nextInt();
            
            if (queryType == 1)
            {
                int numEnq = sc.nextInt();
                q.enqueue(numEnq);
            }
            else if (queryType == 2)
            {
                int frontNum = q.dequeue();
            }
            else 
            {
                q.printFront();
            }
        }
        
    }
}


// STDIN   Function
// -----   --------
// 10      q = 10 (number of queries)
// 1 42    1st query, enqueue 42
// 2       dequeue front element
// 1 14    enqueue 42
// 3       print the front element
// 1 28    enqueue 28
// 3       print the front element
// 1 60    enqueue 60
// 1 78    enqueue 78
// 2       dequeue front element
// 2       dequeue front element