package naram.algorithm_study;

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    public int solution(int n, int[][] edge) {
        
        boolean[][] tree = new boolean[n+1][n+1];
        int[] route = new int[n+1];
        
        for(int i = 0; i < edge.length; i++)
            tree[edge[i][1]][edge[i][0]] = tree[edge[i][0]][edge[i][1]] = true;
        
        int max = 0;
        
        Queue<Integer> queue = new LinkedList<Integer>();
    	
    	queue.offer(1);
    	
    	while(!queue.isEmpty()) {
    		
    		int i = queue.poll();
    		
    		for(int j = 2; j < n + 1; j++) {
    			if(route[j] == 0 && tree[i][j]) {
    				route[j] = route[i] + 1;
    				queue.offer(j);
    				max = Math.max(max, route[j]);
    			}
    			
    		}
    		
    	}
        
        int answer = 0;
        
        for(int r : route) {
        	if(max == r)
        		answer += 1;
        }
        
        return answer;
        
    }
}