package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RecoveryNetwork_2211 {
	
	public static class Computer implements Comparable<Computer> {
		int number;
		int response_time; 
		
		public Computer(int number, int response_time) {
			this.number = number;
			this.response_time = response_time;
		}
		
		@Override
		public int compareTo(Computer c) {
			return this.response_time - c.response_time;
		}
	}
	
	public static int ans = 0;
	public static ArrayList<Computer>[] list;
	public static int[] distance;
	public static int[] response;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		response = new int[N + 1];
		check = new boolean[N + 1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(response, 0);
		
		for(int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Computer>();
		
		while(M --> 0) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Computer(B, C));
			list[B].add(new Computer(A, C));
			
		}
		
		dijkstra(1);
		
		for(int i = 0; i < N + 1; i++) {
			if(response[i] > 0) {
				ans += 1;
				sb.append(i + " " + response[i]).append("\n");
			}
		}
		
		System.out.println(ans + "\n" + sb);
		
	}
	
	public static void dijkstra(int S) {
		
		PriorityQueue<Computer> queue = new PriorityQueue<>();
		
		queue.offer(new Computer(S, 0));
		distance[S] = 0;
		
		while(!queue.isEmpty()) {
			
			Computer c = queue.poll();
			
			for(Computer item : list[c.number]) {
				if(!check[item.number] && distance[item.number] > distance[c.number] + item.response_time) {
					response[item.number] = c.number;
					distance[item.number] = distance[c.number] + item.response_time;
					queue.offer(new Computer(item.number, distance[item.number]));
				}
			}
			
			
		}
		
	}

}
