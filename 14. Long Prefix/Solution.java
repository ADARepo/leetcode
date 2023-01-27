public class Solution 
{
    public String longestCommonPrefix (String [] strs)
    {
        int retLength = 0;
        int arrLen = strs.length;

        // Single string in array or first string is empty.
        if (arrLen == 1) return strs[0];
        if (strs[0].length() == 0) return "";

        // i for iterating through the strings in the array
        // j for letters in the strings.
        int i = 1, j = 0;
        while (j < strs[i].length())
        {
            // First check if the chars match in current and string before.
            if ((j < strs[i].length()) && (j < strs[i - 1].length()) && (strs[i].charAt(j) == strs[i - 1].charAt(j)))
            {
                // If we reach the last string in the array and the prefix has been the same, adjust ret and return.
                // When reaching the end of array, record j as length of ret for returning to that index in the first string of array.
                if (i == (arrLen - 1)) 
                {
                    retLength = j + 1;
                    i = 1;
                    j++;
                }
                // Check if j is equal to the last strings j-th position.
                // If not equal, return the last strs[0]
                else 
                {
                    i++;
                }
            }
            else
            {
                if (retLength == 0) return "";
                else return strs[0].substring(0, retLength);
            }
        }

        return strs[0].substring(0, retLength);
    }

    public static void main (String [] args)
    {
        Solution s = new Solution();

        System.out.println("".length());

        System.out.println(s.longestCommonPrefix(new String [] {"flower", "flow", "flight"})); // fl
        System.out.println(s.longestCommonPrefix(new String [] {"fdower", "flow", "flight"})); // f
        System.out.println(s.longestCommonPrefix(new String [] {"flower", "flow", "floght"})); // flo
        System.out.println(s.longestCommonPrefix(new String [] {"gits", "git", "gitss"})); // git
        System.out.println(s.longestCommonPrefix(new String [] {"a", "ac"}));
    }
}
