public class Solution implements HighWater
{
    public int maxArea (int [] height)
    {
        // Getting initial max.
        int max = Math.min(height[0], height[1]);

        int i = 0; int j = height.length - 1;

        while (i < j)
        {
            // Store height[i] and height[j] since we are using these values more than once in this loop iteration (faster than re-using).
            int l = height[i];
            int r = height[j];

            // Get area of current values, see if greater than max.
            int area = Math.min(l, r) * (j - i);

            // A ternary here would be okay, but it would be slower than just this if statement.
            if (area > max)
            {
                max = area;
            }

            // Speeding up: move the iterator that is pointing at a lower value in the array.
            if (l < r) i++;
            else j--;
        }

        return max;
    }

    public static void main (String [] args)
    {
        Solution s = new Solution();

        int [] arr = new int[] {1, 1};
        System.out.println(s.maxArea(arr));

        arr = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(arr));

        arr = new int [] {1,2,1};
        System.out.println(s.maxArea(arr));
    }
}