package naram.algorithm_study;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReverseWord_12605 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine()); // 케이스 개수
	    int index = 1; // 케이스 번호
	    
	    Stack<String> bracket = new Stack<String>();

	    for(int i = 0; i < N; i++) {
	        
	        String s = br.readLine();
	        String r = "";
	        
	        for(int j = 0; j < s.split(" ").length; j++) bracket.push(s.split(" ")[j]);
	        
	        while(!bracket.empty())
	            r += bracket.pop() + " ";
	            
	        sb.append("Case #" + index + ": " + r).append("\n");
	        index++;
	    }
	    
	    System.out.println(sb);
	    
	}
	
}
