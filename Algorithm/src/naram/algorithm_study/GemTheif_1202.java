package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Gem {
	
	int Mi;
	int Vi;
	
	public Gem(int Mi, int Vi) {
		this.Mi = Mi;
		this.Vi = Vi;
	}
}

public class GemTheif_1202 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 보석의 개수
		int K = Integer.parseInt(st.nextToken()); // 가방의 개수
		
		Gem[] gems = new Gem[N];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int Mi = Integer.parseInt(st.nextToken()); // 보석의 무게
			int Vi = Integer.parseInt(st.nextToken()); // 보석의 가격
			
			gems[i] = new Gem(Mi, Vi);
			
		}
		
		Arrays.sort(gems, new Comparator<Gem>() {
			@Override
			public int compare(Gem g1, Gem g2) {
				
				if(g1.Mi == g2.Mi)
					return g2.Vi - g1.Vi;
				return g1.Mi - g2.Mi;
				
			}
		});
		
		int[] bags = new int[K];
		
		for(int i = 0; i < K; i++) {
			
			bags[i] = Integer.parseInt(br.readLine());
			
		}
		
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		long ans = 0;
		
		for(int i = 0, j = 0; i < K; i++) {
			while(j < N && gems[j].Mi <= bags[i]) {
				pq.offer(gems[j++].Vi);
			}
			
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
			
		}
		
		System.out.println(ans);
		
	}

}
