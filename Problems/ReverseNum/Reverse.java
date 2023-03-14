package ReverseNum;

public class Reverse 
{

    public static int reverse (int n)
    {
        int ret = 0;

        while (n != 0)
        {
            ret = ret * 10 + (n % 10);
            n /= 10;
        }

        return ret;
    }

    public static int reverse2(int n)
    {
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        return Integer.parseInt(sb.reverse().toString());
    }

    public static int reverse3(int n)
    {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main (String [] args)
    {
        int n = 1234, runs = 1000000, receiver;

        long timeStart = System.nanoTime();
        for (int i = 0; i < runs; i++) receiver = reverse(n);
        long timeEnd = System.nanoTime();
        System.out.println((timeEnd - timeStart) + " nanoseconds for mod reverse. " + runs + " runs.\n");

        timeStart = System.nanoTime();
        for (int i = 0; i < runs; i++) receiver = reverse2(n);
        timeEnd = System.nanoTime();
        System.out.println((timeEnd - timeStart) + " nanoseconds for StringBuffer reverse. " + runs + " runs.\n");

        timeStart = System.nanoTime();
        for (int i = 0; i < runs; i++) receiver = reverse3(n);
        timeEnd = System.nanoTime();
        System.out.println((timeEnd - timeStart) + " nanoseconds for StringBuilder reverse. " + runs + " runs.\n");
    }
}
