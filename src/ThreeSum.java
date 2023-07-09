import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //Medium
//    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//    Notice that the solution set must not contain duplicate triplets.
//
//
//
//    Example 1:
//
//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]
//    Explanation:
//    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//    The distinct triplets are [-1,0,1] and [-1,-1,2].
//    Notice that the order of the output and the order of the triplets does not matter.
//    Example 2:
//
//    Input: nums = [0,1,1]
//    Output: []
//    Explanation: The only possible triplet does not sum up to 0.
//    Example 3:
//
//    Input: nums = [0,0,0]
//    Output: [[0,0,0]]
//    Explanation: The only possible triplet sums up to 0.
    public static void main(String[] args) {
//        int[] nums=new int[]{-1,0,1,2,-1,-4}; //2
//        int[] nums=new int[]{0,1,1};//0
        int[] nums=new int[]{0,0,0};//1
//          int[] nums=new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};//9


        int count=0;
        List<List<Integer>> result=threeSum(nums);
        for (List<Integer> single:result) {
            System.out.println(Arrays.toString(single.toArray()));
            count++;
        }
        System.out.println(count);

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<String> checked=new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int need = 0 - nums[i] - nums[j];
                int satrtFrom=j;
                if(j+1<nums.length){
                    satrtFrom++;
                }
                int indexOfNeed = Arrays.binarySearch(nums, satrtFrom , nums.length ,need);
                if (indexOfNeed >= 0 && indexOfNeed != i && indexOfNeed != j) {
                if (nums[i] + nums[j] + nums[indexOfNeed] == 0) {
                    String currentString = nums[i] + "," + nums[j] + "," + nums[indexOfNeed];
                    if (!isContained(checked, currentString)) {
                        checked.add(currentString);
                        List<Integer> singleResult = new ArrayList<>();
                        singleResult.add(nums[i]);
                        singleResult.add(nums[j]);
                        singleResult.add(nums[indexOfNeed]);
                        result.add(singleResult);
                    }

                }
            }
            }
        }

        return result;
    }

    private static boolean isContained(ArrayList<String> all,String toCHeckStr){

        for (String base:all) {
            if(isUsed(base,toCHeckStr)){
                return true;
            }
        }
        return false;
    }

    private static boolean isUsed(String base,String current){
        String[] currentArr=base.split(",");
        for (String currentStr:currentArr) {
            if(current.indexOf(currentStr)==-1){
                return false;
            }
        }

        return true;

    }

}
