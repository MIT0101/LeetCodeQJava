import java.util.List;

public class MergeTwoSortedLists {
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
//Example
//    Input: list1 = [1,2,4], list2 = [1,3,4]
//    Output: [1,1,2,3,4,4]

    static ListNode head;
    public static void main(String[] args) {

        ListNode root1=new ListNode(10);
        ListNode n11=new ListNode(20);
        root1.next=n11;
        ListNode n12=new ListNode(30);
        n11.next=n12;
        ListNode n13=new ListNode(40);
        n12.next=n13;


        ListNode root2=new ListNode(100);
        ListNode n21=new ListNode(200);
        root2.next=n21;
        ListNode n22=new ListNode(300);
        n21.next=n22;
        ListNode n23=new ListNode(400);
        n22.next=n23;


        System.out.println("l1");
        printListNode(root1);
        System.out.println("l2");
        printListNode(root2);

        ListNode result=mergeTwoLists(root1,root2);
        System.out.println("result ---------------------");
        printListNode(result);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1Head=list1;
        ListNode l2Head=list2;
        if(l1Head==null&&l2Head==null){
            return null;
        }
        ListNode l2Node=l2Head;
        while (l2Node!=null){
            insertSort(l1Head,l2Node);
            l2Node=l2Node.next;
        }

        return l1Head;
    }

    public static void loopThro(ListNode rootBais,ListNode rootToAdd){

    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public static void printListNode(ListNode root){
        if(root!=null){
            System.out.println(root.val);
            printListNode(root.next);
        }
      }

      public static ListNode insertSort(ListNode head,ListNode newNode){
        if(head==null){
            head=newNode;
            return newNode;
        }
        if(head!=null&&head.val>newNode.val){
            ListNode temp=head;
            newNode.next=temp;
            head=newNode;
            return newNode;
        }
        else{
            ListNode node=head;
            while (node.next!=null&&node.next.val< newNode.val){
                node=node.next;
            }
            ListNode temp=node.next;
            node.next=newNode;
            newNode.next=temp;
            return newNode;
        }

      }

}
