package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class NGE_17298 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 수열 A의 크기
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Stack<Integer> origin = new Stack<>();
		Stack<Integer> nge = new Stack<>();
		Stack<Integer> result = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			
			origin.push(Integer.parseInt(st.nextToken()));
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!origin.isEmpty()) {
			
			if(nge.isEmpty()) {
				result.push(-1);
				nge.push(origin.pop());
			}
			else {
				if(nge.peek() > origin.peek()) {
					result.push(nge.peek());
					nge.push(origin.pop());
				} else {
					nge.pop();
				}
			}
		}
		
		while(!result.isEmpty()) {
			sb.append(result.pop()).append(" ");
		}
		
		System.out.println(sb);
		
		
	}

}
