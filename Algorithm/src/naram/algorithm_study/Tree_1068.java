package naram.algorithm_study;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;

class DFS {
	
	private int nV;
	private int count;
	private ArrayList<Integer>[] Tree;
	private boolean[] visited;
	private boolean[] removed;
	
	public DFS(int nV) {
		
		this.nV = nV;
		this.count = 0;
		this.Tree = new ArrayList[this.nV];
		this.visited = new boolean[this.nV];
		this.removed = new boolean[this.nV];
		
		for(int i = 0; i < this.nV; i++) {
			
			this.Tree[i] = new ArrayList<Integer>();
			
		}
		
	}
	
	public int getCount() {
		
		return this.count;
		
	}
	
	public void put(int x, int y) {
		
		this.Tree[x].add(y);
		
	}
	
	public void leaf(int S, int V) {
		// S는 시작 정점, V는 삭제해야 하는 노드 번호
		if(this.Tree[S].size() == 0) {
			count++;
			return ;
		}
		
		for(int i = 0; i < this.Tree[S].size(); i++) {
            int next = this.Tree[S].get(i);
            if(next != V)
                leaf(next, V);
        }
		
	}
	
	public void remove(int V) {
		
		for(int i = 0; i < this.Tree.length; i++) {
			for(int j = 0; j < this.Tree[i].size(); j++)
				if(this.Tree[i].get(j) == V) this.Tree[i].remove(j);
		}
		
	}
	
	
}

public class Tree_1068 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		DFS dfs = new DFS(N);
		
		int start = 0;
		
		for(int i = 0; i < N; i++) {
		    
			int x = Integer.parseInt(st.nextToken());
			
			if(x != -1) {
				dfs.put(x, i);
			} else {
				start = i;
			}
		}
		
		int v = Integer.parseInt(br.readLine());
		
		dfs.remove(v);
		
		dfs.leaf(start, v);
		
		if(v == start)
			System.out.println(0);
		else
			System.out.println(dfs.getCount());
		
	}

}