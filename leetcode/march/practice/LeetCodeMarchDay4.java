package leetcode.march.practice;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3660/
 */
public class LeetCodeMarchDay4 {
    public static void main(String[] args) {

    }

    static class IntersectionLinkedList {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = 0;
            int lengthB = 0;

            ListNode nodeA = headA;
            ListNode nodeB = headB;

            while (nodeA != null || nodeB != null)
            {
                if (nodeA != null)
                {
                    lengthA++;
                    nodeA = nodeA.next;
                }

                if (nodeB != null)
                {
                    lengthB++;
                    nodeB = nodeB.next;
                }
            }

            while (lengthA > lengthB)
            {
                headA = headA.next;
                lengthA--;
            }

            while (lengthA < lengthB)
            {
                headB = headB.next;
                lengthB--;
            }

            while (headA != headB)
            {
                headA = headA.next;
                headB = headB.next;
            }

            return headA;
        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
