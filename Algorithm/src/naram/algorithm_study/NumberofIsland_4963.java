package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberofIsland_4963 {
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] rowArr = {-1, 0, 1, 0, -1, -1, 1, 1};
	public static int[] colArr = {0, -1, 0, 1, -1, 1, -1, 1};
	
	public static void dfs(int i, int j, int w, int h) {
		
        visited[i][j] = true;
        
		for(int k = 0; k < 8; k++) {
			
			int row = i + rowArr[k];
			int col = j + colArr[k];
				
			if(checkMap(row, col, w, h)) {
					dfs(row, col, w, h);
			}
			
		}
		
	}
	
	public static boolean checkMap(int row, int col, int w, int h) {
		
		if(row < 0 || col < 0 || row >= h || col >= w)
			return false;
		if(visited[row][col] == true || map[row][col] == 0)
			return false;
		
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String[] l = br.readLine().split(" ");
			
			int w = Integer.parseInt(l[0]);
			int h = Integer.parseInt(l[1]);
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			int count = 0;
			
			for(int i = 0; i < h; i++) {
				String line = br.readLine().replace(" ", "");
				for(int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						count += 1;
						dfs(i, j, w, h);
					}
				}
			}
			
			sb.append(count).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}