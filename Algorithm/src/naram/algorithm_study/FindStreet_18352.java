package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindStreet_18352 {
	
	public static int N, M, K, X;
	public static ArrayList<Integer>[] list;
	public static int[] distance;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			
		}
		
		Dijkstra(X);
		
		StringBuilder sb = new StringBuilder();
		
		boolean check = false;
		
		for(int i = 1; i < N + 1; i++) {
			if(distance[i] == K) {
				sb.append(i).append("\n");
				check = true;
			}
		}
		
		if(!check)
			sb.append("-1");
		
		System.out.println(sb);
		
	}
	
	public static void Dijkstra(int X) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.offer(X);
		distance[X] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int c : list[cur]) {
				if(distance[c] > distance[cur] + 1) {
					distance[c] = distance[cur] + 1;
					queue.offer(c);
				}
			}
		}
	}

}
