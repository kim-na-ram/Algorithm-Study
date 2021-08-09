package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.PriorityQueue;

public class Slime_14698 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long div = 1000000007;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> slime = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			while(N --> 0) {
				
				slime.offer(Long.parseLong(st.nextToken()));
				
			}
			
			long energy = 1;
			
			while(slime.size() != 1) {
				
				long AB = (slime.poll() * slime.poll());
				slime.offer(AB);
				energy = energy * (AB % div) % div;
				
			}
			
			sb.append(energy).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	

}
