import java.util.ArrayList;
import java.util.Comparator;

public class MergeSortedLinkedList {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // na + nb + ((na + nb) log(na + nb)) + na + nb
        // = 2na + 2nb + ((na + nb) log(na + nb))
        ListNode l1 = list1;
        ListNode l2 = list2;
        ArrayList<Integer> mainList = new ArrayList<Integer>();

        arrayListAppend(l1, mainList); // na
        arrayListAppend(l2, mainList); // nb

        mainList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }); // O(nlog(n)) , O(na + nb log(na + nb))
        // copy list into ListNode
        ListNode head = null;
        ListNode lastNode = null;
        for (int val : mainList) { // na + nb = na + nb
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                lastNode = head;
            } else {
                lastNode.next = node;
                lastNode = node;
            }
        }

        return head;

    }

    public static ArrayList arrayListAppend(ListNode list1, ArrayList baseList) {
        ListNode node = list1;
        while (node != null) {
            baseList.add(node.val);
            node = node.next;
        }
        return baseList;

    }


//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode l1 = list1;
//        ListNode l2 = list2;
//        ListNode myHead = null;
//        ListNode lastAddedNode = null;
//        while (l1 != null || l2 != null) {
//            ListNode[] hyperArr = new ListNode[0];
//            if (l1 != null && l2 != null) {
//                hyperArr = new ListNode[2];
//                if (l1.val <= l2.val) {
//                    hyperArr[0] = l1;
//                    hyperArr[1] = l2;
//                } else {
//                    hyperArr[0] = l2;
//                    hyperArr[1] = l1;
//                }
//            } else if (l1 != null) {
//                hyperArr = new ListNode[1];
//                hyperArr[0] = l1;
//            } else {
//                hyperArr = new ListNode[1];
//                hyperArr[0] = l2;
//            }
//
//
//            for (int i = 0; i < hyperArr.length; i++) {
//                ListNode node = new ListNode(hyperArr[i].val);
//                if (myHead == null) {
//                    myHead = node;
//                    lastAddedNode = node;
//                } else {
//                    // AppendLast
//                    // TODO: OOptimize append last by store last added node
//                    lastAddedNode.next = node;
//
////                    ListNode headCp = myHead;
////                    while (headCp.next != null){
////                        headCp = headCp.next;
////                    }
////                    headCp.next = node;
//                }
//            }
//            lastAddedNode = hyperArr[hyperArr.length - 1];
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//
//        }
//
//        return myHead;
//
//    }

    public static void NodePrinter(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("----------------------------");

    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(5)));

        NodePrinter(list1);
        NodePrinter(list2);
        ListNode merged = mergeTwoLists(list1, list2);
        NodePrinter(merged);


    }

}
