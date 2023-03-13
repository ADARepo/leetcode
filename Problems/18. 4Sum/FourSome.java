import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FourSome 
{

    public void swap(int [] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int partition(int [] nums, int low, int high)
    {
        int pivot = nums[high];

        int i = low - 1;

        for (int j = low; j < high; j++)
        {
            if (nums[j] < pivot)
            {
                i++;

                swap(nums, i, j);
            }
        }

        i++;
        swap(nums, i, high);

        return i;
    }

    public void qs(int [] nums, int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(nums, low, high);

            qs(nums, low, pivot - 1);
            qs(nums, pivot + 1, high);

        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        int len = nums.length;

        // Sort the list first.
        qs(nums, 0, len - 1);

        // Final return list is ret, indexRet will hold indices at first then convert to ret values later.
        List <List<Integer>> ret = new ArrayList<List<Integer>>();
        
        
        for (int i = 0; i < len - 3; i++)
        {
            for (int j = i+1; j < len - 2; j++)
            {
                int low = j + 1;
                int high = len - 1;

                while (low < high)
                {
                    long sum = (long)nums[i] + nums[j] + nums[low] + nums[high];

                    if (sum == target)
                    {
                        List <Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        Collections.sort(temp);
                        if (!ret.contains(temp)) ret.add(temp);
                        low++;
                    }

                    if (sum < target) low++;
                    else if (sum > target) high--;
                }
            }
        }
        return ret;
    }

    public static void main (String [] args)
    {
        FourSome obj = new FourSome();

        int [] nums = new int[]{1000000000,1000000000,1000000000,1000000000};

        System.out.println(obj.fourSum(nums, -294967296));
    }
}
