import java.net.Inet4Address;

public class AddTowLinkedListRevers {
    //    Example 1:
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

//    Example 2:
//    Input: l1 = [0], l2 = [0]
//    Output: [0]

    //    Example 3:
//    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//    Output: [8,9,9,9,0,0,0,1]

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

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }




    public static void main(String[] args) {

//        ListNode l1=new ListNode(2);
//        ListNode l12=new ListNode(4);
//        l1.next=l12;
//        ListNode l13=new ListNode(3);
//        l12.next=l13;
//
//        ListNode l2=new ListNode(5);
//        ListNode l22=new ListNode(6);
//        l2.next=l22;
//        ListNode l23=new ListNode(4);
//        l22.next=l23;
        // l1 = [2,4,3], l2 = [5,6,4]

        //test printing
//        System.out.println(allValues_Rec_Reverse(l1));

        //apply
//        ListNode result=addTwoNumbers(l1,l2);
//        System.out.println(allValues_Rec_Reverse(result));

        ListNode l1=new ListNode(9);
//        ListNode l1ToMove=l1;
//        for (int i = 1; i <=6 ; i++) {
//            l1ToMove= l1ToMove.addToNode(9);
//        }


        ListNode l2=new ListNode(1);
        ListNode l2ToMove=l2;
        for (int i = 1; i <=9 ; i++) {
          l2ToMove= l2ToMove.addToNode(9);
        }


         System.out.println(allValues_Rec_Reverse(l1));
        System.out.println(allValues_Rec_Reverse(l2));


        ListNode result=addTwoNumbers(l1,l2);
        System.out.println(allValues_Rec_Reverse(result));




    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1
        //first must get all first linked  values and pars them to int
        //get all secodned linked values as integer//revers tehn to int

        ListNode root=new ListNode(-1);
        ListNode toMoveRoot=root;
        ListNode toMoveL1=l1;
        ListNode toMoveL2=l2;

        int left=0;
        while (toMoveL1!=null||toMoveL2!=null){
            int l1Val= toMoveL1!=null? toMoveL1.val:0;
            int l2Val= toMoveL2!=null? toMoveL2.val:0;
            int result=l1Val+l2Val+left;
            ListNode newNode=new ListNode(result%10);
            left=result/10;
            toMoveRoot.next=newNode;
            toMoveRoot=newNode;

            toMoveL1=toMoveL1!=null?toMoveL1.next:null;
            toMoveL2=toMoveL2!=null?toMoveL2.next:null;

        }
        if(left!=0){
            ListNode newNode=new ListNode(left);
            toMoveRoot.next=newNode;
            toMoveRoot=newNode;
        }
        root=root.next;

        return root;

        //3
        //convert int to string and revirs it and convert each number to listNode


    }

    //loop throw all values in list and get reverse String
    public static String allValues_Rec_Reverse(ListNode root){
        if(root==null){
            return "";
        }
        return allValues_Rec_Reverse(root.next)+root.val;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         ListNode addToNode(int valueToAdd){
            ListNode newNode=new ListNode(valueToAdd);
            this.next=newNode;
            return newNode;
        }
    }

}
