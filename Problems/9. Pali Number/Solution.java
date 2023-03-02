public class Solution 
{
    public boolean isPalindrome(int x) 
    {
        // Edge cases.
        if (x < 0) return false;
        if (x == 0) return true;

        int origNumber = x;
        int finalNum = 0;

        while (x != 0)
        {
            finalNum = finalNum * 10 + (x % 10);
            x /= 10;
        }

        return (origNumber == finalNum) ? true: false;
    }    
}
