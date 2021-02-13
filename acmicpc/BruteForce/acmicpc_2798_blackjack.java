package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_2798_blackjack {
	
	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = blackjack(0,0,0);
		
		System.out.println(answer);
	}

	private static int blackjack(int i, int count, int sum) {
		if(count == 3 && sum <= M) {
			return sum;
		}
		if (sum > M || i>= N) {
			return 0;
		}
		
		return Math.max(blackjack(i+1, count, sum), blackjack(i+1, count+1, sum+arr[i]));
	}

}
