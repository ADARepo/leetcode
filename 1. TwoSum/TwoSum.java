import java.util.Arrays;
class TwoSum {
    public int[] twoSum(int[] nums, int target) 
    {
        int [] ret = new int [2];
        int sum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                if (j == i) continue;
                if (nums[i] + nums[j] == target)
                {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }

        
        return ret;
    }

    public static void main (String [] args)
    {
        TwoSum a = new TwoSum();
        int [] theArray = new int[] {3,2,4};

        System.out.println(Arrays.toString(a.twoSum(theArray, 6)));
    }
}