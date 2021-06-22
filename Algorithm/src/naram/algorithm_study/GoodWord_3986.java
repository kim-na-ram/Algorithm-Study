package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class GoodWord_3986 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Stack<Character> stk;
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			
			stk = new Stack<Character>();
			String line = br.readLine();
			
			for(char c : line.toCharArray()) {
				
				if(stk.isEmpty() || c != stk.peek()) {
					stk.push(c);
				}
				else if(c == stk.peek()) {
					stk.pop();
				}
				
			}
			
			if(stk.isEmpty()) count++;
			
		}
		
		System.out.println(count);
		
	}
	
}
