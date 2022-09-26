import java.util.LinkedHashMap;

public class IntegertoRoman {
//    static HashMap<Integer,String> allRomains=new HashMap<>();
    static LinkedHashMap<Integer,String> allRomains=new LinkedHashMap<>();
    static int recTimes=0;
    static int loopTimes=0;
    static int numToTest=1;
    public static void main(String[] args) {
        System.out.println("***********************----------OLD METHOD---------*****************************");

        long startTime1 = System.nanoTime();
        System.out.println("Convert "+numToTest+", Result :"+intToRoman(numToTest));
        long elapsedTime = System.nanoTime() - startTime1;
        System.out.println("Total execution time to recursive Method : " + elapsedTime/1000 +" ns");
        System.out.println("recursive time= "+recTimes);

        //to get in milles must diveide by 1000000 (elapsedTime/1000000)
        System.out.println("***********************----------NEW METHOD---------*****************************");

        long startTime2 = System.nanoTime();
        System.out.println("Convert "+numToTest+", Result :"+intToRoman2(numToTest));
        long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("Total execution time to loops Method : " + elapsedTime2/1000+" ns");
        System.out.println("loops time= "+loopTimes);


        long betwen=Math.abs(elapsedTime-elapsedTime2)/1000;
        if(elapsedTime<elapsedTime2){
            //recursive broke when number is higher than 3999 (5000 its break)
            System.out.println("recursive is facter with : "+betwen+" ns");
        }else{
            System.out.println("loops is faster with : "+betwen+" ns");
        }



    }
    /*********************************************--------MY New SOLITION------***************************////////////////////////

    public static String intToRoman2(int num) {
        return intToRomain(num);
    }

    private static String intToRomain(int num){
        fillMap2();
        String str="";
        //must keys sorted from max to mini
        Integer[] keys=allRomains.keySet().toArray(new Integer[0]);
        int size=keys.length;
        int sLength=num+"".length();
        int i=size-1;
       // for numbers between 1-9
        if(sLength==1){
            i=size-10;
        }
        else if(sLength==2){
            i=size-6;
        }
        else if(sLength==2){
            i=size-2;
        }

        while (i>=0) {
//            for (i = size - 1; i >= 0; i--) {
                loopTimes++;
//                System.out.println("in for loop "+loopTimes);
                int key = keys[i];
                int divideResult = num / key;
                if (divideResult > 0) {
                    str += addStrTime(allRomains.get(key), divideResult);
                    num = num - (divideResult * key);
                    i++;
                }

//            }
            i--;
        }

        return str;
    }

    private static String addStrTime(String str,int times){
        String result="";
        for (int i = 1; i <=times ; i++) {
            result +=str;
        }
        return result;
    }
    public static void fillMap2(){
        allRomains.put(1,"I");
        allRomains.put(4,"IV");
        allRomains.put(5,"V");
        allRomains.put(9,"IX");
        allRomains.put(10,"X");
        allRomains.put(40,"XL");
        allRomains.put(50,"L");
        allRomains.put(90,"XC");
        allRomains.put(100,"C");
        allRomains.put(400,"CD");
        allRomains.put(500,"D");
        allRomains.put(900,"CM");
        allRomains.put(1000,"M");

    }

    /*********************************************--------MY OLD SOLITUIN------***************************////////////////////////

    public static String intToRoman(int num) {
        fillMap();
        return intToRomainRec(num,0,"");
    }

    private static String intToRomainRec(int num,int left,String str){
        recTimes++;
//        System.out.println("in recursive  loop "+recTimes);

        if(num==0&&left==0){
            return str;
        }
        if(allRomains.get(num)!=null){
            str+=allRomains.get(num);
            return intToRomainRec(left,0,str);
        }
        else{
            return intToRomainRec(num-1,left+1,str);
        }
    }


    public static void fillMap(){
        allRomains.put(1,"I");
        allRomains.put(4,"IV");
        allRomains.put(5,"V");
        allRomains.put(9,"IX");
        allRomains.put(10,"X");
        allRomains.put(40,"XL");
        allRomains.put(50,"L");
        allRomains.put(90,"XC");
        allRomains.put(100,"C");
        allRomains.put(400,"CD");
        allRomains.put(500,"D");
        allRomains.put(900,"CM");
        allRomains.put(1000,"M");
    }
}
