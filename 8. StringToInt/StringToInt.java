class StringToInt
{
    public static void main (String [] args)
    {
        Solution s = new Solution();

        System.out.println(s.myAtoi("3.14159")); // 3
        System.out.println(s.myAtoi("4093 is my number")); // 4093
        System.out.println(s.myAtoi("-+43")); // 0
        System.out.println(s.myAtoi("+-43")); // 0
        System.out.println(s.myAtoi("   43")); // 43
        System.out.println(s.myAtoi("936538437834786")); // 2147483647
        System.out.println(s.myAtoi("-34786342789324")); // -2147483648
        System.out.println(s.myAtoi("00000-42a1234")); // 0
    }
}