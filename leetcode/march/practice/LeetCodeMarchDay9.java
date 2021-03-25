package leetcode.march.practice;

import java.util.LinkedList;
import java.util.Queue;

/*
    TREE : https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/
 */
public class LeetCodeMarchDay9 {

    public static void main(String[] args) {
        LeetCodeMarchDay9 obj = new LeetCodeMarchDay9();
        obj.solution();
    }

    public void solution () {
        AddOneRowTree sol = new AddOneRowTree();
        TreeNode root = sol.treeNodeUtil();
        int v = 1;
        int d = 3;
        TreeNode resultNode = sol.addOneRow(root, v, d);
    }

     class AddOneRowTree {
        public TreeNode addOneRow(TreeNode root, int v, int d) {

            if (null == root) {
                return new TreeNode (v);
            }

            if (d == 1) {
                TreeNode tempRoot = root;
                root = new TreeNode(v);
                root.left = tempRoot;
            }

            //Iterate till the depth
            if (d >= 2) {
                d--;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                queue.offer (new TreeNode (Integer.MIN_VALUE));
                d--;

                while (!queue.isEmpty() && d != 0) {
                    TreeNode currentNode = queue.poll();

                    if (currentNode.left != null) queue.offer(currentNode.left);
                    if (currentNode.right != null) queue.offer (currentNode.right);

                    if (queue.peek() != null && queue.peek().val == Integer.MIN_VALUE) {
                        queue.poll ();
                        d--;

                        if (d != 0) queue.offer (new TreeNode (Integer.MIN_VALUE));
                    }
                }

                //Now add the new nodes to the depth


                while (!queue.isEmpty()) {
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode (v);

                    TreeNode currentNode = queue.poll();

                    TreeNode tempNodeLeft = currentNode.left;
                    TreeNode tempNodeRight = currentNode.right;

                    currentNode.left = newLeft;
                    currentNode.right = newRight;

                    if (tempNodeLeft != null) {
                        currentNode.left.left = tempNodeLeft;
                    }

                    if (tempNodeRight != null) {
                        currentNode.right.right = tempNodeRight;
                    }
                }

            }

            return root;
        }

        public TreeNode treeNodeUtil () {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode (3);
            root.left.right = new TreeNode (1);
            root.right = new TreeNode(6);
            root.right.left = new TreeNode(5);
            return root;
        }
    }

     private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int ipData) {
            val = ipData;
            left = right = null;
        }
    }
}
