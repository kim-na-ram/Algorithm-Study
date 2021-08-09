package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class DestroyWall_2206 {
	
	public static class Place {
		int x;
		int y;
		int distance;
		int drill;
		
		public Place(int x, int y, int distance, int drill) {
			
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.drill = drill;
			
		}
	}
    
    public static int N, M, ans;
    public static int[][] maze, check;
    
    public static int[] rowArr = {-1, 1, 0, 0};
    public static int[] colArr = {0, 0, -1, 1};

    public static void bfs(int i, int j) {
        
        Queue<Place> queue = new LinkedList<>();
        
        queue.offer(new Place(i, j, 1, 0));
        check[i][j] = 0;
        
        while(!queue.isEmpty()) {
        	
        	Place p = queue.poll();
        	
        	if(p.x == N-1 && p.y == M-1) {
        		ans = p.distance;
        		return ;
        	}
        	
        	for(int k = 0; k < 4; k++) {
        		int row = p.x + rowArr[k];
        		int col = p.y + colArr[k];
 
        		if(row >= 0 && col >= 0 && row < N && col < M) {
        			if(check[row][col] > p.drill) {
        				if(maze[row][col] == 0) {
        					check[row][col] = p.drill;
        					queue.offer(new Place(row, col, p.distance+1, p.drill));
        				} else {
        					if(p.drill == 0) {
        						check[row][col] = p.drill + 1;
        						queue.offer(new Place(row, col, p.distance+1, p.drill+1));
        					}
        				}
        			}
        		}
        	}
        }
        
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		check = new int[N][M];

		for(int i = 0; i < N; i++) {
		    String line = br.readLine();
		    for(int j = 0; j < M; j++) {
		        maze[i][j] = line.charAt(j) - '0';
		        check[i][j] = Integer.MAX_VALUE;
		    }
		}
		
		ans = Integer.MAX_VALUE;
		
		bfs(0, 0);
		
		if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else 
            System.out.println(ans);
		
	}
}