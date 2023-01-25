public class Solution 
{

    public int romanToInt (String s)
    {
        if (s.length() == 1) 
        {
            if (s.charAt(0) == 'I') return 1;
            if (s.charAt(0) == 'V') return 5;
            if (s.charAt(0) == 'X') return 10;
            if (s.charAt(0) == 'L') return 50;
            if (s.charAt(0) == 'C') return 100;
            if (s.charAt(0) == 'D') return 500;
            else return 1000;
        }

        int ret = 0;
        int i = 0;

        while (i < (s.length()))
        {
            while (i < s.length() && s.charAt(i) == 'M')
            {
                ret += 1000;
                i++;
            }
            if (i < (s.length() - 1) && s.charAt(i) == 'C' && s.charAt(i+1) == 'M')
            {
                ret += 900;
                i += 2;
            }
            else if (i < (s.length() - 1) && s.charAt(i) == 'C' && s.charAt(i+1) == 'D')
            {
                ret += 400;
                i += 2;
            }
            else if (i < s.length() && s.charAt(i) == 'C')
            {
                ret += 100;
                i++;
            }
            else if (i < (s.length() - 1) && s.charAt(i) == 'X' && s.charAt(i+1) == 'C')
            {
                ret += 90;
                i += 2;
            }
            else if (i < (s.length() - 1) && s.charAt(i) == 'X' && s.charAt(i+1) == 'L')
            {
                ret += 40;
                i += 2;
            }
            else if (i < s.length() && s.charAt(i) == 'X')
            {
                ret += 10;
                i++;
            }
            else if (i < (s.length() - 1) && s.charAt(i) == 'I' && s.charAt(i+1) == 'X')
            {
                ret += 9;
                i += 2;
            }
            else if (i < (s.length() - 1) && s.charAt(i) == 'I' && s.charAt(i+1) == 'V')
            {
                ret += 4;
                i += 2;
            }
            else if (i < (s.length()) && s.charAt(i) == 'L')
            {
                ret += 50;
                i++;
            }
            else if (i < (s.length()) && s.charAt(i) == 'V')
            {
                ret += 5;
                i++;
            }
            else if (i < (s.length()) && s.charAt(i) == 'D')
            {
                ret += 500;
                i++;
            }
            else if (i < (s.length()))
            {
                ret++;
                i += 1;
            }
        }

        return ret;
    }

    public static void main (String [] args)
    {
        Solution s = new Solution();

        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MCMXCIV"));
        System.out.println(s.romanToInt("M"));
        System.out.println(s.romanToInt("L"));
        System.out.println(s.romanToInt("XV"));
        System.out.println(s.romanToInt("LCI"));
        System.out.println(s.romanToInt("MIV"));
        System.out.println(s.romanToInt("VIII"));
        System.out.println(s.romanToInt("DCXXI"));
        System.out.println(s.romanToInt("MMCDXXV"));
        System.out.println(s.romanToInt("MMM"));
    }
}
