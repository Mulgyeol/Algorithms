package com.off.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUN17143_FishingKing {
	static int ROW, COL, M;
	static int[][] map = new int[101][101];
	
	static int sumOfSize = 0;//이게 구하는 답
	static Map<Integer, Shark> sharks = new HashMap<>();//key:상어크기
	
	static class Shark {
		int x, y, dir, speed, size;

		public Shark(int x, int y, int dir, int speed, int size) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.speed = speed;
			this.size = size;//no
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ROW = Integer.parseInt(st.nextToken());//행
		COL = Integer.parseInt(st.nextToken());//열
		M = Integer.parseInt(st.nextToken());//상어 수
		
		for (int i = 0; i < M; i++) {//상어수만큼
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			Shark s = new Shark(x, y, dir, speed, size);
			sharks.put(size, s);//size는 모든 상어가 다른값을 가지고 있어서 키로 활용 가능
			map[x][y] = size;//상어의 크기
		}//입력끝
		
		for (int i = 1; i <= COL; i++) {//가로로 움직임
			fishing(i);//1.낚시왕이 낚시를 함
			moveShark();//2.상어가 이동			
		}
		
		System.out.println(sumOfSize);		
	}

	private static void fishing(int col) {
		//1행부터~ROW(끝까지) 아래로 내려가면서 체크
		for (int i = 1; i <= ROW; i++) {
			if(map[i][col] != 0) {//상어발견
				sumOfSize += map[i][col];//상어 사이즈를 누적
				sharks.remove(map[i][col]);//잡은 상어는 사라짐
				map[i][col] = 0;//그자리에는 더 이상 상어 없어
				return;
			}
		}		
	}
	
	//상어가 자신의 속도만큼 이동. 이동 후 위치가 겹치면 잡아먹기
	private static void moveShark() {
		//d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미
		int[] dx = {0,-1,1,0,0};
		int[] dy = {0,0,0, 1,-1};
		
		int[][] tmp = new int[ROW + 1][COL + 1];
		Queue<Integer> looser = new LinkedList<>();
		
		//모든 상어들에 대해 이동
		for (int key : sharks.keySet()) {
			Shark s = sharks.get(key);
			map[s.x][s.y] = 0;//이동할 꺼니까 원래 자리는 초기화
			
			//상어가 가진 속도로 이동
			//이동 전 방향 전환해야하나? 체크
			for (int i = 0; i < s.speed; i++) {
				if(s.dir == 1 && s.x == 1) {//위->아래
					s.dir = 2;
					
				}else if(s.dir == 2 && s.x == ROW){//아래->위
					s.dir = 1;
					
				}else if(s.dir == 3 && s.x == COL){//오른->왼
					s.dir = 4;
					
				}else if(s.dir == 4 && s.x == 1){//왼->오른
					s.dir = 3;
				}
				
				//그리고 이동
				s.x += dx[s.dir];
				s.y += dy[s.dir];
				
			}//상어는 자기 속도만큼 모든 이동을 끝냈음. s.x, s.y에는 새로운 위치 값이 들어 있음
			
						
			//새롭게 움직인 위치에 다른 상어가 있는지
			if(tmp[s.x][s.y] == 0) {
				tmp[s.x][s.y] = s.size;
				
			}else if(s.size > tmp[s.x][s.y] ) {// 지금애가 더 커
				looser.add(tmp[s.x][s.y]);//진 애를 추가 
				tmp[s.x][s.y] = s.size;//이긴애가 그자리에
				
			}else {
				looser.add(s.size);
			}
		}//모든 상어들이 위치 이동하고 싸운 후. tmp배열에 싸움에서 이긴 상어들 위치가 저장되어 있음
		
		//상어들 상태 정리하자! sharks, map ->두군데 모두에 반영해줘야 함.
		//1.sharks에서 진 상어들 삭제
		while(!looser.isEmpty()) {
			sharks.remove(looser.poll());//현재까지 살아남은 상어들 정보가 map에 저장되어 있음
		}
		
		//2.map에는 이긴 상어들 표시
		for (int key :sharks.keySet()) {
			Shark s = sharks.get(key);
			map[s.x][s.y] = tmp[s.x][s.y];
		}
	}
}


