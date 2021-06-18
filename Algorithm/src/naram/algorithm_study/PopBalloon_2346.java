package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class PopBalloon_2346
{
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		short N = Short.parseShort(br.readLine());
		
		Deque<int[]> deque = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(short i = 0; i < N; i++)
		{
		    deque.offerLast(new int[] {Integer.parseInt(st.nextToken()), i + 1});
		}
		
		int[] dq = new int[2];
		// dq[0] = Ç³¼±¿¡ ÀûÈù ¼ýÀÚ, dq[1] = Ç³¼±ÀÇ ¹øÈ£
		
		int number = deque.peekFirst()[0];
		sb.append(deque.peekFirst()[1] + " ");
		deque.pollFirst();
		
		for(int i = 0; i < N; i++)
		{
			if(deque.isEmpty()) break;
		    
    		if(number > 0)
    		{
    			while(number > 1) {
        			deque.offerLast(deque.pollFirst());
        			number--;
    			}
    			number = deque.peekFirst()[0];
    			sb.append(deque.peekFirst()[1] + " ");
    			deque.pollFirst();
    		}
    		else
    		{
    			while(number < -1) {
    				deque.offerFirst(deque.pollLast());
    				number++;
    			}
    			number = deque.peekLast()[0];
    			sb.append(deque.peekLast()[1] + " ");
    			deque.pollLast();
    		}
		    
		}
		
		System.out.println(sb);
		
	}
}