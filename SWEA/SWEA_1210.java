package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(br.readLine());
			
			int[][] map = new int[100][100]; // 사다리 배열
			
			for(int j=0; j<100; j++) {// 사다리 입력
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int y=0, x=0;
			
			for(int k=0; k<100; k++) { //시작 위치를 찾아 초기화
				if(map[99][k]==2) {
					y = 99; // 행
					x = k; // 열
				}
			}
		
			
			while(y != 0) {
				if((x-1)>=0 && map[y][x-1] == 1) {
					map[y][x] = 0;
					x--;
					continue;
				}
				
				if((x+1)<100 && map[y][x+1] == 1) {
					map[y][x] = 0;
					x++;
					continue;
				}
				
				y--;
			}

			sb.append(" ").append(x).append("\n");
			
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
