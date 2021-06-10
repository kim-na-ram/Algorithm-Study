package naram.algorithm_study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Editor_1406 {
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String n = br.readLine(); // 초기 문자열
	    int m = Integer.parseInt(br.readLine()); // 명령어 개수
	    
	    Stack<String> left = new Stack<String>();
	    Stack<String> right = new Stack<String>();
	    
	    StringBuilder sb = new StringBuilder();
	    
        String[] ch = n.split("");
	    for(int i = 0; i < ch.length; i++) 
	        left.push(ch[i]);
	    
	    for(int i = 0; i < m; i++) {
	        
	        String command = br.readLine();
	        String c = command.split(" ")[0];
	        
	        if(c.equals("L") && !left.empty())
	            right.push(left.pop());
            if(c.equals("D") && !right.empty())
	            left.push(right.pop());
	        if(c.equals("B") && !left.empty())
	            left.pop();
	        if(c.equals("P"))
	            left.push(command.split(" ")[1]);
	        
	    }
	    
	    while(!left.empty())
	        right.push(left.pop());
	    
	    while(!right.empty())
	        sb.append(right.pop());
	    
	    System.out.println(sb);
	    
	}
}