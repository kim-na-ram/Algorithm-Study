package naram.algorithm_study;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Repairman {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 물이 새는 곳 개수
		int tape_l = Integer.parseInt(st.nextToken()); // 테이프 길이
		
		int[] fix_location = new int[n];
		String line = br.readLine();
		
		for(int i = 0; i < n; i++) {
		    
		    fix_location[i] = Integer.parseInt(line.split(" ")[i]);
		    
		}
		
		Arrays.sort(fix_location);
		int tape = 0;
		int L = tape_l;

		for(int i = 0; i < n; i++) {
			if(i == n - 1) {
				tape++;
				continue;
			}
			
			int hole = fix_location[i++];
			while(n > i) {
				if(fix_location[i] - hole <= L - 1) {
					i++;
				}
				else {
					break;
				}
			}
			tape++;
			i--;
		}
		
		System.out.println(tape);
	}
}