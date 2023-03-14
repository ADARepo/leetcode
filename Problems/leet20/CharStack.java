package leet20;

public class CharStack 
{
    private int top;
    private char [] S;
    
    public CharStack(String s)
    {
        this.top = 0;
        S = new char [s.length() + 1];
    }

    public boolean stackEmpty()
    {
        if (top == 0) return true;
        else return false;
    }

    public void push(char c)
    {

        this.top += 1;
        this.S[top] = c;

    }

    public char pop()
    {
        // If empty, return 'e'.
        if (stackEmpty())
            return 'e';
        else 
        {
            top -= 1;
            return S[top + 1];
        }
    }
}
