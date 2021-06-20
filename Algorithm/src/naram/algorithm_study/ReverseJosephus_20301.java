package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;

public class ReverseJosephus_20301 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Integer> dequeue = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			
			dequeue.offerLast(i+1);
			
		}
		
		int count = 1;
		int reverse_count = 0;
		
		while(!dequeue.isEmpty()) {
			
			if(reverse_count < m) {
			
				if(count % k != 0) {
					dequeue.offerLast(dequeue.pollFirst());
					count++;
				}
				else {
					sb.append(dequeue.pollFirst()).append("\n");
					count++;
					reverse_count++;
				}
				
			} else if (reverse_count >= m) {
				
				if(count % k != 0) {
					dequeue.offerFirst(dequeue.pollLast());
					count++;
				}
				else {
					sb.append(dequeue.pollLast()).append("\n");
					count++;
					reverse_count++;
					
					if(reverse_count % m == 0) {
						reverse_count = 0;
					}
					
				}
			}
			
		}
		
		System.out.println(sb);
		
	}

}
