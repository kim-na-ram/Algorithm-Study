package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

import java.util.Collections;

class Search {
    
    private int N, M;
    private ArrayList<ArrayList<Integer>> graph;
    private ArrayList<Integer> bfslist;
    private boolean[] dfsVisited;
    private boolean[] bfsVisited;
    
    private Queue<Integer> queue;
    
    public StringBuilder sb;
    
    public Search(int N, int M) {
        
        this.N = N;
        this.M = M;
        this.graph = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < N + 1; i++) {
            this.graph.add(new ArrayList<Integer>());
        }
        
        this.dfsVisited = new boolean[N+1];
        this.bfsVisited = new boolean[N+1];
        
        sb = new StringBuilder();
        
    }
    
    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    
    public void sort() {
        
        for(int i = 0; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }
        
    }
    
    public void dfs(int V) {
        
        dfsVisited[V] = true;
        sb.append(V).append(" ");
        
        for(int i : this.graph.get(V)) {
            
            if(this.dfsVisited[i] == false) {
                dfs(i);
            }
        }
        
    }
    
    public void bfs(int V) {
        
        queue = new LinkedList<Integer>();
        bfslist = new ArrayList<Integer>();
        
        queue.offer(V);
        bfsVisited[V] = true;
        sb.append(V).append(" ");
        
        while(!queue.isEmpty()) {
	        
	        int q = queue.poll();
	        bfslist.add(q);
	        
	        for(int i : graph.get(q)) {
	            
	            if(!bfsVisited[i]) {
	                queue.offer(i);
	                bfsVisited[i] = true;
                    sb.append(i).append(" ");
	            }
	            
	        }
	        
	    }  
    }
    
}

public class DFSandBFS_1260 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    
	    int N = Integer.parseInt(st.nextToken()); // 정점의 개수
	    int M = Integer.parseInt(st.nextToken()); // 간선의 개수
	    int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 개수
	    
	    Search search = new Search(N, M);
	    
	    
	    for(int i = 0; i < M; i++) {
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        search.put(x, y);
	        
	    }
	    
	    search.sort();
	    
	    search.dfs(V);
	    
	    search.sb.append("\n");
	    
	    search.bfs(V);
	    
	    System.out.println(search.sb);
	    
	    
    }
}
