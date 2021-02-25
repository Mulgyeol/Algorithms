package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_ConnectProcessor_ref	{
	
	static int N, max, totalCnt,min,map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<int[]> List;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			List = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==0 || j==0 || i == N-1 || j ==N-1) continue; // 가장자리는 무시
					if(map[i][j]==1) {
						List.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			go(0,0);
			System.out.println("#"+tc+" "+min);
			
		}
	}
	
	private static void go(int index, int cCnt) { // index : 부분집합에 고려할 코어 인덱스, cCnt : 연결된 코어 개수
		
		if(index == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이 구하기
			
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}else if(max == cCnt) {
				if(res<min) min = res;
			}
			
			return;
		}
		
		// 코어를 선택 전선 놓아보기(4방향으로 놓아보기)
		int[] cur = List.get(index);
		int r = cur[0];
		int c = cur[1];
		for(int d=0; d<4; d++) {
			if(isAvailable(r,c,d)) {
				// 전선놓기
				setStatus(r,c,d,2);
				// 다음 코어로 넘어가기
				go(index+1, cCnt+1);
				// 놓았던 전선 되돌려 놓기
				setStatus(r,c,d,0);
			}
			
		}
		
		// 코어 비선택
		go(index+1, cCnt);
	}
	
	private static void setStatus(int r, int c, int d, int s) {
		int nr=r, nc=c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc <0 || nc>= N) break;
			map[nr][nc] = s;
		}
	}
	
	private static boolean isAvailable(int r, int c, int d) {
		int nr=r, nc=c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc <0 || nc>= N) break;
			if(map[nr][nc] >= 1) return false; // 코어나 전선이 놓아져있어서 불가능.
		}
		return true;
	}
	
	private static int getLength() {
		int lCnt = 0;  // 전선 길이의 합
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==2) lCnt++;
			}
		}
		return lCnt;
	}

}
