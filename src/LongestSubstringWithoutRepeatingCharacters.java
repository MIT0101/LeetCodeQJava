import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
//    Example 1:
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.

    public static void main(String[] args) {

        String testStr="aabb";
        System.out.println(lengthOfLongestSubstring(testStr));
        System.out.println(lengthOfLongestSubstring2(testStr));
    }
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map= new HashMap<>();
        int start=0, len=0;

        // abba
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start)
                    start = map.get(c) + 1;
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }

        return len;
    }

    /**********************------SECOND SOLUTION-------*************************/
    public static int lengthOfLongestSubstring2(String s) {
        int max=0;
        int start=0;
        for(int i=0; i<s.length(); i++) {
        int indexOfCurrentChar=s.indexOf(s.charAt(i),start);
        if(indexOfCurrentChar!=i){
            start=indexOfCurrentChar+1;
        }
            max=Math.max(max,i-start+1);
        }
        return max;
    }

}
