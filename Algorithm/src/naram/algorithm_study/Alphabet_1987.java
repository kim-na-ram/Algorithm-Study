package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class Alphabet_1987 {
	
	public static int R, C;
	public static int[][] map;
	public static boolean[][] visited;
	public static char[][] board;
	public static boolean[] alpha;
	public static int max = 0;
	
	public static int[] rowArr = {0, -1, 0, 1};
	public static int[] colArr = {-1, 0, 1, 0};
	
	public static class Point {
		
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void print() {
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		
	}
	
	public static void bfs() {
		
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.offer(new Point(0, 0));
		map[0][0] = 1;
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
			visited[point.x][point.y] = true;
			int index = board[point.x][point.y] - 'A';
			alpha[index] = true;
			
			for(int i = 0; i < 4; i++) {
				int row = point.x + rowArr[i];
				int col = point.y + colArr[i];
				
				if(checkBoard(row, col)) {
					queue.offer(new Point(row, col));
					map[row][col] = map[point.x][point.y] + 1;
				}
			}
			
		}
		
		
	}
	
	public static boolean checkBoard(int row, int col) {
		
		if(row < 0 || col < 0 || row >= R || col >= C)
			return false;
		
		int index = board[row][col] - 'A';
		
		if(alpha[index])
			return false;
		
		return true;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] first = br.readLine().split(" ");
		
		R = Integer.parseInt(first[0]);
		C = Integer.parseInt(first[1]);
		
		board = new char[R][C];
		map = new int[R][C];
		visited = new boolean[R][C];
		alpha = new boolean[26];
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		bfs();
		
		print();
		
//		System.out.println(count);

	}

}
