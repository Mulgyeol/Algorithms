package com.algo.SWEA;

import java.util.Scanner;

/*
 *  LIS : 원소가 n개인 배열의 일부 원소를 골라내서 부분 수열을 만들었을 때,
 *  각 원소는 이전 원소보다 더 크다는 조건을 만족하는, 길이가 최대인 부분 수열
 */

public class SWEA_3307_LIS {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N = sc.nextInt();
			int[] arr = new int[N]; // 원소들 저장
			int[] LIS = new int[N]; // 각 원소를 마지막에 세웠을때의 최장길이
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0;
			for(int i=0; i<N; i++) {
				LIS[i] = 1; // 자기 혼자 세웠을때의 길이로 초기화
				for(int j=0; j<i; j++) { // 맨 앞부터 자신의 직전의 원소들과 비교
					if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if(max < LIS[i]) max = LIS[i];
			}
			
			sb.append(max).append("\n");
		}
		sc.close();
		System.out.println(sb);
	}

}
