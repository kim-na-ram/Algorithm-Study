package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SafetyArea_2468 {
	
    public static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int N;
    public static int[][] map;
    public static int[][] transMap;
    public static boolean[][] visited;
    
    public static int max = 1;
    public static int count = 0;
    
    public static void dfs(int i, int j) {
        
        visited[i][j] = true;
        
        if(check(i-1, j))
            dfs(i-1, j);
        
        if(check(i+1, j))
            dfs(i+1, j);
            
        if(check(i, j-1))
            dfs(i, j-1);
        
        if(check(i, j+1))
            dfs(i, j+1);
            
    }
    
    public static boolean check(int row, int col) {
        
        if(row < 0 || col < 0 || row >= N || col >= N)
            return false;
        if(visited[row][col] || transMap[row][col] == 0)
            return false;
        return true;
        
    }
    
    public static void changeMap(int k) {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] <= k)
    				transMap[i][j] = 0;
    			else
    				transMap[i][j] = 1;
    		}
    	}
    }
    
    public static void checkSafetyArea () {
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++) {
    			if(!visited[i][j] && transMap[i][j] == 1) {
    				count++;
    				dfs(i, j);
    			}
    				
    		}
    }
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    
	    map = new int[N][N];
	    transMap = new int[N][N];
	    
	    for(int i = 0; i < N; i++) {
	        String[] line = br.readLine().split(" ");
	        for(int j = 0; j < N; j++) {
	            map[i][j] = Integer.parseInt(line[j]);
	        }
	    }

	    for(int k = 0; k < 101; k++) {
	    	count = 0;

		    visited = new boolean[N][N];
		    
	    	changeMap(k);
	    	
	    	checkSafetyArea();
	    	
	    	max = Math.max(max, count);
	    }
        
        System.out.println(max);

	}
}