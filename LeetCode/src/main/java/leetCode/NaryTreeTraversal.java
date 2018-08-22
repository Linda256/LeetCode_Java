package leetCode;

import java.util.ArrayList;
import java.util.List;

//Definition for a Node.
class Node {
 public int val;
 public List<Node> children;

 public Node() {}

 public Node(int _val,List<Node> _children) {
     val = _val;
     children = _children;
 }
};


public class NaryTreeTraversal{
 
	 List<Integer> visited = new ArrayList<Integer>();
	 
	 public List<Integer> preorder(Node root) {
	     Node curr = root;
	     if (curr == null ) return visited;
	     visited.add(curr.val);
	     if (curr.children != null){
	         for (Node child : curr.children){
	                 preorder(child);
	         }
	     }
	     return visited;
	 }
	 
	public static void main(String[] args){
		Node n1 = new Node();
		n1.val=5;
		List<Node> children=new ArrayList<Node>();
		children.add(n1);
		Node n2 = new Node(15,children);
		System.out.println(n2.children.get(0).val);
		NaryTreeTraversal t = new NaryTreeTraversal();
		List<Integer> result = t.preorder(n2);
		System.out.println(result);
	}
}