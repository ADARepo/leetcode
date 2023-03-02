import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) 
    {
        
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        // HashMap with key as letter, value as i-th iteration.
        // This should keep track of seeing a repeat letter in a substring.
        HashMap <Character, Integer> hm = new HashMap<Character, Integer>();
        int max = 1; int val; char thisChar;
        int i = 0; int j = i + 1;

        while ((i < s.length()) && (s.length() - i) > max)
        {
            // Add the letter at i to the hashmap.
            hm.put(s.charAt(i), i);

            j = i + 1;

            while (j < s.length())
            {
                // Get the current letter's value to see if we have seen it this loop.
                thisChar = s.charAt(j);
                val = hm.getOrDefault(thisChar, -1);

                // If we get -1, haven't seen char yet so add key:value pair to hashmap.
                if (val == -1) hm.put(thisChar, i);

                // Check if letter at j has been seen before this substring.
                // This can be done by seeing if that letter (key) has current j as its value.
                else if (val == i)
                {
                    // Since we found a letter that has been previously seen this iteration, move i to the spot we saw it last so it will iterate one ahead next time around.
                    i = hm.get(s.charAt(j));

                    // We can break here since the max will not have increased.
                    break;
                }

                // If we get another value besides current iteration or -1, the value has been seen in another iteration so update to this one.
                else 
                {
                    hm.put(thisChar, i);
                }

                max = ((j - i + 1) > max) ? (j - i + 1): max;
                j++;
            }
            i++;
        }
        
        return max;
    }
    public static void main (String [] args)
    {
        LongestSubstring ll = new LongestSubstring();
        // System.out.println(" ".length());
        System.out.println(ll.lengthOfLongestSubstring("pwwkew"));
    }
}
