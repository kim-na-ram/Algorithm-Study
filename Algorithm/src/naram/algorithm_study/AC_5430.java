package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class AC_5430 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st;

		Deque<Integer> deque;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++)
		{
			
			String p = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), "[],");

			deque = new ArrayDeque<Integer>();
			
			for(int j = 0; j < n; j++) {
				
				deque.offer(Integer.parseInt(st.nextToken()));
				
			}
			
			AC(p, deque);
			
		}
		
		System.out.println(sb);
		
	}
	
	public static void AC(String p, Deque<Integer> deque) {
		
		boolean reverse = true;
		
		for(char cmd : p.toCharArray())
		{
			
			if(cmd == 'R')
			{
				reverse = !reverse;
				continue;
			}
			
			if(reverse)
			{
				if(deque.pollFirst() == null) {
					sb.append("error").append("\n");
					return ;
				}
			}
			else {
				if(deque.pollLast() == null) {
					sb.append("error").append("\n");
					return ;
				}
			}
			
		}
		
		makeString(deque, reverse);
		
	}
	
	public static void makeString(Deque<Integer> deque, boolean reverse) {
		
		sb.append("[");
		
		if(deque.size() > 0) {
			if(reverse) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollFirst());
				}
			}
			else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollLast());
				}
			}
		}
		
		sb.append("]").append("\n");
		
	}

}
