package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1953_ArrestFugitive {
	static int[][] isOK = {		 //각 파이프별 이동가능한 구간 체크해놓는 배열.
					{},			 //1부터 상,하,좌,우
					{0,2,1,4,3}, //0 ->  해당 위치로는 이동 불가능하다.
					{0,2,1,0,0}, //0이 아님 -> 해당 위치로 이동가능하다.
					{0,0,0,4,3}, //숫자 -> 상대편의 해당 인덱스를 확인해서 0이 아닌지 확인한다.
					{0,2,0,0,3}, //0이 아니면 이동이 가능하다.
					{0,0,1,0,3}, //예를 들어 위로 이동 가능(1번 인덱스가 '2')하면
					{0,0,1,4,0}, //위에 있는 파이프는 아래로 이동이 가능('2'번 인덱스가 0이 아님)해야한다.
					{0,2,0,4,0}
				   };
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static int[][] mapFlag; // 왔다는 것을 표시할 맵 flag
	static int[][] map;
	static int N, M, L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); //지도 행
			M = Integer.parseInt(st.nextToken()); //지도 열
			int R = Integer.parseInt(st.nextToken()); //맨홀뚜껑 행
			int C = Integer.parseInt(st.nextToken()); //맨홀뚜껑 열
			L = Integer.parseInt(st.nextToken()); //탈출 후 소요시간
			
			map = new int[N][M];
			mapFlag = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			findRoute(R,C,1);
			
			int answer = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(mapFlag[i][j] != 0) {
						answer++;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}//tc
		
		System.out.print(sb);
	}//main

	private static void findRoute(int R, int C, int time) {
		if(time > L) return;
		
		mapFlag[R][C] = time;
		
		int pipe = map[R][C];
		for(int i=1; i<=4; i++) { //상,하,좌,우를 의미
			if(isOK[pipe][i] == 0){ // 이동 가능한 구간이 아니면
				continue; // 넘어가고
			}else { // 이동가능 하면
				int nx = R + dx[i];
				int ny = C + dy[i];
				
				//범위를 초과하면 패스한다.
				if(nx < 0 || nx >= N || ny <0 || ny >= M) continue;
		
				int nextpipe = map[nx][ny]; // 다음 곳에 있는 파이프를 확인
				if(nextpipe == 0) continue; // 파이프가 없으면 넘어간다. 
				
				int nextpipeConnet = isOK[pipe][i]; // 파이프가 있으면 현재 파이프가 
				if(isOK[nextpipe][nextpipeConnet] != 0) { //지금 내가 있는 곳으로 연결이 되면
					if(mapFlag[nx][ny] == 0 || mapFlag[nx][ny] > time+1) {
						findRoute(nx, ny, time+1);
					}
				}
			}
		}
	}


}
