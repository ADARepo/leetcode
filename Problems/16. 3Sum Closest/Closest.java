import java.lang.Math;
import java.util.Random;

public class Closest 
{
    public static void qsNums(int [] nums)
    {
        qsNums(nums, 0, nums.length - 1);
    }

    public static void qsNums (int [] nums, int low, int high)
    {
        if (low >= high) return;

        int pivotIndex = new Random().nextInt(high - low) + low;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, high);

        int lp = pivot(nums, low, high, pivot);

        qsNums(nums, low, lp - 1);
        qsNums(nums, lp + 1, high);
    }

    private static int pivot(int[] nums, int low, int high, int pivot) {
        int lp = low;
        int rp = high - 1;

        while (lp < rp)
        {
            while (nums[lp] <= pivot && lp < rp) lp++;
            while (nums[rp] >= pivot && lp < rp) rp--;

            swap(nums, lp, rp);
        }

        if(nums[lp] > nums[high]) {
            swap(nums, lp, high);
          }
          else {
            lp = high;
          }
        return lp;
    }

    public static void swap (int [] nums, int left, int right)
    {
        int place = nums[left];
        nums[left] = nums[right];
        nums[right] = place;
    }

    public static int threeSumClosest (int [] nums, int target)
    {
        int len = nums.length;

        qsNums(nums);

        // Grabbing initial closest value and then also storing the difference to compare differences of new 3Sum's.
        int closest = (nums[0] + nums[1] + nums[2]);

        if (len == 3) return closest;

        int diff = Math.abs(target - closest);
        
        // Goal is to find the sum of three numbers that are closest to the target given.
        for (int i = 0; i < len - 2; i++)
        {
            int low = i + 1;
            int last = len - 1;
            int first = nums[i];

            while (low != last)
            {
                int currDiff = Math.abs(nums[low] + first + nums[last] - target);
                int currSum = nums[low] + first + nums[last];

                if (currSum == target) return target;

                if (currDiff < diff)
                {
                    diff = currDiff;
                    closest = currSum;
                }
                
                if (currSum >= target) last--;
                else low++;
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
