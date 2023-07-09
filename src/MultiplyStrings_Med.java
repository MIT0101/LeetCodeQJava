import java.math.BigInteger;

public class MultiplyStrings_Med {

//    Example 1:
//    Input: num1 = "2", num2 = "3"
//    Output: "6"

//    Example 2:
//    Input: num1 = "123", num2 = "456"
//    Output: "56088"

    //Me
    //Time 9ms beats 44.9%
    //Memory 42.2 beats 38.49%
    public static void main(String[] args) {
        System.out.println(multiply("498828660196","840477629533"));
        System.out.println(toLong("123"));
    }

    public static String multiply(String num1, String num2) {
       return new BigInteger(num1).multiply(new BigInteger(num2))+"";
    }

    public static long toLong(String str){
        long sum=0;
        int base=0;
        for (int i = str.length()-1; i >=0 ; i--) {
            sum+= ((long) str.charAt(i)-'0')*(Math.pow(10,base));
            base++;
        }
        return sum;
    }
}
