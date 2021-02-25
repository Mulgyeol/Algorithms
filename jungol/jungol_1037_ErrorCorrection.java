package com.algo.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1037_ErrorCorrection {
	
	static boolean[][] arr;
	static int[] row; // 행 별 계산값
	static int[] col; // 열 별 계산값
	static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new boolean[N][N];
		row = new int[N];
		col = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					arr[i][j] = true;
					count++;
				}
			}
			row[i] = count;
		}
		
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j][i] == true) {
					count++;
				}
			}
			col[i] = count;
		}
		
		int rowCount = 0;
		int colCount = 0;
		int rowIdx = -1;
		int colIdx = -1;
		String answer;
		
		for(int i=0; i<N; i++) {
			if(row[i]%2 != 0) {
				rowCount++;
				rowIdx = i;
			}
			if(col[i]%2 != 0) {
				colCount++;
				colIdx = i;
			}
		}
		
		
		if(rowCount == 1 && colCount ==1) answer = "Change bit ("+Integer.toString(rowIdx+1)+","+Integer.toString(colIdx+1)+")";
		else if(rowCount == 0 && colCount ==0) answer =  "OK";
		else answer = "Corrupt";
		
		System.out.println(answer);
		
		
	}

}
