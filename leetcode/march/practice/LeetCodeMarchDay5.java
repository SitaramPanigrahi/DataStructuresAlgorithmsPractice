package leetcode.march.practice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode
{
    TreeNode right;
    TreeNode left;
    int val;

    public TreeNode (int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class LeetCodeMarchDay5 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode (3);
        root.left = new TreeNode (9);
        root.right = new TreeNode (20);
        root.right.left = new TreeNode (15);
        root.right.right = new TreeNode (7);

        DecimalFormat format = new DecimalFormat ("0.#");
        AverageLevelsInBinaryTree.averageOfLevels(root).forEach(i -> {
            System.out.println(format.format (i));
        });

    }

    static class AverageLevelsInBinaryTree {
        public static List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();

            //base condition
            if (root == null) return null;

            ans.add((double) root.val);
            if (root.left == null && root.right == null) return ans;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(new TreeNode (Integer.MIN_VALUE));

            double sum = 0.00d;
            int numOfElemes = 0;

            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();

                if (currentNode != null && currentNode.val != Integer.MIN_VALUE)
                    System.out.println("Polled Data: " + currentNode.val);

                if (currentNode.left != null)
                {
                    sum += currentNode.left.val;
                    numOfElemes++;

                    queue.add(currentNode.left);
                }

                if (currentNode.right != null)
                {
                    sum += currentNode.right.val;
                    numOfElemes++;

                    queue.add(currentNode.right);
                }

                if (null != queue.peek () && queue.peek().val == Integer.MIN_VALUE)
                {
                    queue.poll();

                    if (numOfElemes != 0)
                    {
                        ans.add(sum/numOfElemes);
                    }

                    sum = 0.00d;
                    numOfElemes = 0;
                    System.out.println("Ended Level");
                    queue.add(new TreeNode (Integer.MIN_VALUE));
                }
            }

            return ans;
        }
    }
}
