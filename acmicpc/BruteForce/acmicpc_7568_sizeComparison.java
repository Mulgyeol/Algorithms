package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_7568_sizeComparison {
	private static int N;
	private static int[][] arr;
	private static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		answer = new int[N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int count = 0;
			for(int j=0; j<N; j++) {
				if(i==j) count++;
				else {
					if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) count++;
				}
			}
			answer[i] = count;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}

}
