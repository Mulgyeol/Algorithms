package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_16198_EnergyBead {
	
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		findMaxEnergy(arr, N, 0);
		
		System.out.println(max);
		
		
	}
	
	private static void findMaxEnergy(int[] arr, int N, int sum) {
		// TODO Auto-generated method stub
		if(N == 2) { // 종료조건, 나머지가 2이면
			max = Math.max(sum, max);
		}
		
		for(int i=1; i<N-1; i++) {
			int nowSum = sum; // 넘겨받은 지금까지의 합을 변수에 담는다.
			int[] arrTemp = new int[N-1]; // N-1 크기의 배열을 만든다.
			int arrTempIdx = 0; //새로 만들어진 배열의 인덱스를 저장할 변수
			int arrIdx = 0; //본 배열의 인덱스를 저장할 변수
			while(arrTempIdx < N-1) {
				if(arrIdx == i) { // 선택된 인덱스면
					nowSum += arr[arrIdx-1]*arr[arrIdx+1]; // nowSum 변수에 에너지를 더하고,
					arrIdx++; // 건너뛴다.
				}
				arrTemp[arrTempIdx++] = arr[arrIdx++]; // 복사
			}
			findMaxEnergy(arrTemp,N-1,nowSum); //재귀
		}
	}

}
