package naram.algorithm_study;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AssignMeetingroom_1931 {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    int[][] meetingroom = new int[n][2];
        
        StringTokenizer st;
	    
	    for(int i = 0; i < n; i++) {
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        meetingroom[i][0] = Integer.parseInt(st.nextToken());
	        meetingroom[i][1] = Integer.parseInt(st.nextToken());
	        
	    }
	    
	    Arrays.sort(meetingroom, new Comparator<> () {
	    	@Override
	    	public int compare(int[] a1, int[] a2) {
	    		if(a1[1] == a2[1]) { // 끝나는 시간이 같으면
	    			return a1[0] - a2[0]; // 시작이 빠른 순서로
	    		}
	    		return a1[1] - a2[1]; // 그 외에는 끝나는 시간이 빠른 순서대로 정렬
	    	}
	    });
	    
	    int count = 0;
	    int prev_end_time = 0;
	    
	    for (int i = 0; i < n; i++) {
	    	
	    	if(prev_end_time <= meetingroom[i][0]) {
	    		prev_end_time = meetingroom[i][1];
                count++;
	    	}
	    	
	    }
	    	
	    System.out.println(count);
	    
	}
}
