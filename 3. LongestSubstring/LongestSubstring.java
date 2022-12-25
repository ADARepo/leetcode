import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) 
    {
        // Key is substring, Integer is start index
        HashMap <CharSequence, Integer> chars = new HashMap<CharSequence, Integer>();
        int i = 0; int j = 1;
        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        CharSequence subSeq;

        while ((s.length() - i) > max)
        {
            j = (i + 1) % (s.length() + 1);
            subSeq = sb.subSequence(i, j);

            // If the key is not in the hashmap or the key IS in the hash map but the index is different (so continue checking this substring)
            // So if we get the default value (-1), the index isn't the same.
            // Store the new key, new index, and adjust max if necessary.
            // Also checking if the character at the end of the new sequence 
            while (!(chars.containsKey(subSeq)) || (chars.getOrDefault(subSeq, -1) == -1))
            {
                int charPos = (subSeq.length() == 1) ? 0: subSeq.length() - 1;
                if (chars.containsKey(Character.toString(subSeq.charAt(charPos)))) break;

                chars.put(subSeq, i);
                chars.put(Character.toString(subSeq.charAt(charPos)), Integer.valueOf(subSeq.charAt(charPos)));

                if (subSeq.length() > max) 
                {
                    max = subSeq.length();
                }

                if (j >= s.length()) break;
                else j++;

                subSeq = sb.subSequence(i, j);
            }

            i++;
            chars.clear();   
        }
        return max;
    }
    public static void main (String [] args)
    {
        LongestSubstring ll = new LongestSubstring();
        System.out.println(" ".length());
        System.out.println(ll.lengthOfLongestSubstring(" "));
    }
}
