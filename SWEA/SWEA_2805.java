package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=T; t++){
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(bf.readLine());
			int[][] farm = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String s = bf.readLine();
				for(int j=0; j<N; j++) {
					farm[i][j] = Character.getNumericValue(s.charAt(j)); // int로 값 저장
				}
			}
			
			int empty = 0; // 건너뛸 면적
			int take = 0; // 취할 면적
			int sum = 0; // 합계
			
			for(int i=0; i<N/2+1; i++) { // 위 절반  + 중간 포함
				empty = N/2-i;
				take = N-(2*empty);
				for(int j = empty; j<empty+take; j++) {
					sum += farm[i][j];
				}
			}
			
			for(int i=(N/2+1); i<N; i++) { // 밑 절반
				empty = i-(N/2);
				take = N-(2*empty);
				for(int j = empty; j<empty+take; j++) {
					sum += farm[i][j];
				}
				
			}
			
			
			sb.append(sum).append("\n");
			
			
		}
		
		System.out.println(sb);
	}

}
