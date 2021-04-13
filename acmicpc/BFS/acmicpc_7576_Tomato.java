package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_7576_Tomato {
	
	static int M,N,tomCnt=0, answer = -1;
	static int[][] box;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> queue = new LinkedList<int[]>();
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		
		
		box = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 0) tomCnt++;
				if(box[i][j] == 1) {
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		System.out.println(answer);

	}

	private static void bfs() {
		int time = -1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx >=0 && nx < N && ny >=0 && ny <M && !visited[nx][ny] && box[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						tomCnt--;
						if(tomCnt == 0) break;
					}
				}
			}
			time++;
		}
		if(tomCnt == 0) answer = time;
	}

}
