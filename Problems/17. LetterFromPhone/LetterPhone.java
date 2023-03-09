import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


// Using GuruSakthivel's backtracking solutions but using a HashMap
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/3244849/backtracking-java-0-ms/
public class LetterPhone
{
    // HashMap for speed since not synchronized.
    // Storing digits 2-9 as keys and letters as a string for the value.
    HashMap <Integer, String> digLetters = new HashMap<>();
    
    public List<String> letterCombinations(String digits) 
    {
        List <String> ret = new ArrayList<>();
        int digLength = digits.length();
        if (digLength == 0) return ret;

        createMap();
        
        // StringBuilder is not thread safe so it will be fast without synchronization overhead.
        StringBuilder sb = new StringBuilder();

        backtrack(ret, digits, sb, 0);

        return ret;
    }

    private void backtrack(List<String> ret, String digits, StringBuilder sb, int index)
    {
        // If length of string builder is also equal to the digits length, add the string builder to ret and return to last call.
        if (sb.length() == digits.length())
        {
            ret.add(sb.toString());
            return;
        }
        else
        {
            // Getting the value of the number in digits.
            int val = digits.charAt(index) - '0';

            for (int i = 0; i < digLetters.get(val).length(); i++)
            {
                sb.append(digLetters.get(val).charAt(i));
                backtrack(ret, digits, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void createMap()
    {
        digLetters.put(2, "abc");
        digLetters.put(3, "def");
        digLetters.put(4, "ghi");
        digLetters.put(5, "jkl");
        digLetters.put(6, "mno");
        digLetters.put(7, "pqrs");
        digLetters.put(8, "tuv");
        digLetters.put(9, "wxyz");
    }

    static public void main (String [] args)
    {
        LetterPhone lp = new LetterPhone();
        List <String> showRet = new ArrayList<>();

        showRet = lp.letterCombinations("23");
    }
}