package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;


public class Card2_2164 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    Queue<Integer> queue = new LinkedList<>();
	    
	    for(int i = 0; i < N; i++) {
	        
	        queue.add(i + 1);
	        
	    }
	    
	    int last = 0;
	    
	    while(!queue.isEmpty()) {
	        
	        last = queue.poll();
	        
	        if(!queue.isEmpty()) {
	            int then = queue.poll();
	            queue.add(then);
	        } else {
	            break;
	        }
	        
	    }
	    
	    System.out.println(last);
	    
	}
}