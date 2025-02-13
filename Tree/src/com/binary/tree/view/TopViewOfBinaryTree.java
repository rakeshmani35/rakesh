package com.binary.tree.view;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.binary.tree.view.BottomViewOfBinaryTree.Node;

// https://www.youtube.com/watch?v=c3SAvcjWb1E&list=PLeIMaH7i8JDj7DnmO7lll97P1yZjMCpgY&index=28
// level order traversal + vertical order traversal
public class TopViewOfBinaryTree {

	public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
    public static ArrayList<Integer> al;
	
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private static void verticalTravers(Node root, int hd) {

		if (root == null) {
			return;
		}

		if (ht.containsKey(hd)) {
			ArrayList<Integer> list = ht.get(hd);
			list.add(root.data);
			ht.put(hd, list);
		} else {
			al = new ArrayList<Integer>();
			al.add(root.data);
			ht.put(hd, al);
		}

		verticalTravers(root.left, hd - 1);
		verticalTravers(root.right, hd + 1);
	}

	
	  //  only use vertical distance
		private static List<Integer> resultList2 = new ArrayList<Integer>();

		public static List<Integer> topView(Node root,List<Integer> resultList) {

			// store elements at horizontal distance
			int hd = 0;
			verticalTravers(root, hd);

			ht.entrySet().stream().forEach(entry -> {
				ArrayList<Integer> list = entry.getValue();
				
				resultList.add(list.get(0));
				
			});

			return resultList;

		}
	
	public static void main(String[] args) {

//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
//		root.left.left.left = new Node(8);
//		root.left.left.right = new Node(9);
		
		
/* Constructed binary tree is 
        1        = level 0
      /   \ 
     2     3     = level 1
    /  \   / 
   4    5 8      = level 2
*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);		
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		topView(root, resultList);
		System.out.println(resultList);

	}

}
