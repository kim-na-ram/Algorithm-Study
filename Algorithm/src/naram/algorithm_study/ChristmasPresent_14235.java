package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Collections;
import java.util.PriorityQueue;

public class ChristmasPresent_14235 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> worth = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		
		while(n --> 0) {
			
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			
			if(a == 0) {
				if(worth.isEmpty())
					sb.append(-1).append("\n");
				else sb.append(worth.poll()).append("\n");
			} else {
				for(int i = 1; i < a + 1; i++) {
					worth.offer(Integer.parseInt(line[i]));
				}
			}
			
		}
		
		System.out.println(sb);
		
	}

}
