package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class acmicpc_17143_FishingKing {
	
	static int R, C, M;
	static int answer;
	static class Shark{
		int r;
		int c;
		int s; //속력
		int d; //이동방향
		int z; //크기
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static Shark[][] map;
	static ArrayList<Shark> sharks = new ArrayList<Shark>();
	static Queue<Shark> killSharks = new LinkedList<Shark>();
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1}; // 상하우좌
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r,c,s,d,z);
			sharks.add(map[r][c]);
		}
		
		for(int i=1; i<=C; i++) {
			fish(i); //낚시
			move(); //상어이동
			mapReset(); //맵 초기화
		}
		
		System.out.println(answer);
	}
	
	/*
	 * map을 그냥 처음부터 다시 그린다.
	 * 상어리스트에서 정보를 받아서 map에 뿌려주는데,
	 * 겹치는 구간이 있으면 죽일 상어를 골라 queue에 넣고,
	 * map에는 큰 상어만 넣어준다.
	 * queue에서 꺼낸 상어를 리스트에서 없앤다.
	 */
	private static void mapReset() {
		map = new Shark[R+1][C+1];
		for(Shark s : sharks) {
			if(map[s.r][s.c] == null) {
				map[s.r][s.c] = s;
			}else {
				if(map[s.r][s.c].z > s.z) {
					killSharks.offer(s);
				}else {
					killSharks.offer(map[s.r][s.c]);
					map[s.r][s.c] = s;
				}
			}
		}
		
		while(!killSharks.isEmpty()) {
			sharks.remove(killSharks.poll());
		}
		
	}
	
	/* 상어의 이동, 바로 map에 넣지 않고 객체의 위치정보만 변경해 놓는다.
	 * 방향은 적절하게 바꿔준다.
	 */
	private static void move() {
		for(Shark s : sharks) {
			for(int i=0; i<s.s; i++) {
				if(s.d == 1 && s.r == 1) {
					s.d = 2;
				}
				if(s.d == 2 && s.r == R) {
					s.d = 1;
				}
				if(s.d == 3 && s.c == C) {
					s.d = 4;
				}
				if(s.d == 4 && s.c == 1) {
					s.d = 3;
				}
				
				s.r += dx[s.d];
				s.c += dy[s.d];
				
			}
		}
	}
	
	/* 낚시꾼의 위치에서 낚시를 하는 메서드
	 * map[r][c]를 null로 바꿔줘도 리스트의 상어는 없어지지 않는다.
	 * map[r][c]가 null을 가리키게 됐을 뿐이지, 객체가 없어지진 않았다.
	 */
	private static void fish(int c) {
		for(int r=1; r<=R; r++) {
			if(map[r][c] != null) {
				answer += map[r][c].z;
				sharks.remove(map[r][c]);
				map[r][c] = null;
				break;
			}
		}
	}

}
