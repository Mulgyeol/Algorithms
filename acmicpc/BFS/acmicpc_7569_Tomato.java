package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_7569_Tomato {
	
	/*
	 * 1 : 익은 토마토
	 * 0 : 익지 않은 토마토
	 * -1 : 토마토가 없는 칸
	 */

	static int M,N,H,cnt=0,time=-1;
	static int[] dx = {-1,1,0,0,0,0}; //북,남,서,동,상,하
	static int[] dy = {0,0,-1,1,0,0}; 
	static int[] dh = {0,0,0,0,1,-1};
	static boolean[][][] visited;
	static int[][][] box;
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		H = Integer.parseInt(st.nextToken()); // 높이
		
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		//값 입력과 동시에 익은 토마토는 queue에 넣는다.
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					if(box[h][i][j] == 0) cnt++;
					if(box[h][i][j] == 1) {
						queue.offer(new int[] {h,i,j});
						visited[h][i][j] = true;
					}
				}
			}
		}
		
		//cnt는 익지 않은 토마토의 갯수.
		if(cnt == 0) {
			System.out.println(0);
		}else {
			bfs();
			if(cnt > 0) {
				System.out.println(-1);
			}else {
				System.out.println(time);
			}
		}
	}
	
	//3차원 배열 bfs
	private static void bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			time++;
			for(int s=0; s<size; s++) {
				int[] temp = queue.poll();
				int h = temp[0];
				int x = temp[1];
				int y = temp[2];
				
				for(int i=0; i<6; i++) {
					int nh = h + dh[i];
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(	nh >= 0 && nh <H &&
						nx >= 0 && nx <N &&
						ny >= 0 && ny <M && 
						!visited[nh][nx][ny] && box[nh][nx][ny] == 0) {
						queue.offer(new int[] {nh,nx,ny});
						visited[nh][nx][ny] = true;
						cnt--;
					}
				}
			}
		}
	}

}
