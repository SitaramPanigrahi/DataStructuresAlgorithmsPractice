package leetcode.march.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeMarchDay14 {
    public static void main(String[] args) {
        List<Integer> nodeVals = new ArrayList<>();

        nodeVals.add(1);
        nodeVals.add(2);
       /* nodeVals.add(3);
        nodeVals.add(4);
        nodeVals.add(5);

        int k = 1;

        System.out.println("BEFORE : " + nodeVals);

        int frontVal = nodeVals.get(k -1);
        int backVal = nodeVals.get(nodeVals.size() - k);

        nodeVals.set(k - 1, backVal);
        nodeVals.set(nodeVals.size() - k, frontVal);

        System.out.println("AFTER : " + nodeVals);
        */

        LeetCodeMarchDay14 obj = new LeetCodeMarchDay14 ();
        System.out.println("TEST 1");

        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;

        ListNode node = obj.createNodes(arr);
        System.out.println("BEFORE SWAP");
        obj.printNodes(node);

        ListNode resNode = obj.doSwapLinkedListNode(node, k);
        System.out.println("AFTER SWAP");
        obj.printNodes(resNode);

        System.out.println("TEST 2");

        arr = new int[]{7,9,6,6,7,8,3,0,9,5};
        k = 5;

        node = obj.createNodes(arr);
        System.out.println("BEFORE SWAP");
        obj.printNodes(node);

        resNode = obj.doSwapLinkedListNode(node, k);
        System.out.println("AFTER SWAP");
        obj.printNodes(resNode);

        System.out.println("TEST 3");

        arr = new int[]{1};
        k = 1;

        node = obj.createNodes(arr);
        System.out.println("BEFORE SWAP");
        obj.printNodes(node);

        resNode = obj.doSwapLinkedListNode(node, k);
        System.out.println("AFTER SWAP");
        obj.printNodes(resNode);

        System.out.println("TEST 4");

        arr = new int[]{1,2};
        k = 1;

        node = obj.createNodes(arr);
        System.out.println("BEFORE SWAP");
        obj.printNodes(node);

        resNode = obj.doSwapLinkedListNode(node, k);
        System.out.println("AFTER SWAP");
        obj.printNodes(resNode);

        System.out.println("TEST 5");

        arr = new int[]{1,2,3};
        k = 2;

        node = obj.createNodes(arr);
        System.out.println("BEFORE SWAP");
        obj.printNodes(node);

        resNode = obj.doSwapLinkedListNode(node, k);
        System.out.println("AFTER SWAP");
        obj.printNodes(resNode);


    }

    public void printNodes (ListNode node) {
        while (node != null) {
            System.out.print (node.val + "  ");
            node = node.next;
        }
        System.out.println ("\n");
    }

    public ListNode createNodes (int[] nodeVals) {
        ListNode head = new ListNode (nodeVals [0]);

        ListNode node = head;
        for (int i = 1; i < nodeVals.length; i++) {
            node.next = new ListNode (nodeVals [i]);
            node = node.next;
        }

        return head;
    }

    public ListNode doSwapLinkedListNode (ListNode head, int k) {
        SwapLinkedListNode ref = new SwapLinkedListNode ();
        return ref.swapNodes(head, k);
    }

     class SwapLinkedListNode {
        public ListNode swapNodes (ListNode head, int k) {
            List<Integer> nodeVals = new ArrayList<>();

            ListNode node = head;
            while (node != null) {
                nodeVals.add(node.val);
                node = node.next;
            }

            //System.out.println("BEFORE : " + nodeVals);

            int frontVal = nodeVals.get(k -1);
            int backVal = nodeVals.get(nodeVals.size() - k);

            nodeVals.set(k - 1, backVal);
            nodeVals.set(nodeVals.size() - k, frontVal);

            //System.out.println("AFTER : " + nodeVals);

            return createNodes (nodeVals);
        }

         public ListNode createNodes (List<Integer> nodeVals) {
             ListNode head = new ListNode (nodeVals.get (0));

             ListNode node = head;
             for (int i = 1; i < nodeVals.size(); i++) {
                 node.next = new ListNode (nodeVals.get(i));
                 node = node.next;
             }

             return head;
         }
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
