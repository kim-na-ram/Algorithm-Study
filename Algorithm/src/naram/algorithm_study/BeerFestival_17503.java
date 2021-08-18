package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BeerFestival_17503 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int minLiverLv = -1;
		int sum = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NMK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NMK[0]); // N일 동안 N병
		int M = Integer.parseInt(NMK[1]);
		int K = Integer.parseInt(NMK[2]);
		
		int[][] beer = new int[K][2];
		
		for(int i = 0; i < K; i++) {
			String[] ViCi = br.readLine().split(" ");
			beer[i][0] = Integer.parseInt(ViCi[0]);
			beer[i][1] = Integer.parseInt(ViCi[1]);
		}
		
		Arrays.sort(beer, Comparator.comparingInt(item -> item[1]));
		// 도수레벨이 낮은 순부터 정렬
		
		for(int i = 0; i < K; i++) {
			pq.offer(beer[i][0]);
			sum += beer[i][0];
			
			if(pq.size() > N) {
				int minPreference = pq.peek() == null? 0 : pq.poll();
				// 선호도가 가장 작은 값 (= pq에서 우선순위가 가장 높은 값) 을 우선순위 큐에서 제거한 후 총 합에서 차감
				sum -= minPreference;
			}
			
			if(pq.size() == N && sum >= M) {
				minLiverLv = beer[i][1];
				break;
			}
			
		}
		
		System.out.println(minLiverLv);
		
	}

}
