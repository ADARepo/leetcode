package leet22;

import java.util.ArrayList;
import java.util.List;

public class GenParen 
{
    // Using combination in place of permutation, but it is a permutation since ()(()) is considered different from (())().
    // important since i will be using previous n's to generate new ones.
    public List<String> generateParenthesis(int n)
    {
        List<String> ret = new ArrayList<>();
        
        buildRet(ret, 0, 0, "", n);

        return ret;
    }

    public void buildRet(List<String> ret, int l, int r, String s, int n)
    {
        // if the length of s is equal to the fixed length of what the string to be added is,
        // add to ret and return to the call.
        if (s.length() == (n*2))
        {
            ret.add(s);
            return;
        }

        // Can only put a right parenthesis if it matches a left parenthesis.
        // l is the number of left parenthesis in the string.
        // r is the number of right parenthesis in the string.
        if (l < n)
        {
            buildRet(ret, l+1, r, s + '(', n);
        }

        if (r < l)
        {
            buildRet(ret, l, r+1, s + ')', n);
        }
    }

    public static void main (String [] args)
    {
        GenParen gp = new GenParen();

        List<String> show = gp.generateParenthesis(3);
        System.out.println(show.get(0));
    }
}
