package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_HoneyExtraction {
	
	static int N,M,C,A,B;
	static int[][] hive;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			hive = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					hive[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(getMaxBenefit()).append("\n");
		}
		System.out.print(sb);
		
	}

	private static int getMaxBenefit() {
		return processCombination();
	}
	
	private static int processCombination() {
		int result = 0, aBenefit = 0, bBenefit =0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N-M; j++) { // 첫열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택
				// 선택된 M개 벌통에서 얻을 수 있는 최대 이익
				maxSum = 0;
				makeMaxSubset(i,j,0,0,0);
				aBenefit = maxSum;
				
				
				// 일꾼 B의 선택
				maxSum =0;
				bBenefit = 0; //b는 여러번 해줘야하므로 0으로 초기화를 시키고 시작한다.
				// 일꾼 A와 같은 행에 뒤쪽 열에서 선택
				for(int j2 = j+M; j2<= N-M; j2++) {
					makeMaxSubset(i,j2,0,0,0);
					if(bBenefit < maxSum) bBenefit = maxSum;
				}
				
				maxSum = 0;
				//일꾼 A의 다음행부터 선택
				for(int i2 = i+1; i2<N; i2++) {
					for(int j2 =0; j2<=N-M; j2++) {
						makeMaxSubset(i2,j2,0,0,0);
						if(bBenefit < maxSum) bBenefit = maxSum;
					}
				}
				
				if(result<aBenefit+bBenefit) result = aBenefit+bBenefit;
			}
		}
		
		return result;
	}

	private static int maxSum = 0;
	
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum){ // 부분집합의 최대합을 구하는 원리
		if(sum > C) return;
		
		// 마지막 원소까지 다 부분집합에 고려해봤다면
		if(cnt == M) {
			if(maxSum < powerSum) maxSum = powerSum;
			
			return;
		}
		
		//선택
		makeMaxSubset(i, j+1, cnt+1, sum+hive[i][j], powerSum+(hive[i][j]*hive[i][j]));
		//비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powerSum);
	}
	

}
