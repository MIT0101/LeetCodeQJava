import java.util.Arrays;

public class MedianofTwoSortedArrays {
//    Example 1:
//    Input: nums1 = [1,3], nums2 = [2]
//    Output: 2.00000
//    Explanation: merged array = [1,2,3] and median is 2.

//    Example 2:
//    Input: nums1 = [1,2], nums2 = [3,4]
//    Output: 2.50000
//    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    public static void main(String[] args) {

        int[] nums1 =new int[] {1,2};
        int[] nums2 =new int[] {3,4};

        System.out.println(findMedianSortedArrays(nums1,nums2));


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size=nums1.length+nums2.length;
        int[] result=new int[size];
        int i=0;
        for (int val:nums1) {
            result[i]=val;
            i++;
        }
        for (int val:nums2) {
            result[i]=val;
            i++;
        }
        Arrays.sort(result);
        if(size%2==0){

            return (result[(size/2)-1]+result[(size/2)])/2.0;
        }
        return result[size/2];

    }

}
