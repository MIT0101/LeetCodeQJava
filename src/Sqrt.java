public class Sqrt {
    static int main =0;
    public static void main(String[] args) {
        System.out.println(mySqr(144));
        System.out.println("mohammed al mustaffa adel abd salman hasn al jbory".length());
        System.out.println("WHRn@n\u002675iwALtqN".length());
        System.out.println(Integer.MAX_VALUE);
    }

    public static int mySqr(int x){

//        int result=x-1;
//        while (result>=1){
//            int temp=result*result;
//            if(temp==x){
//                return result;
//            }else{
//                if(x>temp&&temp>0){
//                    return result;
//                }
//            }
//            result--;
//        }

        if(x>=0&&x<=1){
            return x;
        }
        double temp=0;
        double sq=x/2;
        while ((temp-sq)!=0){
            temp=sq;
            sq=(temp+(x/temp))/2;
        }
        return (int) sq;
    }


    public static int sqr3(int x){
        main=x;
        return sqr2(x) ;
    }

    public static int sqr2(int x){
        if(x*x==main) {
            return x;
        }
        if(x*x!=main&&(x+1)*(x+1)>main&&(x-1)*(x-1)<main){
            return x;
        }
        if(x*x>0&&x*x<main){
            return sqr2(x+1);
        }
        int temp=x/2;
        if(temp*temp==main){
            return temp;
        }else{
            return sqr2(temp);
        }
    }

}
