package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.PriorityQueue;

public class WhoIsZelda_4485 {
	
	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int weight;
		
		public Point(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.weight - p.weight;
		}
	}
	
	public static int[][] map;
	public static int[][] distance;
	
	public static int[] rowArr = {-1, 0, 1, 0};
	public static int[] colArr = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int problemNum = 1;
		
		while(true) {
			
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			map = new int[N][N];
			distance = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Dijkstra(N);
			
			sb.append("Problem " + problemNum + ": " + distance[N-1][N-1]).append("\n");
			
			problemNum++;
			
		}
		
		System.out.println(sb);
		
	}
	
	public static void Dijkstra(int N) {
		
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		
		queue.offer(new Point(0, 0, map[0][0]));
		distance[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int nowX = p.x;
			int nowY = p.y;
			
			for(int i = 0; i < 4; i++) {
				int row = nowX + rowArr[i];
				int col = nowY + colArr[i];
				
				if(row < N && col < N && row >= 0 && col >= 0) {
					if(distance[row][col] > distance[nowX][nowY] + map[row][col]) {
						distance[row][col] = distance[nowX][nowY] + map[row][col];
						queue.offer(new Point(row, col, map[row][col]));
					}
				}
			}
		}
	}
}
