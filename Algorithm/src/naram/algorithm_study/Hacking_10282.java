package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Hacking_10282 {
	
	public static class Dependency implements Comparable<Dependency> {
	    int depend;
	    int second;
	    
	    public Dependency(int depend, int second) {
	        this.depend = depend;
	        this.second = second;
	    }
	    
	    @Override
	    public int compareTo(Dependency d) {
	        return this.second - d.second;
	    }
	}
	
	public static ArrayList<Dependency>[] network;
	public static int[] distance;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0) {
		    
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    
		    int n = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    
		    network = new ArrayList[n + 1];
		    distance = new int[n + 1];
		    check = new boolean[n + 1];
		    
		    for(int i = 0; i < n + 1; i++)
		        network[i] = new ArrayList<Dependency>();
		        
	        Arrays.fill(distance, Integer.MAX_VALUE);
		    
		    for(int i = 0; i < d; i++) {
		        st = new StringTokenizer(br.readLine(), " ");
		        
		        int a = Integer.parseInt(st.nextToken());
		        int b = Integer.parseInt(st.nextToken());
		        int s = Integer.parseInt(st.nextToken());
		        
		        network[b].add(new Dependency(a, s));
		    }
		    
		    Dijkstra(c);
		    
		    int count = 0;
		    int time = 0;
		    
		    for(int i = 1; i < n + 1; i++) {
		        if(distance[i] != Integer.MAX_VALUE) {
		            count += 1;
		            time = Math.max(time, distance[i]);
		        }
		    }
		    
		    sb.append(count + " " + time).append("\n");
		    
		}
		
		System.out.println(sb);
		
	}
	
	public static void Dijkstra(int S) {
		
		PriorityQueue<Dependency> queue = new PriorityQueue<Dependency>();
		
		queue.offer(new Dependency(S, 0));
		distance[S] = 0;
        
        while (!queue.isEmpty()) {
            Dependency d = queue.poll();
            
            if(check[d.depend] == true) continue;
            check[d.depend] = true;
            
            for(Dependency dependency : network[d.depend]) {
                if(!check[dependency.depend] && distance[dependency.depend] > distance[d.depend] + dependency.second) {
                    distance[dependency.depend] = distance[d.depend] + dependency.second;
                    queue.offer(new Dependency(dependency.depend, distance[dependency.depend]));
                }
            }
            
        }
	}
	
}