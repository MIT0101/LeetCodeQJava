import java.util.HashMap;

public class LongestPalindromicSubstring {
//    Example 1:
//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.

//    Example 2:
//    Input: s = "cbbd"
//    Output: "bb"

    //    Example 3:
    //    Input: s = "aacabdkacaa"
    //    Output: "aca"
    public static void main(String[] args) {

        String s = "a";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }

        HashMap<Character,Integer> all=new HashMap<>();
        String strR="";
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            char current=s.charAt(i);

            if(all.containsKey(current)){
                String result=s.substring(all.get(current),i+1);
                //check if thy are eqals
                if(isCom(result)){
                    int len=result.length();
                    if(max<len){
                        strR=result;
                        max=len;
                    }
                }
            }
            all.put(current,i);
        }

        if(strR.equals("")){
            if(s.length()>0){
                return  s.charAt(0)+"";
            }
        }

        return strR;

    }

    private static boolean isCom(String s){
        int n=s.length()/2;

        if(s.charAt(0)!=s.charAt(s.length()-1)){
            return false;
        }
            for (int i = 1; i <s.length()-1 ; i++) {
                if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                    return false;
                }
            }

        return true;

    }
}
