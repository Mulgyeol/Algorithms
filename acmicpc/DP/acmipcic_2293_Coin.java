package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmipcic_2293_Coin {
	
	static int[] coins;
	static int[] dp;
	static int n, count = 0, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		coins = new int[n]; //코인 값 저장
		dp = new int[k+1]; //k+1개의 dp 배열
		
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1; // dp[0]은 가짓수를 하나씩 올리는데 사용한다.
		
		for(int i=0; i<n; i++) { //코인 갯수만큼 돈다.
			for(int j=coins[i]; j<=k; j++) { // 시작은 코인값 인덱스부터
				dp[j] = dp[j]+dp[j-coins[i]];
			}
		}
		
		System.out.println(dp[k]);
		
	}
	

	
}




