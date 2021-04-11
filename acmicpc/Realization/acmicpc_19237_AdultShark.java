package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class acmicpc_19237_AdultShark {
	
	static class Shark{
		int num;
		int dir;
		int[][] sDir; // 상어 개인의 우선순위
	    int x;
	    int y;
		
		public Shark(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}

		public Shark(int num, int x, int y) {
			this.num = num;
			this.sDir = new int[5][5];
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class Smell{
		Shark shark;
		Shark smellOwner;
		int time;
		int x;
		int y;
		
		public Smell(Shark shark, Shark smellOwner, int time, int x, int y) {
			super();
			this.shark = shark;
			this.smellOwner = shark;
			this.time = time;
			this.x = x;
			this.y = y;
		}
		

	}
	
	static int N,M,k;
	static Smell[][] map;
	static Shark[] sharks;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static ArrayList<Shark> aliveShark = new ArrayList<>();
	static ArrayList<Shark> killList = new ArrayList<>();
	static ArrayList<Smell> aliveSmell = new ArrayList<>();
	static ArrayList<Smell> delSmell = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int answer = -1;
		N = Integer.parseInt(st.nextToken()); // map의 크기
		M = Integer.parseInt(st.nextToken()); // 상어의 갯수
		k = Integer.parseInt(st.nextToken()); // 냄새가 사라지는데 걸리는 시간
		
		map = new Smell[N][N];
		sharks = new Shark[M+1];
		
		
		//map 데이터, 살아있는 상어 관리할 ArrayList, 상어 바로 접근할 배열 데이터 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) {
					map[i][j] = null;
				}else {
					sharks[num] = new Shark(num,i,j);
					aliveShark.add(sharks[num]);
					map[i][j] = new Smell(sharks[num], sharks[num], k, i, j);
					aliveSmell.add(map[i][j]);
				}
			}
		}
		
		// 각 상어의 방향 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=M; i++) {
			sharks[i].dir = Integer.parseInt(st.nextToken());
		}
		
		// 각 상어의 방향 우선순위 데이터 입력
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=4; j++) {
				st = new StringTokenizer(br.readLine(), " ");				
				for(int k=1; k<=4; k++) {
					sharks[i].sDir[j][k] = Integer.parseInt(st.nextToken());
				}
				
			}
		}
		
		for(int t=1; t<=1000; t++) {
			// 냄새 1초씩 까기
			DecreasedSmellTime();
			// 이동한다.
			move();
			// 냄새가 k만큼의 시간이 지난 것들은 없앤다.
			deleteSmell();
			// 냄새뿌린다. 
			smell();
			// 죽일 상어들 죽인다.
			kill();
			
			if(aliveShark.size() == 1) {
				answer = t;
				break;
			}
			
		}
		
		System.out.println(answer);
	}

	private static void deleteSmell() {
		for(Smell smell : delSmell) {
			map[smell.x][smell.y] = null;
			aliveSmell.remove(smell);
		}
		
		delSmell.clear();
	}

	private static void DecreasedSmellTime() {
		for(Smell smell : aliveSmell) {
			smell.time--;
			if(smell.time == 0) {
				delSmell.add(smell);
			}
		}
	}

	private static void kill() {
		for(Shark shark : killList) {
			aliveShark.remove(shark);	
		}
		killList.clear();
	}

	private static void smell() {
		for(Shark shark : aliveShark) {
			int x = shark.x;
			int y = shark.y;
			if(map[x][y] == null) {
				map[x][y] = new Smell(shark, shark, k, x, y);
				aliveSmell.add(map[x][y]);
			}else {
				if(map[x][y].shark != null) {
					if(map[x][y].shark.num >= shark.num){
						killList.add(map[x][y].shark);
						map[x][y].shark = shark;
						map[x][y].smellOwner = shark;
						map[x][y].time = k;
					}else {
						killList.add(shark);
					}
				}else {
					map[x][y].shark = shark;
					//map[x][y].smellOwner = shark; // 필요없는데 확실히 하기 위해
					map[x][y].time = k;
				}
			}
		}
	}

	private static void move() {
		for(Shark shark : aliveShark) {
			boolean flag = false;
			boolean findMySmell = false;
			int x = shark.x;
			int y = shark.y;
			int dir = shark.dir;
			int backX = -1;
			int backY = -1;
			int backDir = -1;
			
			for(int i=1; i<=4; i++) {
				int nx = x + dx[shark.sDir[dir][i]];
				int ny = y + dy[shark.sDir[dir][i]];
				
				//범위 체크
				if(nx >=0 && nx <N && ny >=0 && ny <N) {
					if(map[nx][ny] == null) { // 우선순위부터 차례로 비어있을 경우.
						shark.dir = shark.sDir[dir][i];
						shark.x = nx;
						shark.y = ny;
						map[x][y].shark = null;
						flag = true; // 빈 곳에 잘 들어갔다.
						break;
					}else {
						if(map[nx][ny].smellOwner.equals(shark) && !findMySmell) {
							backX = nx;
							backY = ny;
							backDir = shark.sDir[dir][i];
							findMySmell = true;
						}
					}
				}
			}
			
			if(!flag) {
				shark.dir = backDir;
				shark.x = backX;
				shark.y = backY;
				map[x][y].shark = null;
			}
		}
	}

}
