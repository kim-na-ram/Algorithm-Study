package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HalfHalf_11856 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0) {
			
			String line = br.readLine();
			int[] alpha = new int[26];
			
			for(int i = 0; i < line.length(); i++) {
				
				int index = line.charAt(i) - 'A';
				alpha[index]++;
				
			}
			
			sb.append("#" + T + " ");
			
			boolean flag = false;
			for(int i = 0; i < alpha.length; i++) {
				if(alpha[i] != 2 && alpha[i] > 0) {
					flag = true;
				}
			}
			
			if(!flag) sb.append("Yes").append("\n");
			else sb.append("No").append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
