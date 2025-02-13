package com.print.path;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/print-the-longest-path-from-root-to-leaf-in-a-binary-tree/
// https://www.youtube.com/watch?v=AIKUnInRL0M
public class FindLongestPathFromRootToLeaf {

	// Binary tree node
	static class Node {
		Node left;
		Node right;
		int data;
	};

	// Function to create a new Binary node
	static Node newNode(int data) {
		Node temp = new Node();

		temp.data = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}

	// Function to find and return the longest path
	// Post-Order Traversal
	public static ArrayList<Integer> longestPath(Node root) {

		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		ArrayList<Integer> left = longestPath(root.left);

		ArrayList<Integer> right = longestPath(root.right);

		// Compare the size of the two ArrayList and insert current node accordingly
		if (right.size() < left.size()) {
			left.add(root.data);
		} else {
			right.add(root.data);
		}

		return (left.size() > right.size() ? left : right);
	}

	public static int height(Node root) {

		if (root == null) {
			return 0;
		}

		int left = height(root.left);

		int right = height(root.right);

		int max = Math.max(left, right);

		return 1 + max;
	}

	public static void main(String[] args) {

/* Constructed binary tree is 
        1        = level 0    count=0
      /   \ 
     2     3     = level 1    count=1
    /  \    
   4    5       = level 2    count=2
         \
         6
*/
		
		Node root = newNode(1);
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.left.right.right = newNode(6);

		ArrayList<Integer> output = longestPath(root);

		System.out.println(output);

		int height = height(root);
		System.out.println("height = " + height);

	}

}
