import java.util.Arrays;
import java.util.HashMap;

public class toArrayNumSum {
    public static void main(String[] args) {
        int[] toNumArr=new int[]{3,2,3};
        int target=6;
        //must out is [0,2]
        System.out.println(Arrays.toString(twoSum_Fast(toNumArr,target)));
    }
    public static int[] twoSum_Fast(int[] nums, int target) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer mustAdd=map.get(nums[i]);
            if(mustAdd!=null){
                return new int[]{mustAdd,i};
            }
            map.put(target-nums[i],i);

        }
        return nums;
    }

    public static int[] twoSum_Old(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int first=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(first+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }
}
