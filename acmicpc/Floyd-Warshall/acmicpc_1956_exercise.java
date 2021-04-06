package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 플로이드 와샬 알고리즘 이용
 */

public class acmicpc_1956_exercise {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] arr = new int[V+1][V+1];
		int answer = 10001;
		
		for(int i=0; i<V+1; i++) {
			Arrays.fill(arr[i], 10001);
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[to][from] = weight;
		}
		
		for(int i=1; i<V+1; i++) { //경유지
			for(int j=1; j<V+1; j++) { //출발지
				for(int k=1; k<V+1; k++) {// 도착지
					if(arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		
		for(int i=1; i<V+1; i++) {
			if(arr[i][i] < answer) answer = arr[i][i];
		}
		
		if(answer == 10001) answer = -1;
		System.out.println(answer);
	}

}
