package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Stack {

    public int ptr;
    public int max;
    public int count;
    public String[] stk;
    
    public Stack() {
        
        ptr = 0;
        count = 0;
        max = 51;
        stk = new String[max];
        
    }
    
    public void push(String x) {
        
        count++;
        stk[ptr++] = x;
        
    }
    
    public String pop() {
        
        if(ptr <= 0) {
            
            count--;
            return null;
            
        }
        
        count--;
	    return stk[--ptr];
        
    }
    
    public int isVPS() {
        
        return count;
        
    }
        
}

public class Bracket_9012 {
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < n; i++) {
	        
	        Stack stk = new Stack();
	        String str = br.readLine();

	        for(int j = 0; j < str.length(); j++) {
	            
	            String tp = str.split("")[j];
	            
	            if(tp.equals("(")) {
	                if(stk.isVPS() < 0) break;
	                stk.push(tp);
	            } else if(tp.equals(")")) {
	                if(stk.isVPS() < 0) break;
	                stk.pop();
	            }
	        
	        }
	        
	        if(stk.isVPS() == 0)
	            sb.append("YES").append("\n");
	        else sb.append("NO").append("\n");
	        
	    }
	    
	    System.out.println(sb);
	    
	}
}
