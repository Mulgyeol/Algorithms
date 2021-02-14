package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_1018_chessboard {
	
	private static char[][] white = new char[8][8];
	private static char[][] black = new char[8][8];
	private static char[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean flag = true;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(flag) {
					white[i][j] = 'W';
					black[i][j] = 'B';
				}else {
					white[i][j] = 'B';
					black[i][j] = 'W';
				}
				flag = !flag;
			}
			flag = !flag;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int min = Integer.MAX_VALUE;
		int tempMin = Integer.MAX_VALUE;
		
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				int countW = 0; // white랑 비교
				int countB = 0; // black이랑 비교
				for(int x=i; x<i+8; x++) {
					for( int y=j; y<j+8; y++) {
						if (arr[x][y] != white[x-i][y-j]) countW++;
						if (arr[x][y] != black[x-i][y-j]) countB++;
					}
				}
				tempMin = Math.min(countW, countB);
				min = Math.min(min, tempMin);
			}
		}
		
		System.out.println(min);
		
	}

}
