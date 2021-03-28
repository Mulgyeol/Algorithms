package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 기본 풀이 : BFS
 * 상어 객체 생성
 * 먹을 수 있는 물고기 리스트(comparator를 이용해서 먹을 물고기 맨 앞으로 빼기)
 */

public class acmicpc_16236_BabyShark {
	
	static class Shark{
		int x;
		int y;
		int level;
		int eatCnt;
		int time;
		
		Shark() {
			super();
		}

		Shark(int x, int y, int level, int eatCnt, int time) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
			this.eatCnt = eatCnt;
			this.time = time;
		}
		
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int N;
	static Shark babyShark;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		//맵 정보를 입력 받고, 상어 위치에서 객체 생성
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babyShark = new Shark(i,j,2,0,0);
				}
			}
		}
		
		bfs();
		
	}

	private static void bfs() {
		
		//bfs 돌릴 큐
		Queue<int[]> queue = new LinkedList<>();
		//먹을 물고기들이 있으면 담을 리스트
		ArrayList<int[]> eatableFish = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		
		//시간 측정을 위한 변수
		int time = -1;
		
		queue.offer(new int[] {babyShark.x, babyShark.y});
		visited[babyShark.x][babyShark.y] = true;
		
		while(!queue.isEmpty()) {
			
			// 크기만큼씩 끊어서 반복(시간 측정을 위해서)
			int size = queue.size();
			time++;			
			
			for(int s = 0; s<size; s++) {
				int[] tempPos = queue.poll();
				int x = tempPos[0];
				int y = tempPos[1];
				
				//뽑힌 위치에서 먹을 물고기가 있다면! 리스트에 넣는다.
				if(map[x][y] != 0 && map[x][y] < babyShark.level) {
					eatableFish.add(new int[] {x,y});
				}
				
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx >= 0 && nx <N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= babyShark.level) {
						queue.offer(new int[] {nx,ny});
						visited[nx][ny] = true;
					}
				}
			}//size
			
			// 리스트가 비어있지 않다면,
			// 우선순위 큐로 했다면 더 좋았을 듯하다.
			if(!eatableFish.isEmpty()) {
				//우선적으로 먹어야하는 물고기를 맨 앞으로 뺀다.
				Collections.sort(eatableFish, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						int order = 0;
						if(o1[0] == o2[0]) order = o1[1] - o2[1];
						else order = o1[0] - o2[0];
						
						return order;
					}
				});
				
				// 물고기를 먹으면서 처리해야할 작업들
				int[] fishPos = eatableFish.get(0);
				map[fishPos[0]][fishPos[1]] = 9;
				map[babyShark.x][babyShark.y] = 0;
				babyShark.x = fishPos[0];
				babyShark.y = fishPos[1];
				babyShark.eatCnt++;
				if(babyShark.level == babyShark.eatCnt) {
					babyShark.level++;
					babyShark.eatCnt = 0;
				}
				babyShark.time += time;
				
				//초기화 작업
				time = -1;
				eatableFish.clear();
				queue.clear();
				visited = new boolean[N][N];
				
				//다시 상어 위치를 큐에 넣고 돌린다.
				queue.offer(new int[] {babyShark.x, babyShark.y});
				visited[babyShark.x][babyShark.y] = true;
			}
			
		}
		
		// 끝나면 상어가 이동한 시간을 출력.
		System.out.println(babyShark.time);
		
	}
	

}
