package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Party_1238 {
	
	public static class Road implements Comparable<Road> {
		
		int E;
		int Ti;
		
		public Road(int E, int Ti) {
			this.E = E;
			this.Ti = Ti;
		}
		
		@Override
		public int compareTo(Road r) {
			return this.Ti - r.Ti;
		}
		
	}
	
	public static int N, M, X;
	public static int max;
	public static ArrayList<Road>[] list;
	public static int[] distance;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Road>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int Ti = Integer.parseInt(st.nextToken());
			
			list[S].add(new Road(E, Ti));
		}
		
		for(int i = 1; i < N + 1; i++) {
			distance = new int[N + 1];
			check = new boolean[N + 1];

			Arrays.fill(distance, Integer.MAX_VALUE);
			
			Dijkstra(i);
			
			int toX = distance[X];
			
			distance = new int[N + 1];
			check = new boolean[N + 1];

			Arrays.fill(distance, Integer.MAX_VALUE);
			
			Dijkstra(X);
			
			int fromX = distance[i];
			
			max = Math.max(max, toX + fromX);
		}
		
		System.out.println(max);
		
	}
	
	public static void Dijkstra(int S) {
		
		PriorityQueue<Road> queue = new PriorityQueue<Road>();
		
		queue.offer(new Road(S, 0));
		distance[S] = 0;
		
		while(!queue.isEmpty()) {
			
			Road r = queue.poll();
			int cur = r.E;
			
			if(check[cur]) continue;
			check[cur] = true;
			
			for(Road nr : list[cur]) {
				if(distance[nr.E] > distance[cur] + nr.Ti) {
					distance[nr.E] = distance[cur] + nr.Ti;
					queue.offer(new Road(nr.E, distance[nr.E]));
				}
			}
			
		}
		
	}

}
