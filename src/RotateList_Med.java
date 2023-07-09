public class RotateList_Med {

//    Input: head = [1,2,3,4,5], k = 2
//    Output: [4,5,1,2,3]

    //Me
    //Time 0ms beats 100%
    //Memory 41.3 beats 80.85%

    public static void main(String[] args) {

        ListNode head=new ListNode(1);
        ListNode p2=new ListNode(2);
        head.next=p2;
        ListNode p3=new ListNode(3);
        p2.next=p3;
        ListNode p4=new ListNode(4);
        p3.next=p4;
        ListNode p5=new ListNode(5);
        p4.next=p5;

        print(head);
        System.out.println("-------");
        ListNode rotateHead= rotateRight(head,2);
        print(rotateHead);




    }

    public  static  void print(ListNode head){
        ListNode headCopy=head;
        while (headCopy!=null){
            System.out.println(headCopy.val);
            headCopy=headCopy.next;
        }

    }
     public static ListNode rotateRight(ListNode head, int k) {
     ListNode headCopy=head;
     int size=0;
     while (headCopy!=null){
         headCopy=headCopy.next;
         size++;
     }
     //if there no rotait or empity linkedlist
         if(k<=0 || size<=1 || size==k){
             return  head;
         }

     if(k>size){
         //round if k is greated than size
         return  rotateRight(head,k%size);
     }

     headCopy=head;
     int stop=size-k;
     int pos=1;
     while (headCopy!=null&&pos<stop){
         headCopy=headCopy.next;
         pos++;
     }

     //start switch linkes

     ListNode newHead=headCopy.next;
     ListNode newHeadCopy=newHead;
     headCopy.next=null;
       while (newHeadCopy.next!=null){
            newHeadCopy=newHeadCopy.next;
        }
       newHeadCopy.next=head;
       return  newHead;
      }
      private static class ListNode {
          int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
