package naram.algorithm_study;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SortCoordinates_11650 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] coordinate_arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			coordinate_arr[i][0] = Integer.parseInt(st.nextToken()); // x
			coordinate_arr[i][1] = Integer.parseInt(st.nextToken()); // y
			
		}
		
		Arrays.sort(coordinate_arr, new Comparator<int[]>( ) {
			@Override
			public int compare(int[] a1, int[] a2) {
				if(a1[0] == a2[0]) {
					return a1[1] - a2[1];
				}
				return a1[0] - a2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			
			sb.append(coordinate_arr[i][0]).append(" ")
				.append(coordinate_arr[i][1]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}