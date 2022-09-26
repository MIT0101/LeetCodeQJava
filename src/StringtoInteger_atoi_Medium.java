public class StringtoInteger_atoi_Medium {
    public static void main(String[] args) {
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(Integer.MIN_VALUE);


    }
    public static int myAtoi(String s) {
        s=s.trim();
        int result=0;
        int size=s.length();
        int i=size-1;
        int power=0;
        boolean isMinus=false;
        boolean isPostive=false;
        if(size==0){
        return 0;
        }
        char test=s.charAt(0);
        if(!((test>='0'&&'9'>=test)||test=='-'||test=='+'||test=='.')){
            return 0;
        }
        if(test=='-'){
        isMinus=true;
        }else if(test=='+'){
            isPostive=true;
        }
        while (0<=i) {
            char ch=s.charAt(i);
            if(ch=='.'){
                result=0;
                power=0;
                continue;
            }
            if(ch=='+'){
                isPostive=true;
                continue;
            }
            if(ch=='-'){
                isMinus=true;
                continue;
            }
            if((isMinus==isPostive)&&isMinus){
                return 0;
            }
            if(ch>='0'&&'9'>=ch){
                int num=((int) ch-48);
                if(isMinus){
                    result-=((num)*(Math.pow(10,power)));
                }
                else{
                    result+=((num)*(Math.pow(10,power)));
                }
                power++;
            }
            else{
                return 0;
            }
            i--;
        }

        return result;
    }

}
