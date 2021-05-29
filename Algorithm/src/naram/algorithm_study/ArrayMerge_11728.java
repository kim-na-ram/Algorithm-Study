package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrayMerge_11728 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a_n = Integer.parseInt(st.nextToken());
		int b_n = Integer.parseInt(st.nextToken());
		
		int[] a = new int[a_n];
		int[] b = new int[b_n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i< a_n; i++) {
			
			a[i] = Integer.parseInt(st.nextToken());
			
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i< b_n; i++) {
			
			b[i] = Integer.parseInt(st.nextToken());
			
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < (a_n); i++) {
			list.add(a[i]);
		}
		
		for(int i = 0; i < b_n; i++) {
            list.add(b[i]);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
	}
}