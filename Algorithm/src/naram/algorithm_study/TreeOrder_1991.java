package naram.algorithm_study;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TreeNode {
	
	char data;
	TreeNode left;
	TreeNode right; 
	
	public TreeNode(char data) {
		this.data = data;
	}
	
}

class Tree {
	
	TreeNode root;
	
	public void addNode(char data, char left, char right) {
		
		if(root == null) {
			root = new TreeNode(data);
			
			if(left != '.') {
				root.left = new TreeNode(left);
			}
			if(right != '.') {
				root.right = new TreeNode(right);
			}
			
		} else {
			searchNode(root, data, left, right);
		}
		
	}
	
	public void searchNode(TreeNode node, char data, char left, char right) {
		
		if(node == null ) {
			return ;
		} else if(node.data == data) {
			if(left != '.') {
				node.left = new TreeNode(left);
			}
			if(right != '.') {
				node.right = new TreeNode(right);
			}
		} else {
			searchNode(node.left, data, left, right);
			searchNode(node.right, data, left, right);
		}
		
	}
	
	public void Preorder(TreeNode root) {
		
		if(root == null) return ;
		
		System.out.print(root.data);
		Preorder(root.left);
		Preorder(root.right);
		
	}
	
	public void Inorder(TreeNode root) {
		
		if(root == null) return ;
		
		Inorder(root.left);
		System.out.print(root.data);
		Inorder(root.right);
		
	}
	
	public void Postorder(TreeNode root) {
		
		if(root == null) return ;
		
		Postorder(root.left);
		Postorder(root.right);
		System.out.print(root.data);
		
	}
	
}

public class TreeOrder_1991 {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	char[] t = new char[3];
    	
    	Tree tree = new Tree();
    	
    	for(int i = 0; i < N; i++) {
    		
    		t = br.readLine().replaceAll(" ", "").toCharArray();
    		
    		tree.addNode(t[0], t[1], t[2]);
    		
    	}
    	
    	tree.Preorder(tree.root);
    	System.out.println();
    	
    	tree.Inorder(tree.root);
    	System.out.println();
    	
    	tree.Postorder(tree.root);
        
    }
}