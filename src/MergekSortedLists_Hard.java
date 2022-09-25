import java.util.*;

public class MergekSortedLists_Hard {

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
//    Input: lists = [[1,4,5],[1,3,4],[2,6]]
//    Output: [1,1,2,3,4,4,5,6]
//    Explanation: The linked-lists are:
//            [
//            1->4->5,
//            1->3->4,
//            2->6
//            ]
//    merging them into one sorted list:
//            1->1->2->3->4->4->5->6

    static ListNode head1;
    static ListNode head2;

    static ListNode result;
    static ListNode lastPostion;

    public static void main(String[] args) {
        System.out.println("l1");

        ListNode root1=new ListNode(10);
        ListNode n11=new ListNode(20);
        head1=root1;
        root1.next=n11;
        ListNode n12=new ListNode(30);
        n11.next=n12;
        ListNode n13=new ListNode(40);
        n12.next=n13;
        System.out.println("l2");

        ListNode root2=new ListNode(100);
        ListNode n21=new ListNode(200);
        head2=root2;
        root2.next=n21;
        ListNode n22=new ListNode(300);
        n21.next=n22;
        ListNode n23=new ListNode(400);
        n22.next=n23;
        ListNode[] listNodes=new ListNode[2];
        listNodes[0]=head1;
        listNodes[1]=head2;

//        printListNode(head1);

        ListNode rr=mergeKLists(listNodes);

        printListNode(rr);


    }
    public static void printListNode(ListNode root){
        if(root!=null){
            System.out.println(root.val);
            printListNode(root.next);
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (ListNode node:lists) {
            while (node!=null){

                int count=1;
                if(map.containsKey(node.val)){
                    count=map.get(node.val)+1;
                }
                map.put(node.val, count);
                node=node.next;
            }
        }

        lastPostion=result;
        // create a TreeMap
        TreeMap<Integer, Integer> tm = new TreeMap<>(map);
        for (int key:tm.keySet()) {
            int times=tm.get(key);
            for (int i = 1; i <=times ; i++) {
                lastPostion= addtoResult(key);
            }

        }

        return result;
    }

    private static ListNode addtoResult(int key) {
        ListNode newNode=new ListNode(key);
        if(result==null){
            result=newNode;
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
