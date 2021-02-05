package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] moveRow = {1,0,-1,0}; //하좌상우 행
		int[] moveColumn = {0,-1,0,1}; //하상좌우 열
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 1;
			int moveIndex = 0;
			int y=0, x=0;
			int[][] map = new int[n][n];
			
			map[y][x] = cnt++; // [0][0]
			
			for(int i = n-1; i>0; i--) {
				map[y][++x] = cnt++; // 0번째 행은 미리 다 채워둠
			}
			
			for(int i = n-1; i>0; i--) {
				for(int j=0; j<2; j++) {
					for(int k=0; k<i; k++) {
						x += moveColumn[moveIndex];
						y += moveRow[moveIndex];
						map[y][x] = cnt++;
					}
					moveIndex = (moveIndex+1) % 4;
				}
			}
			
//			첫번째 행을 다 채우면, (하->좌->상->우 반복) + (n-1부터 1까지 2번씩 반복)
//			
//			하로 n-1번
//			좌으로 n-1번
//			상으로 n-2번
//			우로 n-2번
//			하로 n-3번
//			좌로 n-3번
//			.
//			.
			
			sb.append("#").append(t).append("\n");
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
		

	}

}
