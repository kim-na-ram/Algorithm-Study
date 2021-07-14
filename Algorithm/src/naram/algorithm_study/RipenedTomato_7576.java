package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

class Location {
    
    int x;
    int y;
    
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}

public class RipenedTomato_7576 {
    
    public static int N, M;
    public static int[][] tomato;
    
    public static int days = 0;
    
    public static void print() {
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			System.out.print(tomato[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    }
    
    public static void bfs() {
    	
    	Queue<Location> queue = new LinkedList<Location>();
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(tomato[i][j] == 1)
    				queue.offer(new Location(i, j));
    		}
    	}

        int[] rowArr = {-1, 0, 1, 0};
        int[] colArr = {0, -1, 0, 1};
    	
        while(!queue.isEmpty()) {
        	
        	Location location = queue.poll();
        	
        	for(int k = 0; k < 4; k++) {
        		int row = location.x + rowArr[k];
                int col = location.y + colArr[k];
                    
                if(checkLocation(row, col)) {
                	tomato[row][col] = tomato[location.x][location.y] + 1;
                	queue.offer(new Location(row, col));
                }
                
            }
        	
        	print();
        	
        }
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++) {
        		if(tomato[i][j] == 0) {
        			days = -1;
        			return ;
        		}
                days = Math.max(days, tomato[i][j]);
        	}
        
        days -= 1;
    }
    
    public static boolean checkLocation(int i, int j) {
        
        if(i < 0 || j < 0 || i >= N || j >= M)
            return false;
        if(tomato[i][j] == 0)
            return true;
            
        return false;
        
    }
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    M = Integer.parseInt(st.nextToken()); // 가로
	    N = Integer.parseInt(st.nextToken()); // 세로
	    
	    tomato = new int[N][M];
	    
	    for(int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0; j < M; j++)
	            tomato[i][j] = Integer.parseInt(st.nextToken());
	    }
	    
	    bfs();
	    
	    System.out.println(days);
	    
	}
	
}