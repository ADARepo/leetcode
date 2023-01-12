public class Solution {
    public int myAtoi (String s)
    {
        // [48, 57] for number range

        if (s.length() == 0) return 0;

        int index = 0;
        char c = s.charAt(index);
        int finalSign = 1;
        long finalNum = 0;
        int numericVal;
        boolean foundVal = false;
        boolean signFound = false;

        while (c == ' ') 
        {
            index++;
            c = s.charAt(index);
        }

        for (int i = index; i < s.length(); i++)
        {
            numericVal = (int) s.charAt(i);

            if (s.charAt(i) == '-')
            {
                if (signFound) return 0;
                finalSign = -1;
                signFound = true;
                continue;
            }
            else if (s.charAt(i) == '+')
            {
                if (signFound) return 0;
                signFound = true;
                continue;
            }

            if (((numericVal) < 48) && (numericVal) > 57) continue;
            if ((((numericVal) < 48) || (numericVal) > 57) && foundVal == true) 
            {
                // if (i != (s.length() - 1) && ((s.charAt(i + 1) >= 48) && (s.charAt(i + 1) <= 57))) finalNum = 0;
                return (int) finalNum;
            }

            if (((numericVal) >= 48) && (numericVal) <= 57)
            {
                foundVal = true;
                finalNum = finalNum * 10 + (numericVal - 48);
                if (finalNum > 2147483647 && finalSign == 1) return 2147483647;

                if (finalSign == -1 && ((finalSign * finalNum) < -2147483648) ) return -2147483648;
            }
            else break;
        }

        return (foundVal == true) ? (int)((finalSign * finalNum)) : 0;
    }
}
