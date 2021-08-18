package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumExpense_1916 {
	
	public static class City implements Comparable<City> {
		int next;
		int expense;
		
		public City(int next, int expense) {
			this.next = next;
			this.expense = expense;
		}
		
		@Override
		public int compareTo(City c) {
			return this.expense - c.expense;
		}
	}
	
	public static int N, M, S, E;
	public static final int INF = Integer.MAX_VALUE;
	public static ArrayList<City>[] weight;
	public static int[] distance;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		weight = new ArrayList[N + 1];
		
		for(int i = 0; i < N + 1; i++)
			weight[i] = new ArrayList<City>();
		
		distance = new int[N + 1];
		check = new boolean[N + 1];
		
		Arrays.fill(distance, INF);
		
		StringTokenizer st;
		
		for(int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			weight[s].add(new City(e, w));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Dijkstra(S);
		
		System.out.println(distance[E]);
		
	}
	
	public static void Dijkstra(int S) {
		PriorityQueue<City> queue = new PriorityQueue<City>();
		queue.offer(new City(S, 0));
		distance[S] = 0;
		
		while(!queue.isEmpty()) {
			
			City city = queue.poll();
			int cur = city.next;
			
			if(check[cur] == true) continue;
			check[cur] = true;
			
			for(City c : weight[cur]) {
				if(distance[c.next] > distance[cur] + c.expense) {
					distance[c.next] = distance[cur] + c.expense;
					queue.offer(new City(c.next, distance[c.next]));
				}
			}
		}
	}
}