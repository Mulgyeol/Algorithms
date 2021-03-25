package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 
 * 전깃줄을 끊는다고 생각하는게 아니라
 * 겹쳐지지않게 설치한다고 생각하기
 * 
 * 자르는 최소줄 갯수 = 전체 주어진 전선 줄 갯수 - 남아있는 전선 줄 갯수
 */

public class acmicpc_2565_ElectricFlex {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] LIS = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
			
		});
		
		for(int i=0; i<N; i++) {
			LIS[i] = 1;
			for(int j=0; j<i; j++) {
				if(isNotOverlap(arr[i],arr[j]) && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
			}
		}
		
		Arrays.sort(LIS);
		System.out.println(N-LIS[N-1]);
	}

	private static boolean isNotOverlap(int[] a, int[] b) {
		if(a[1] < b[1])
			return false;
		return true;
	}

}
