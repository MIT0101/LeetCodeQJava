import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//Example :1
//Input: head = [1,2,3,4,5], k = 2
//        Output: [2,1,4,3,5]

//Exmaple :2
//    Input: head = [1,2,3,4,5], k = 3
//            Output: [3,2,1,4,5]
public class ReverseNodesink_Group {

    static ListNode head1;
    static ListNode result;
    static ListNode lastPostion;

    public static void main(String[] args) {

        System.out.println("befor revers");

        ListNode root1=new ListNode(10);
        ListNode n11=new ListNode(20);
        head1=root1;
        root1.next=n11;
        ListNode n12=new ListNode(30);
        n11.next=n12;
        ListNode n13=new ListNode(40);
        n12.next=n13;
        ListNode n14=new ListNode(50);
        n13.next=n14;

        printListNode(head1);

        System.out.println("after revers");

        long srart1=System.nanoTime();

        reverseKGroup(head1,2);
        long end1=System.nanoTime();
        long oldMethodTime=(end1-srart1)/100;

        System.out.println("time with old method : "+oldMethodTime);
        result=null;
        long srart2=System.nanoTime();

        reverseKGroup2(head1,2);
        long end2=System.nanoTime();
        long newMethodTime=(end2-srart2)/100;

        System.out.println("time with new method : "+newMethodTime);

        if(oldMethodTime<newMethodTime){
            System.out.println("OLd Method is faster");
        }else{
            System.out.println("New Method is faster");

        }

        printListNode(result);

    }

    /**************************-----------NEW SOLUTION--------------------------*****************/
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        while (head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int size=arr.size();
        int lastIndex=(size/k)*k;

        for (int i = 0;  i < lastIndex; i+=k) {
            for (int j = i+k-1; j >=i ; j--) {
                addtoResult(arr.get(j));
            }
        }

        while (lastIndex<size){
            addtoResult(arr.get(lastIndex));
            lastIndex++;
        }
        return result;

    }


    /**************************-----------OLD SOLUTION--------------------------*****************/

    public static void printListNode(ListNode root){
        if(root!=null){
            System.out.println(root.val);
            printListNode(root.next);
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
     int[] tempArr=new int[k];
        restArr(tempArr);
     int lastIndexForSingleArr=k-1;

     while (head!=null){
         if(lastIndexForSingleArr==-1){
             //add array values to result
             if(tempArr[k-1]!=-1){
                 //add from end to last added start

                 for (int i = 0; i < tempArr.length; i++) {
                     addtoResult(tempArr[i]);
                     tempArr[i]=-1;
                 }

//                 for (int arrVal:tempArr) {
//                     addtoResult(arrVal);
//                 }

             }

             lastIndexForSingleArr=k-1;
//             restArr(tempArr);
             continue;
         }else if(head.next==null&&lastIndexForSingleArr!=0&&tempArr[k-1]==-1){
//             restArr(tempArr);
             lastIndexForSingleArr=k-1;
         }

         tempArr[lastIndexForSingleArr]=head.val;
         lastIndexForSingleArr--;

         head=head.next;
     }
        if(tempArr[k-1]!=-1&&lastIndexForSingleArr!=-1){
            //add from end to last added start
            addLastArrValues(tempArr,lastIndexForSingleArr);
        }
        else if(tempArr[0]!=-1){
            for (int i = 0; i < tempArr.length; i++) {
                addtoResult(tempArr[i]);
                tempArr[i]=-1;
            }
//            for (int arrVal:tempArr) {
//                addtoResult(arrVal);
//            }
        }
        return result;
    }

    //add last arr values without revers
    private static void addLastArrValues(int[] arr,int lastPostionAdded){
        for (int i = arr.length-1; i >lastPostionAdded ; i--) {
            addtoResult(arr[i]);
        }
    }

    private static void restArr(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            arr[i]=-1;
        }
    }


    private static ListNode addtoResult(int key) {
        ListNode newNode=new ListNode(key);
        if(result==null){
            result=newNode;
            lastPostion=result;
            return newNode;
        }
        lastPostion.next=newNode;
        lastPostion=newNode;
        return newNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
