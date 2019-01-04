package leetCode;
/* 257 Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

import java.util.ArrayList;
import java.util.List;

public class BTreePath {
	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> pathList = new ArrayList<String>();
        if(root!=null){
            String path = ""+root.val;
		    treePath(root,pathList,path);
        }	
		return pathList;  
    }
	
	public void treePath(TreeNode node, List<String> pathList,String path){
		if (node.left == null && node.right == null){
			pathList.add(path);
		}
		if (node.left !=null) treePath(node.left,pathList,path+"->"+node.left.val);
		if (node.right !=null) treePath(node.right,pathList,path+"->"+node.right.val);						
    }
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
//		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		n1.left=n2;
		n1.right=n3;
		n2.right=n5;
		BTreePath paths = new BTreePath();
		List<String> pathList = paths.binaryTreePaths(n1);
		System.out.println(pathList);	
	}

}

/**
 * Definition for a binary tree node.
 */
// class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

