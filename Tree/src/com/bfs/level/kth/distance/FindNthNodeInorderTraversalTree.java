package com.bfs.level.kth.distance;

// https://www.geeksforgeeks.org/find-n-th-node-inorder-traversal/
public class FindNthNodeInorderTraversalTree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	
	public static void inorder(Node root) {

		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	static int count = 0;
	public static void nthNodeInorder(Node root, int n) {
		if (root==null) {
			return ;
		}
		
		nthNodeInorder(root.left,n);
		count++;
		if (count==n) {
			System.out.println(n+"th node in inorder traversal = "+root.data);
		}
		
		nthNodeInorder(root.right,n);
	}

	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		inorder(root);
		
		System.out.println();
		int n = 4;
		nthNodeInorder(root,n);
		

	}

}
