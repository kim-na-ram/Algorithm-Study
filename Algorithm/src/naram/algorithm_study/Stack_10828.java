package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Stack {

    public int ptr;
    public int max;
    public int[] stk;
    
    public Stack() {
        
        ptr = 0;
        max = 10001;
        stk = new int[max];
        
    }
    
    public void push(int x) {
        
        stk[ptr++] = x;
        
    }
    
    public int pop() {
        
        if(ptr <= 0)
            return -1;
	   
	    return stk[--ptr];
        
    }
    
    public int size() {
        
        return ptr;
        
    }
    
    public int empty() {
        
        if(ptr > 0) return 0;
        else return 1;
        
    }
    
    public int top() {
        
        if(ptr <= 0) return -1;
        else return stk[ptr-1];
        
    }
        

}

public class Stack_10828 {
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    Stack stk = new Stack();
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < n; i++) {
	        
	        String full_command = br.readLine();
	        String command = full_command.split(" ")[0];
	        
	        
	        switch(command) {
	            case "push":
	                int x = Integer.parseInt(full_command.split(" ")[1]);
	                stk.push(x);
	                break;
	            case "pop":
	                sb.append(stk.pop()).append("\n");
	                break;
	            case "size":
	                sb.append(stk.size()).append("\n");
	                break;
	            case "empty":
	                sb.append(stk.empty()).append("\n");
	                break;
	            case "top":
	                sb.append(stk.top()).append("\n");
                    break;
	            default:
	                break;
	        }
	        
	    }
	    
	    System.out.println(sb);
	    
	}
}