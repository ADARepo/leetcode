import java.lang.Math;

public class Closest 
{
    public static int threeSumClosest (int [] nums, int target)
    {
        int len = nums.length;

        if (len == 3) return nums[0] + nums[1] + nums[2];

        // Grabbing initial closest value and then also storing the difference to compare differences of new 3Sum's.
        int closest = (nums[0] + nums[1] + nums[2]);
        int diff = Math.abs(target - closest);
        
        // Goal is to find the sum of three numbers that are closest to the target given.
        for (int i = 0; i < len; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                for (int k = j + 1; k < len; k++)
                {
                    int sum = (nums[i] + nums[j] + nums[k]);
                    if (Math.abs(sum - target) < diff)
                    {
                        closest = sum;
                        diff = Math.abs(target - closest);
                    }
                }
            }
        }
        return closest;
    }
    public static void main (String [] args)
    {
        // Closest c = new Closest();

        System.out.println((threeSumClosest(new int[]{-1, 2, 1, -4}, 1)));
        System.out.println((threeSumClosest(new int[]{4, 6, 2 ,-12, 18, 3}, 7)));
        System.out.println((threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2)));
        // System.out.println((threeSumClosest(new int[]{-1, 2, 1, -4}, 1)));
    }
}
