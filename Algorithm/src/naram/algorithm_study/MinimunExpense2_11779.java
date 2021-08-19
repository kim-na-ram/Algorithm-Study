package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimunExpense2_11779 {
	
	public static class Bus implements Comparable<Bus> {
		
		int station;
		long expense;
		
		public Bus(int station, long expense) {
			this.station = station;
			this.expense = expense;
		}
		
		@Override
		public int compareTo(Bus b) {
			return Long.compare(this.expense, b.expense);
		}
		
	}
	
	public static int n, m, s, e;
	public static ArrayList<Bus>[] expense;
	public static ArrayList<Integer> routes = new ArrayList<>();
	public static long[] distance;
	public static int[] route;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		expense = new ArrayList[n + 1];
		distance = new long[n + 1];
		route = new int[n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			expense[i] = new ArrayList<Bus>();
		}
		
		Arrays.fill(distance, Long.MAX_VALUE);
		
		StringTokenizer st;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int BusExpense = Integer.parseInt(st.nextToken());
			
			expense[S].add(new Bus(E, BusExpense));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		Dijkstra(s);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(distance[e]).append("\n");
		
		sb.append(routes.size()).append("\n");
		
		for(int i = routes.size() - 1; i >= 0; i--) {
			sb.append(routes.get(i) + " ");
		}
		
		System.out.println(sb);
		
	}
	
	public static void Dijkstra(int s) {
		PriorityQueue<Bus> queue = new PriorityQueue<Bus>();
        boolean[] check = new boolean[n + 1];
		
		queue.offer(new Bus(s, 0));
		distance[s] = 0;
		route[s] = 0;
		
		while(!queue.isEmpty()) {
			Bus b = queue.poll();
			int cur = b.station;
            
            if(check[cur]) continue;
            check[cur] = true;
			
			for(Bus bus : expense[cur]) {
				if(distance[bus.station] > distance[cur] + bus.expense) {
					distance[bus.station] = distance[cur] + bus.expense;
					route[bus.station] = cur;
					queue.offer(new Bus(bus.station, distance[bus.station])) ;
				}
			}
		}
		
		int prev = e;
		while(prev != 0) {
			routes.add(prev);
			prev = route[prev];
		}
	}
}