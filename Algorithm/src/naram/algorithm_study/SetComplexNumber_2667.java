package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class Dot {
    
    int x;
    int y;
    
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}

public class SetComplexNumber_2667 {
    
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<Integer> answer;
    
    public static Queue<Dot> queue;
    
    public static int[] rowArr = {-1, 0, 1, 0};
    public static int[] colArr = {0, -1, 0, 1};
    
    public static void bfs(int i, int j) {
        
        queue.offer(new Dot(i, j));
        
        int count = 1;
        
        while(!queue.isEmpty()) {
            
            Dot dot = queue.poll();
            visited[dot.x][dot.y] = true;
            
            for(int k = 0; k < 4; k++) {
                
                int row = dot.x + rowArr[k];
                int col = dot.y + colArr[k];
                
                if(checkDot(row, col)) {
                    count += 1;
                    map[row][col] = count;
                    queue.add(new Dot(row, col));
                }
                
            }
            
        }
        
        answer.add(count);
        
    }
    
    public static boolean checkDot(int row, int col) {
        
        if(row >= N || col >= N || row < 0 || col < 0)
            return false;
        if(map[row][col] != 1 || visited[row][col] == true)
            return false;
            
        return true;
        
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		answer = new ArrayList<Integer>();
		queue = new LinkedList<Dot>();
		
		for(int i = 0; i < N; i++) {
		    String line = br.readLine();
		    for(int j = 0; j < N; j++)
		        map[i][j] = line.charAt(j) - '0';
		}
		
		for(int i = 0; i < N; i++)
		    for(int j = 0; j < N; j++)
		        if(map[i][j] == 1 && visited[i][j] == false)
        		    bfs(i, j);
		            
		
		Collections.sort(answer);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(answer.size()).append("\n");
		
		for(int i = 0; i < answer.size(); i++)
		    sb.append(answer.get(i)).append("\n");
		
		System.out.println(sb);
	}
}