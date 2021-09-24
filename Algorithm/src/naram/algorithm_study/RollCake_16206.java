package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RollCake_16206 {
	
	static int N;
	static int M;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		int idx1 = 0;
		int idx2 = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens())
			arr1[idx1++] = Integer.parseInt(st.nextToken());
			
		Arrays.sort(arr1);
		
		for(int i = 0; i < N; i++) {
			if(arr1[i] == 10) answer++;
			else if(arr1[i] > 10) {
				if(arr1[i] % 10 == 0)
					cutting(arr1[i]);
				else arr2[idx2++] = arr1[i];
			}
		}
		
		if(M > 0) 
			for(int i = 0; i < idx2; i++) cutting(arr2[i]);
		
		System.out.println(answer);
		
	}
	
	private static void cutting(int i) {
		
		if(M <= 0) return;
		
		M -= 1;
		int rest = i - 10;
		answer++;
		
		if(rest > 10) {
			cutting(rest);
		} else {
			if(rest == 10) answer++;
			else return;
		}
		
	}

}
