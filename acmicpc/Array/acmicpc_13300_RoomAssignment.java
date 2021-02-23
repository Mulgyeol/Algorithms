package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_13300_RoomAssignment {
	private static int N, K, answer = 0;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[6][2]; //학년, 성별로 12개 배열
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int SchoolYear = Integer.parseInt(st.nextToken());
			
			arr[SchoolYear-1][gender]++;
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				if(arr[i][j] == 0) continue;
				if(arr[i][j] % K != 0) answer++;
				
				answer += arr[i][j] / K;
			}
		}
		
		System.out.println(answer);
	}

}
