package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_1194_MoonFullGo {

	static int N, M;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int answer = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new  char[N][M];
		int x=0, y=0;
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0') {
					x = i;
					y = j;
					map[i][j] = '.';
				}
			}
		}
		
		boolean[][][] visited = new boolean[N][M][64];
		bfs(x,y,visited);

		System.out.print(answer);

	}
	private static void bfs(int x, int y, boolean[][][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		queue.offer(new int[] {x,y,0});
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt ++;
			for(int s =0; s<size; s++) {
				int[] current = queue.poll();
				int curX = current[0];
				int curY = current[1];
				int curK = current[2];
				
				for(int i=0; i<4; i++) {
					int nx = curX+dx[i];
					int ny = curY+dy[i];
					
					if(nx >=0 && nx <N && ny >= 0 && ny <M && map[nx][ny] != '#' && !visited[nx][ny][curK]) {
						if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
							//A=0, B=1, C=2 ... F=5;
							int doorInfo = map[nx][ny] - 'A';
							if ((curK & 1<<doorInfo) != 0) {
								queue.offer(new int[] {nx,ny,curK});
								visited[nx][ny][curK] = true;
							}
							
						}else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f'){
							//a=0, b=1, c=3 ... f=5;
							int keyInfo = map[nx][ny] - 'a';
							int newCurK = curK | 1<<keyInfo;
							queue.offer(new int[] {nx,ny,newCurK});
							visited[nx][ny][newCurK] = true;
							
						}else if(map[nx][ny] == '.') {
							queue.offer(new int[] {nx,ny,curK});
							visited[nx][ny][curK] = true;
							
						}else if(map[nx][ny] == '.') {
							queue.offer(new int[] {nx,ny,curK});
							visited[nx][ny][curK] = true;
							
						}else if(map[nx][ny] == '1') {
							answer = cnt;
							return;
						}
					}// 범위 제한 설정

				}// 4방 탐색
			}//사이즈만큼

		}//while	
	}

}
