package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_1149_RGBStreet {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = data[0][0];
		dp[0][1] = data[0][1];
		dp[0][2] = data[0][2];
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				int min = Integer.MAX_VALUE;
				for(int k=0; k<3; k++) {
					if(j!=k && dp[i-1][k]+data[i][j] < min) {
						min = dp[i-1][k]+data[i][j];
					}
				}
				dp[i][j] = min;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(dp[N-1][i] < min) min = dp[N-1][i];
		}
		
		System.out.println(min);
	}
}
