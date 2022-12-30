
// This was my solution from November, 2021 which seemed to be better than the solution I was looking at on leetcode's posted solutions.
// After trying to re-implement it, I realized I couldn't without great effort so will need to look more into it later.
class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int i = 0; int j = 0; int sortLoc = 0;

        int [] sorted = new int[nums1.length + nums2.length];
        
        // edge cases where we have weird arrays.
        // case where nums1 has no elements and nums2 does.
        if (nums1.length == 0 && nums2.length != 0)
        {
            if (nums2.length % 2 == 1)
                return (double)nums2[nums2.length / 2];
            else
            {
                int first = nums2[nums2.length / 2 - 1];
                if (first < 0) first = 0;
                int second = nums2[nums2.length / 2];
                
                return ((double)first + second) / 2.0;
            }
        }
        // case where nums2 has no elements and nums1 does.
        if (nums2.length == 0 && nums1.length != 0)
        {
            if (nums1.length % 2 == 1)
                return (double)nums1[nums1.length / 2];
            else
            {
                int first = nums1[nums1.length / 2 - 1];
                if (first < 0) first = 0;
                int second = nums1[nums1.length / 2];
                
                
                
                return ((double)first + second) / 2.0;
            }
        }
        // case where nums1 last element is 0.
        if (nums1[nums1.length - 1] == 0)
        {
            if (nums2.length != 0)
            {
                if (nums2.length % 2 == 1)
                    return (double)nums2[nums2.length / 2];
                else
                {
                    int first = nums2[nums2.length / 2 - 1];
                    if (first < 0) first = 0;
                    int second = nums2[nums2.length / 2];
                    
                    

                    return ((double)first + second) / 2.0;
                }
            }
            else
                return 0.0;
        }
        // case where nums2 last element is 0.
        else if (nums2[nums2.length - 1] == 0)
        {
            if (nums1.length != 0)
            {
                if (nums1.length % 2 == 1)
                    return (double)nums1[nums1.length / 2];
                else
                {
                    int first = nums1[nums1.length / 2 - 1];
                    if (first < 0) first = 0;
                    int second = nums1[nums1.length / 2];
                    
                    return ((double)first + second) / 2.0;
                }
            }
            else
                return 0.0;
        }
        

        // sorting until the end of both lists.
        while (i <= nums1.length || j <= nums2.length)
        {
            // first, checking if i or j is bigger than its corresponding array size.
            if (i >= nums1.length)
            {
                while (j != nums2.length)
                    sorted[sortLoc++] = nums2[j++];
                break;
            }
            if (j >= nums2.length)
            {
                while (i != nums1.length)
                    sorted[sortLoc++] = nums1[i++];
                break;
            }

            // if neither i nor j has reached the end of its array, do comparisons and increment
            // the counter variable that was put into sorted[].
            if (nums1[i] <= nums2[j])
                sorted[sortLoc++] = nums1[i++];
            else
                sorted[sortLoc++] = nums2[j++];

        }

        // single array is sorted, now find median and return it.
        if (sorted.length % 2 == 1)
            return (double)sorted[sorted.length / 2];
        else
        {
            int first = sorted[sorted.length / 2 - 1];
            if (first < 0) first = 0;
            int second = sorted[sorted.length / 2];
            
            
            
            return ((double)first + second) / 2.0;
        }
    }

    public static void main (String [] args)
    {
        Median md = new Median();
        int [] array1 = new int[]{};
        int [] array2 = new int[]{1,2,3,7};

        System.out.println(md.findMedianSortedArrays(array1, array2));
    }
}