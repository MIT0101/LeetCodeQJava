import java.util.HashMap;

public class RomantoInteger {
//    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//            Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

   static HashMap<Character,Integer> allRomains=new HashMap<>();
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        fillMap();
        int size=s.length();
        int result=0;
        int i=0;
        while (i<size-1){
            int ch1=allRomains.get(s.charAt(i));
            int ch2=allRomains.get(s.charAt(i+1));
            if(ch2>ch1){
                result-=ch1;
            }else{
                result+=ch1;
            }
            i++;
        }
            result+=allRomains.get(s.charAt(i));
        return result;
    }
    public static void fillMap(){
        allRomains.put('I',1);
        allRomains.put('V',5);
        allRomains.put('X',10);
        allRomains.put('L',50);
        allRomains.put('C',100);
        allRomains.put('D',500);
        allRomains.put('M',1000);
    }
}
