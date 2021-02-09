package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	
	private static final int max = 2;
	private static int M, N;
	private static int[] snack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			snack = new int[N];
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int max = solution(0,0,0);
			if(max == 0) {
				max = -1;
			}
			
			sb.append(max).append("\n");
			
		}
		
		System.out.println(sb);
	}

	private static int solution(int idx, int cnt, int weight) {
		if(weight > M) {
			return 0;
		}
		if(idx == 1 && weight == M) {
			return 0;
		}
		if(cnt == max) {
			return weight;
		}
		if(cnt != max && idx == N) {
			return 0; 
		}
		
		// 과자를 고른경우
		int v1 = solution(idx+1, cnt+1, weight+snack[idx]);
		// 과자를 고르지 않은 경우
		int v2 = solution(idx+1, cnt, weight);
		
		return Math.max(v1, v2);
	}

}
