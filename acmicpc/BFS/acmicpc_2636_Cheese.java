package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_2636_Cheese {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int x, y;
	static int[][] map;
	static boolean[][] air, visited;
	static int[] table;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map = new int[x][y];
		table = new int[100];
		
		
		for(int i=0; i<x; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 0;
		makeAir();
		findMeltingZone(idx);
		
		while(table[idx] != 0) {
			idx++;
			makeAir();
			findMeltingZone(idx);
		}

		System.out.println(idx);
		System.out.println(table[idx-1]);

	}


	private static void findMeltingZone(int idx) {
		int count =0;
		for(int i=1; i<x-1; i++) {
			for(int j=1; j<y-1; j++) {
				if(map[i][j] == 1) {
					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						if(map[nx][ny] == -1) {
							count++;
							map[i][j] = 0;
							break;
						}
					}
				}
			}
		}
		
		table[idx] = count;
	}


	private static void makeAir() {
		air = new boolean[x][y];
		visited = new boolean[x][y];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] tempAir = queue.poll();
			map[tempAir[0]][tempAir[1]] = -1;
			
			for(int i=0; i<4; i++) {
				int nx = tempAir[0]+dx[i];
				int ny = tempAir[1]+dy[i];
				if(nx < 0 || nx >= x || ny < 0 || ny >=y || visited[nx][ny]) continue;
				if(map[nx][ny] != 1) {
					queue.offer(new int[] {nx,ny});
					visited[nx][ny] = true; // 들어갈 때 방문 처리를 해줘야, 나오기 전까지 다른 애들이 또 방문하지 않는다.
				}
			}
		}

	}
}
