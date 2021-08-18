package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm_1753 {

	public static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
	}
	
	public static int V, E, K;
	public static final int INF = Integer.MAX_VALUE;
	public static ArrayList<Node>[] weight;
	public static int[] distance;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		weight = new ArrayList[V + 1];
		
		for(int i = 0; i < V+1; i++)
			weight[i] = new ArrayList<Node>();
		
		distance = new int[V+1];
		
		Arrays.fill(distance, INF);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			weight[u].add(new Node(v, w));
		}
		
		Dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < V+1; i++) {
			if(distance[i] == INF) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		
	}
	
	public static void Dijkstra(int K) {
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		check = new boolean[V + 1];
		queue.offer(new Node(K, 0));
		distance[K] = 0;
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			int cur = node.end;
			
			if(check[cur]) continue;
			check[cur] = true;
			
			for(Node n : weight[cur]) {
				System.out.print(cur + " -> " + n.end + " ");
				if(distance[n.end] > distance[cur] + n.weight) {
					distance[n.end] = distance[cur] + n.weight;
					queue.offer(new Node(n.end, distance[n.end]));
				}
			}
			
		}
	}
	
}
