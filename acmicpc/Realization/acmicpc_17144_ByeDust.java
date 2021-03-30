package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_17144_ByeDust {
	
	static class Dust{
		int x;
		int y;
		int size;
		
		public Dust(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	
	static int R,C,T,mBottom,mTop;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Dust[][] room;
	static Queue<Dust> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new Dust[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				int size = Integer.parseInt(st.nextToken());
				if(size > 0) {
					room[i][j] = new Dust(i,j,size);
					queue.offer(room[i][j]);
				}
				if(size == -1) {
					mBottom = i;
				}
			}
		}
		
		mTop = mBottom-1;
		
		for(int t=1; t<=T; t++) {
			spreadOut();
			rotate();
		}
		
		int answer = 0;
		while(!queue.isEmpty()) {
			answer += queue.poll().size;
		}
		
		System.out.println(answer);
	}

	private static void rotate() {
		int x = mTop-1;
		int y = 0;
		if(room[x][y] != null) {
			queue.remove(room[x][y]);
		}
		
		while(x!=0) {
			if(room[x-1][y] != null) {
				room[x][y] = room[x-1][y];
				room[x][y].x++;
				room[x-1][y] = null;
			}
			x--;
		}
		while(y!=C-1) {
			if(room[x][y+1] != null) {
				room[x][y] = room[x][y+1];
				room[x][y].y--;
				room[x][y+1] = null;
			}
			y++;
		}
		while(x!=mTop) {
			if(room[x+1][y] != null) {
				room[x][y] = room[x+1][y];
				room[x][y].x--;
				room[x+1][y] = null;
			}
			x++;
		}
		while(y!=0) {
			if(room[x][y-1] != null) {
				room[x][y] = room[x][y-1];
				room[x][y].y++;
				room[x][y-1] = null;
			}
			y--;
		}
		
		x = mBottom+1;
		y = 0;
		if(room[x][y] != null) {
			queue.remove(room[x][y]);
		}
		while(x!=R-1) {
			if(room[x+1][y] != null) {
				room[x][y] = room[x+1][y];
				room[x][y].x--;
				room[x+1][y] = null;
			}
			x++;
		}
		while(y!=C-1) {
			if(room[x][y+1] != null) {
				room[x][y] = room[x][y+1];
				room[x][y].y--;
				room[x][y+1] = null;
			}
			y++;
		}
		while(x!=mBottom) {
			if(room[x-1][y] != null) {
				room[x][y] = room[x-1][y];
				room[x][y].x++;
				room[x-1][y] = null;
			}
			x--;
		}
		while(y!=0) {
			if(room[x][y-1] != null) {
				room[x][y] = room[x][y-1];
				room[x][y].y++;
				room[x][y-1] = null;
			}
			y--;
		}
	}

	private static void spreadOut() {
		Dust[][] newRoom = new Dust[R][C];
		int qSize = queue.size();
		
		for(int i=0; i<qSize; i++) {
			Dust tempDust = queue.poll();
			int x = tempDust.x;
			int y = tempDust.y;
			int size = tempDust.size;
			
			for(int j=0; j<4; j++) {
				int nx = x+dx[j];
				int ny = y+dy[j];
				if(nx>=0 && nx <R && ny>=0 && ny<C && !(ny == 0 && (nx == mTop || nx == mBottom))) {
					if(newRoom[nx][ny] == null) {
						newRoom[nx][ny] = new Dust(nx,ny,size/5);
						queue.offer(newRoom[nx][ny]);
						tempDust.size -= size/5;
					}else {
						newRoom[nx][ny].size += size/5;
						tempDust.size -= size/5;
					}
				}
			}
			if(newRoom[x][y] == null) {
				newRoom[x][y] = tempDust;
				queue.offer(newRoom[x][y]);
			}else {
				newRoom[x][y].size += tempDust.size;
			}
		}
		
		room = newRoom;
	}

}
