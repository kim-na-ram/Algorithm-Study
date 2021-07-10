package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;

class Tree {
	
	private int nV;
	private ArrayList<Integer>[] tree;
	private boolean[] visited;
	private int[] parents;
	
	public Tree(int nV) {
		
		this.nV = nV;
		this.tree = new ArrayList[nV + 1];
		
		for(int i = 1; i < this.nV + 1; i++) {
			
			this.tree[i] = new ArrayList<Integer>();
			
		}
		
		this.visited = new boolean[this.nV + 1];
		this.parents = new int[this.nV + 1];
		
	}
	
	public int getParent(int i) {
		
		return this.parents[i];
		
	}
	
	public void put(int x, int y) {
		
		this.tree[x].add(y);
		this.tree[y].add(x);
		
	}
	
	public void dfs(int V) {
		
		visited[V] = true;
		
		for(int i : this.tree[V]) {
			
			if(!visited[i]) {
				parents[i] = V;
				dfs(i);
			}
			
		}
		
		
	}
	
}

public class FindTreeParent_11725 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int nV = Integer.parseInt(br.readLine());
	    
	    Tree tree = new Tree(nV);
	    
	    StringTokenizer st;
	    
	    int root = 1;
	    
	    for(int i = 0; i < nV - 1; i++) {
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        while(st.hasMoreTokens()) {
	        	int x = Integer.parseInt(st.nextToken());
	        	int y = Integer.parseInt(st.nextToken());
	        
	        	tree.put(x, y);
	        }
	        
	    }
	    
	    tree.dfs(1);
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 2; i < nV + 1; i++) {
	    	sb.append(tree.getParent(i)).append("\n");
	    	
	    }
	    
	    System.out.println(sb);
	    
	}
}