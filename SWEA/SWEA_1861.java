package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1861 {
	
	private static int[][] map;
	private static boolean[][] check;
	private static int[] dx = {-1,1,0,0}; //상하좌우
	private static int[] dy = {0,0,-1,1};
	private static LinkedList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t);
			
			int N =  Integer.parseInt(br.readLine()); // 방의 크기
			
			map = new int[N][N];
			list = new LinkedList<>();
			
			for(int i=0;i<N;i++) { // 2차원 배열에 값 넣기
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			check = new boolean[N][N]; // 체크한 방인지 표시할 배열
			int[] max = new int[2]; // 답을 넣을 int[2] 배열
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) { // 전체를 돌면서
					if(check[i][j] == false) { // 이미 체크한 방이 아니면
						goFromHere(i,j,N); // 이동할 수 있는지
						comeToHere(i,j,N); // 여기로 다른방에서 이동해 올 수 있는지
						if(max[1] < list.size()) { // 더 많은 방을 갈 수 있으면 교체
							max[0] = list.peek(); // 리스트에 있는 방 중에 제일 낮은 방
							max[1] = list.size();
						}else if(max[1] == list.size()) { // 같은 방만큼 이동이 가능하면 더 낮은 방으로
							max[0] = max[0]>list.peek() ? list.peek() : max[0];
						}
					}
					
					list.clear(); // 리스트 비우기
				}
			}
			sb.append(" ").append(max[0]).append(" ").append(max[1]).append("\n");

		}//for testcase
		
		System.out.println(sb);
	}

	private static void goFromHere(int i, int j, int N) { //다른 방으로 갈 수 있는지 확인하면서 리스트 뒤에 넣기
		check[i][j] = true;
		list.addLast(map[i][j]);
		for(int k=0; k<4; k++) {
			int row = i+dx[k];
			int column = j+dy[k];
			if(row >= 0 && row <N && column>=0 && column<N && map[row][column]-map[i][j] == 1) {
				goFromHere(row,column,N);
				break;
			}
		}
	}
	
	private static void comeToHere(int i, int j, int N) { // 다른 방에서 이 방으로 올 수 있는지 확인하면서 리스트 앞에 넣기
		check[i][j] = true;
		if(!list.contains(map[i][j])) {
			list.addFirst(map[i][j]);
		}
		for(int k=0; k<4; k++) {
			int row = i+dx[k];
			int column = j+dy[k];
			
			if(row >= 0 && row <N && column>=0 && column<N && map[i][j]-map[row][column] == 1) {
				comeToHere(row, column, N);
				break;
			}
		}
	}

}
