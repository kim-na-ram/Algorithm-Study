package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;

public class PrinterQueue_1966 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(T --> 0) {
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        int N = Integer.parseInt(st.nextToken());
	        
	        int M = Integer.parseInt(st.nextToken());
	        
	        Queue<int[]> que = new LinkedList<int[]>();
	        int[][] arr = new int[N][2];
	        int[][] answer = new int[N][2];
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        for(int i = 0; i < N; i++) {
	            
	            arr[i][0] = i;
	            arr[i][1] = Integer.parseInt(st.nextToken());
	            que.offer(arr[i]);
	            
	        }
	        
	        Arrays.sort(arr, new Comparator<int[]> () {
	    	    @Override
	    	    public int compare(int[] a1, int[] a2) {
	    		    return a2[1] - a1[1];
	    	    }
	        });
	        
	        int index = 0;
	        int count = 1;
	        
	        while(!que.isEmpty()) {

	            if(que.peek()[1] == arr[index][1]) {
	                
	                arr[index] = que.poll();
	                if(arr[index][0] == M)
	                    sb.append(count).append("\n");
	                count++;
	                index++;
	                
	            } else {
	                
	                que.offer(que.poll());
	                
	            }
	            
	        }
	        
	    }
	    
	    System.out.println(sb);
	    
	}
}