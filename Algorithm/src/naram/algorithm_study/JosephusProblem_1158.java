package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class JosephusProblem_1158 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    // Queue que = new Queue(N, K);
	    Queue<Integer> queue = new LinkedList<>();
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < N; i++) {
	        
	        queue.add(i + 1);
	        
	    }
	    
	    int i = 0;
	    
	    sb.append("<");
	    
	    while(!queue.isEmpty()) {
	        
	        if((i + 1) % K == 0) {
	            
	            int x = queue.poll();
	            if(queue.isEmpty())
	                sb.append(x);
	            else
	                sb.append(x).append(", ");
	        
	            
	        } else {
	            
	            int x = queue.poll();
	            queue.add(x);
	            
	        }
	        
	        i++;
	        
	    }
	    
	    sb.append(">");
	    
	    System.out.println(sb);
	    
	}
}
