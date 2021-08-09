package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Election_1417 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> voting = new PriorityQueue<>(Collections.reverseOrder());
		
		int dasom = 0;
		
		int answer = 0;
		
		for(int i = 1; i <= N; i++) {
			
			int vote = Integer.parseInt(br.readLine());

			if(i == 1) dasom = vote;
			else voting.offer(vote);
			
		}
		
		while(!voting.isEmpty()) {
			
			if(dasom <= voting.peek()) {
				int other_vote = voting.poll();
			
				other_vote -= 1;
				dasom += 1;
				answer += 1;
			
				voting.offer(other_vote);
			}
			else break;
			
		}
		
		System.out.println(answer);
		
	}

}