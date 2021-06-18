package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Node {
    
    int num;
    Node left;
    Node right;
    
}

class Deque {
    
    Node front;
    Node rear;
    int count;
    
    public Deque() {
        
        front = null;
        rear = null;
        count = 0;
        
    }
    
    public int empty() {
        
        if(front == null) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
    public void pushFront(int item) {
        
        Node node = new Node();
        node.num = item;
        count++;
        
        if(empty() == 1) {
            front = node;
            rear = node;
            node.left = null;
            node.right = null;
        }
        else {
            front.left = node;
            node.right = front;
            node.left = null;
            front = node;
        }
        
    }
    
    public void pushBack(int item) {
        
        Node node = new Node();
        node.num = item;
        count++;
        
        if(empty() == 1) {
            front = node;
            rear = node;
            node.left = null;
            node.right = null;
        }
        else {
            rear.right = node;
            node.left = rear;
            node.right = null;
            rear = node;
        }
    }
    
    public int popFront() {
        if(empty() == 1) {
            return -1;
        }
        else {
            int item = front.num;
            count--;
            if(front.right == null) {
                front = null;
                rear = null;
            }
            else {
                front = front.right;
                front.left = null;
            }
            return item;
        }
        
    }
    
    public int popBack() {
        if(empty() == 1) {
            return -1;
        }
        else {
            int item = rear.num;
            count--;
            if(rear.left == null) {
                front = null;
                rear = null;
            }
            else {
                rear = rear.left;
                rear.right = null;
            }
            return item;
        }
        
    }
    
    public int size() {
        return count;
    }
    
    public int front() {
        if(empty() == 1) {
            return -1;
        }
        return front.num;
    }
    
    public int back() {
        if(empty() == 1) {
            return -1;
        }
        return rear.num;
    }
    
}

public class Deque_10866 {
	
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque deque = new Deque();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++)
		{
		    
		    String command = br.readLine();
		    if(command.contains("push_front"))
		    {
		        deque.pushFront(Integer.parseInt(command.split(" ")[1]));
		    }
		    else if(command.contains("push_back")) 
		    {
		        deque.pushBack(Integer.parseInt(command.split(" ")[1]));
		    }
		    else if(command.contains("pop_front"))
		    {
		        sb.append(deque.popFront()).append("\n");
		    }
		    else if(command.contains("pop_back"))
		    {
		        sb.append(deque.popBack()).append("\n");
		    }
		    else if(command.equals("size"))
		    {
		        sb.append(deque.size()).append("\n");
		    }
		    else if(command.equals("empty"))
		    {
		        sb.append(deque.empty()).append("\n");
		    }
		    else if(command.equals("front"))
		    {
		        sb.append(deque.front()).append("\n");
		    }
		    else if(command.equals("back")) {
		        sb.append(deque.back()).append("\n");
		    }
		    
		}
		
		System.out.println(sb);
	}
}