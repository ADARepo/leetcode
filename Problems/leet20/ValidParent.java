package leet20;

public class ValidParent 
{

    public boolean isValid(String s)
    {
        int len = s.length();

        if (len % 2 != 0) return false;

        CharStack S = new CharStack(s);

        for (int i = 0; i < len; i++)
        {
            char thisChar = s.charAt(i);
            if (thisChar == '{' || thisChar == '(' || thisChar == '[')
                S.push(thisChar);
            else
            {
                char popChar = S.pop();
                if (thisChar == '}' && popChar != '{') return false;
                else if (thisChar == ')' && popChar != '(') return false;
                else if (thisChar == ']' && popChar != '[') return false;
            }
        }
        if (S.stackEmpty()) return true;
        return false;
    }

    public static void main (String [] args)
    {
        ValidParent vp = new ValidParent();

        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("(}"));
        System.out.println(vp.isValid("(("));
    }
}
