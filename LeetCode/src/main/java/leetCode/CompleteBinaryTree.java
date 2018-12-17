package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * In a complete binary tree every level, except possibly the last,
 *  is completely filled, and all nodes in the last level are as far left as possible.
 *   It can have between 1 and 2h nodes inclusive at the last level h.
 *   Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and 
{2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 */
public class CompleteBinaryTree {
	
		public boolean isCompleteTree(TreeNode root) {
			
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while(q.peek()!=null){
				TreeNode curr=q.remove();
				q.add(curr.left);
				q.add(curr.right);
			}
			while(!q.isEmpty() && q.peek() == null){
				q.remove();
			}
			return q.isEmpty();
	    }
		public static void main(String[] args) {
			TreeNode n1=new TreeNode(1);
			TreeNode n2=new TreeNode(2);
			TreeNode n3=new TreeNode(3);
			TreeNode n4=new TreeNode(4);
			TreeNode n5=new TreeNode(5);
			TreeNode n6=new TreeNode(6);
			TreeNode n7=new TreeNode(7);
			n1.left = n2;
			n1.right = n3;
			n2.left = n4;
			n2.right=n5;
			n3.left=n6;
			n3.right = n7;
			CompleteBinaryTree tr = new CompleteBinaryTree();
			boolean res=tr.isCompleteTree(n1);
			System.out.println(res);
			
		}

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	    TreeNode(int x) { val = x; }
}
