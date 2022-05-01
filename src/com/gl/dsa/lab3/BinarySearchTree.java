package com.gl.dsa.lab3;

import java.util.*;

public class BinarySearchTree {
	
	static class Node {
		
		int data;
		Node leftNode;
		Node rightNode;
	}
	
	static Node NewNode(int data) {
		
		Node temp = new Node();
		temp.data = data;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}
	
	static Node insert(Node root, int key) {
		
		if(root == null)
			return NewNode(key);
		
		if(key<root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}
	
	static boolean findpair(Node root, int sum, HashSet<Integer> set) {
		
		if(root == null)
			return false;
		
		if(findpair(root.leftNode, sum, set))
			return true;
		
		if(set.contains(sum - root.data)) {
			System.out.println("Pair nodes found");
			System.out.println("Pair is ( "+(sum-root.data) +" , "+root.data+ " )\n");
			return true;
		}
		else
			set.add(root.data);
		
		return findpair(root.rightNode, sum, set);
	}
	
	static void findpair1(Node root, int sum) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findpair(root, sum, set))
			System.out.println("Pair nodes are not found");
	}
	
	//Driver code
	public static void main(String[] args) {
		
		Node root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);
		
		//Hardcoded input for both the cases
		int sum1 = 130;
		findpair1(root,sum1);
		
		int sum2 = 500;
		findpair1(root,sum2);
	}
}
