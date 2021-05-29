package naram.algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Coin_11047 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 동전의 종류 n
		int k = Integer.parseInt(st.nextToken()); // 가치의 합 k
		int[] coin = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			// 오름차순으로 들어오는 동전을 내림차순으로 저장
			coin[i] = Integer.parseInt(br.readLine());

		}

		int coin_sum = 0; // 동전 갯수

		for (int i = 0; i < n; i++) {

			if (k < coin[i]) {
				continue;
			} else {
				coin_sum += k / coin[i];
				k = k % coin[i];
			}

		}

		System.out.println(coin_sum);

	}
}
