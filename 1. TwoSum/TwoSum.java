import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) 
    {
        // Key = the value that the index holds, value = index.
        HashMap <Integer, Integer> vals = new HashMap<Integer, Integer>();
        int [] ret = new int [2];
        int diff;

        // i will be the current index we are checking.
        for (int i = 0; i < nums.length; i++)
        {
            // diff is the value we need to look for in the hashmap.
            diff = target - nums[i];
            
            // If we have diff as a key, get index and return indices as ret.
            if (vals.get(diff) != null)
            {
                ret[0] = i;
                ret[1] = vals.get(diff);
                return ret;
            }
            vals.put(nums[i], i);
        }

        
        return null;
    }

    public static void main (String [] args)
    {
        TwoSum a = new TwoSum();
        int [] theArray = new int[] {3, 2, 4};

        System.out.println(Arrays.toString(a.twoSum(theArray, 6)));
    }
}