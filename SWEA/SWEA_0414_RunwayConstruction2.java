package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_0414_RunwayConstruction2 {

	static int[][] map;
	static int N,X,answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지형의 길이
			X = Integer.parseInt(st.nextToken()); // 활주로 밑변
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append(process()).append("\n");
		}
		System.out.println(sb);
	}

	private static int process() {
		
		int count = 0;
		for(int i=0; i<N; i++) {
			if(makeRoadByRow(i)) ++count;
			if(makeRoadByCol(i)) ++count;
		}
		
		return count;
	}

	private static boolean makeRoadByRow(int i) {
		int beforeHeight = map[i][0];
		int size = 0 ; // 연속된 동일 갯수;
		int j = 0; // 탐색 열 위치
		
		while(j<N) {
			if(beforeHeight == map[i][j]) {
				size++; // 첫번째 열도 자기랑 비교해서 갯수를 늘린다.
				j++;
			}else if(beforeHeight+1 == map[i][j]) {//오르막
				if(size<X) return false; //경사로 설치 불가
				beforeHeight++;
				size = 1;
				j++;
			}else if(beforeHeight-1 == map[i][j]) {//내리마
				int count = 0;
				for(int k=j; k<N; k++) {
					if(map[i][k] != beforeHeight-1) break;
					if(++count == X) break;
				}
				
				if(count < X) return false;
				beforeHeight--;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}
	
	
	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[0][i];
		int size = 0 ; // 연속된 동일 갯수;
		int j = 0; // 탐색 열 위치
		
		while(j<N) {
			if(beforeHeight == map[j][i]) {
				size++; // 첫번째 열도 자기랑 비교해서 갯수를 늘린다.
				j++;
			}else if(beforeHeight+1 == map[j][i]) {//오르막
				if(size<X) return false; //경사로 설치 불가
				beforeHeight++;
				size = 1;
				j++;
			}else if(beforeHeight-1 == map[j][i]) {//내리마
				int count = 0;
				for(int k=j; k<N; k++) {
					if(map[k][i] != beforeHeight-1) break;
					if(++count == X) break;
				}
				
				if(count < X) return false;
				beforeHeight--;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}
}
