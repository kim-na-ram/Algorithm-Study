import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;
import java.util.Arrays;

public class HideandSeek3_13549 {
	
	public static class Point implements Comparable<Point> {
	    int pos;
	    int count;
	    
	    public Point(int pos, int count) {
	        this.pos = pos;
	        this.count = count;
	    }
	    
	    @Override
	    public int compareTo(Point p) {
	        return this.count - p.count;
	    }
	}
	
	public static int N, K;
	public static int[] map;
	public static boolean[] check;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
	
		N = Integer.parseInt(arr[0]);
		K = Integer.parseInt(arr[1]);
		
		map = new int[100001];
		check = new boolean[100001];
		
		Arrays.fill(map, Integer.MAX_VALUE);
		
		bfs();
		
	}
	
	public static void bfs() {
		
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		
		queue.offer(new Point(N, 0));
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            check[p.pos] = true;
            
            if (p.pos == K) {
                System.out.println(p.count);
                return;
            }

            if(p.pos * 2 <= 100000 && !check[p.pos * 2]) {
                queue.add(new Point(p.pos * 2, p.count));
            }
            if(p.pos + 1 <= 100000 && !check[p.pos + 1]) {
                queue.add(new Point(p.pos + 1, p.count + 1));
            }
            if(p.pos - 1 >= 0 && !check[p.pos - 1]) {
                queue.offer(new Point(p.pos - 1, p.count + 1));
            }
            
        }
	}
	
}
