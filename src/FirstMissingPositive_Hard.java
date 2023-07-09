import java.util.TreeSet;

public class FirstMissingPositive_Hard {

//    Example 1:
//    Input: nums = [1,2,0]
//    Output: 3
//    Explanation: The numbers in the range [1,2] are all in the array.

//    Example 2:
//    Input: nums = [3,4,-1,1]
//    Output: 2
//    Explanation: 1 is in the array but 2 is missing.

//    Example 3:
//    Input: nums = [7,8,9,11,12]
//    Output: 1
//    Explanation: The smallest positive integer 1 is missing.


    //Me
    //Time 103ms beats 5.2%
    //Memory 85.1 beats 54.61%

    public static void main(String[] args) {
        int[] nums={1,7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        TreeSet<Integer> allPostive=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                allPostive.add(nums[i]);
            }
        }
        //all are minuce or start from number greater than 1
        if(allPostive.isEmpty()) {
            return 1;
        }
        //check if any number is missed in the nums order
        for (int nu:allPostive) {
            //befor
            if(!allPostive.contains(nu-1)&&nu-1>0){
                return Math.min(1,nu-1);
            }
            //after
            if(!allPostive.contains(nu+1)){
                return nu+1;
            }

        }
        return 0;
    }
}
