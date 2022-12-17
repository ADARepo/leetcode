import javax.lang.model.util.ElementScanner14;

public class IntegerToRoman 
{

    public String intToRoman(int num) 
    {
        StringBuilder ret = new StringBuilder();

        while (num > 0)
        {
            if (num >= 1000) 
            {
                ret.append("M");
                num -= 1000;
            }
            else if (num >= 500) 
            {
                if (num >= 900)
                {
                    ret.append("CM");
                    num -= 900;
                }
                else
                {
                    ret.append("D");
                    num -= 500;
                }
            }
            else if (num >= 100) 
            {
                if (num >= 400)
                {
                    ret.append("CD");
                    num -= 400;
                }
                else
                {
                    ret.append("C");
                    num -= 100;
                }
            }
            else if (num >= 50) 
            {
                if (num >= 90)
                {
                    ret.append("XC");
                    num -= 90;
                }
                else
                {
                    ret.append("L");
                    num -= 50;
                }
            }
            else if (num >= 10)
            {
                if (num >= 40)
                {
                    ret.append("XL");
                    num -= 40;
                }
                else
                {
                    ret.append("X");
                    num -= 10;
                }
            } 
            else if (num >= 5) 
            {
                if (num == 9)
                {
                    ret.append("IX");
                    num -= 9;
                }
                else
                {
                    ret.append("V");
                    num -= 5;
                }
            }
            else if (num >= 1)
            {
                if (num == 4)
                {
                    ret.append("IV");
                    num -= 4;
                }
                else
                {
                    ret.append("I");
                    num--;
                }
            } 
        }
        return ret.toString();
    }
    // Take in the number to convert to roman numeral as the first argument inside of main.
    public static void main (String [] args)
    {
        IntegerToRoman a = new IntegerToRoman();
        System.out.println(a.intToRoman(Integer.parseInt(args[0])));
    }
}
