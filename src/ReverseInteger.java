public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse2(1534236469));
    }
    public static int reverse(int x) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(x);
        int indexOfMinus=stringBuilder.indexOf("-");
        if(indexOfMinus>=0){
            stringBuilder.deleteCharAt(indexOfMinus);
        }
        int result=0;
        try{
            result=Integer.parseInt(stringBuilder.reverse().toString());
            if(indexOfMinus>=0){
                return result*-1;
            }
        }
        catch (Exception ex){

        }

        return result;
    }

    //fast solotion ***********************----------------NOT ME---------------***************************/
    public static int reverse2(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        long reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (negative ? -reverse : reverse);
    }

}
