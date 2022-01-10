package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Collections;
import java.util.PriorityQueue;

public class MiddleValue_1655 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		while(n --> 0) {
			maxHeap.add(Integer.parseInt(br.readLine()));
			
			if((minHeap.size() + maxHeap.size()) % 2 == 0) {
				if(minHeap.peek() > maxHeap.peek()) {
                    maxHeap.add(minHeap.poll());
					minHeap.add(maxHeap.poll());
				}
			} else {
				minHeap.add(maxHeap.poll());
			}
			
			sb.append(minHeap.peek()).append("\n");
			
//			if(minHeap.size() == maxHeap.size()) {
//				maxHeap.add(value);
//			} else {
//				minHeap.add(value);
//			}
//			
//			if(!minHeap.isEmpty()) {
//				if(minHeap.peek() > maxHeap.peek()) {
//					int min = minHeap.poll();
//					int max = maxHeap.poll();
//					
//					minHeap.add(max);
//					maxHeap.add(min);
//				}
//			}
//			
//			if((minHeap.size() + maxHeap.size()) % 2 == 0) {
//				sb.append(minHeap.peek()).append("\n");
//			} else {
//				sb.append(maxHeap.peek()).append("\n");
//			}
//			
		}
		
		System.out.println(sb);

	}

}
