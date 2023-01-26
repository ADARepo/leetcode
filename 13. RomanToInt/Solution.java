public class Solution 
{

    public int romanToInt (String s)
    {
        int ret = 0, lastChar = 0, n;

        for (int i = (s.length() - 1); i >= 0; i--)
        {
            char c = s.charAt(i);
            if (c == 'I') n = 1;
            else if (c == 'V') n = 5;
            else if (c == 'X') n = 10;
            else if (c == 'L') n = 50;
            else if (c == 'C') n = 100;
            else if (c == 'D') n = 500;
            else n = 1000;

            if (n < lastChar) ret -= n;
            else ret += n;

            lastChar = n;
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
