package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_BrickBreaking2 {
	static class Point{
		int x;
		int y;
		int size;
		
		public Point(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
	}
	static int N,W,H,min;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			dropBeads(0, map);
			sb.append(min).append("\n");
			
		}
		System.out.print(sb);
	}
	
	// 중복순열로 구슬 떨어뜨리기
	// cnt : 구슬을 떨어뜨린 횟수
	private static void dropBeads(int cnt, int[][] map) {
		
		if(cnt == N) {
			int result = getRemain(map);
			min = Math.min(min, result);
			return;
		}
		
		int[][] newMap = new int[H][W];
		// 매열마다 구슬을 떨어뜨리는 시도
		for (int y = 0; y < W; y++) {
			// 해당 열에 구슬을 떨어뜨려 맞는 벽돌 찾기
			int x =0;
			while(x<H && map[x][y]==0) ++x;
			if(x==H) { 	// 맞는 벽돌 없음(모두 빈칸)
				dropBeads(cnt+1, map);
			}else { 	// 벽돌을 찾음.
				//기존 cnt-1 구슬까지의 상태로 초기화
				copy(map, newMap);
				//벽돌 깨뜨리기
				breakBricks(newMap,x,y);
				//깨져서 생긴 빈칸을 채운다(벽돌을 내린다.)
				downBricks(newMap);
				//다음 구슬을 떨어뜨리러 간다.
				dropBeads(cnt+1, newMap);
			}
		}
		
	}

	private static int getRemain(int[][] map) {
		int count =0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] > 0) count++;
			}
		}
		return count;
	}

	private static void downBricks(int[][] newMap) {
		for (int y = 0; y < W; y++) {
			Queue<Integer> bricks = new LinkedList<>();
			int x = H-1;
			while(x>=0) {
				if(newMap[x][y] > 0) {
					bricks.offer(newMap[x][y]);
					newMap[x][y] = 0;
				}
				x--;
			}
				
			x = H-1;
			while(!bricks.isEmpty()){
				newMap[x][y] = bricks.poll();
				x--;
			}
		}
	}

	private static void breakBricks(int[][] newMap, int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		if(newMap[r][c]>1) {
			queue.offer(new Point(r, c, newMap[r][c]));
		}
		newMap[r][c] = 0; //제거처리(방문처리)
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x;
				int ny = p.y;
				for(int k=1; k<p.size; k++) {
					nx += dx[d];
					ny += dy[d];
					if(nx>=0 && nx<H && ny>=0 && ny<W && newMap[nx][ny] != 0) {
						if(newMap[nx][ny] > 1) {
							queue.offer(new Point(nx, ny, newMap[nx][ny]));
						}
						newMap[nx][ny] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
