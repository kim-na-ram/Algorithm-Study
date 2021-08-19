package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class HideandSeek1_1697 {
    
    public static int N, K;
    public static int[] map = new int[100001];
    public static boolean[] visited;
    
    public static void bfs(int N) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(N);
        map[N] = 1;
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(map[temp]);
                    return;
                }

                if (next >= 0 && next < map.length && map[next] == 0) {
                    queue.add(next);
                    map[next] = map[temp] + 1;
                }
            }
        }
        
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		N = Integer.parseInt(line.split(" ")[0]);
		K = Integer.parseInt(line.split(" ")[1]);
		
		if(N == K)
			System.out.println(0);
		else
			bfs(N);
		
	}
}