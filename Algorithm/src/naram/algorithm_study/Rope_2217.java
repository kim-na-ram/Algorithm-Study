package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Rope_2217 {
	
	static int[] rope;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		rope = new int[N];
		
		for(int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			max = Math.max((rope[i] * (N - i)), max);
		}
		
		System.out.println(max);
		
	}

}
