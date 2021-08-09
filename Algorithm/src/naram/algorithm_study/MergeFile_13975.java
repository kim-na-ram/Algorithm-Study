package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.PriorityQueue;

public class MergeFile_13975 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0) {
			
			int K = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> page = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for(int i = 0; i < K; i++) {
				page.offer(Long.parseLong(st.nextToken()));
			}
			
			long answer = 0;
			
			while(!page.isEmpty()) {
				
				long F1 = page.poll();
				long F2 = 0;
				
				if(!page.isEmpty()) {
					F2 = page.poll();
					
					Long X = F1 + F2;
					answer += X;
					page.offer(X);
				}
				
			}
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
