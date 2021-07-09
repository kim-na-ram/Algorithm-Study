package naram.algorithm_study;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Network {
    
    private int nV;
    private ArrayList<ArrayList<Integer>> network;
    private boolean[] visited;
    private int count;
    
    public Network(int nV) {
        
        this.nV = nV;
        this.count = 0;
        this.network = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < nV+1; i++) {
            this.network.add(new ArrayList<Integer>());
        }
        
        this.visited = new boolean[nV+1];
    }
    
    public int getCount() {
        return this.count;
    }
    
    public void put(int x, int y) {
        network.get(x).add(y);
        network.get(y).add(x);
    }
    
    public void clearVisited() {
        for(int i = 0; i < visited.length; i++)
            visited[i] = false;
    }
    
    public void dfs(int v) {
        visited[v] = true;
        if(v != 1)
            count += 1;
        
        for(int i : this.network.get(v)) {
            
            if(this.visited[i] == false) {
                dfs(i);
            }
        }
        
    }
    
}

public class Virus_2606 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Network network = new Network(n);
	    
	    int nE = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st;
	    
	    while(nE --> 0) {
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        while(st.hasMoreTokens()) {
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            
	            network.put(x, y);
	        }
	        
	    }
	    
	    network.dfs(1);
	    
	    System.out.println(network.getCount());
	    
	}
}