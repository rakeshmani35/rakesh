package com.k.leaves.bt;

import com.k.leaves.bt.PrintNodesHasKLeaves.Node;

// https://www.youtube.com/watch?v=PArGIFNfIDk&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=39
public class PrintNumberOfLeafNode {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int count = 0;

	public static void countLeavesNode(Node root) {

		if (root == null) {
			return;
		}

		// pre order check
		if (root.left == null && root.right == null) {
			count++;
		}

		countLeavesNode(root.left);

		// OR inorder check
		//if (root.left == null && root.right == null) {
		//	count++;
		//}
		
		countLeavesNode(root.right);
		
	
	}

	public static void main(String[] args) {

/* Constructed binary tree is 
        1         = level 0
      /    \ 
     2      3     = level 1
    /  \    / 
   4    5  8      = level 2
          /
         9
*/
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);
		root.right.left.left = new Node(9);

		countLeavesNode(root);

		System.out.println("count = "+count);

	}

}
