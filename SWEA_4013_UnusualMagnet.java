package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1.	4개의 자석이 각각 8개의 날을 가지고 있다.
 * 2.	자석의 날마다 N극 또는 S극의 자성을 가지고있다.
 * 3.	하나의 자석이 1 칸 회전될 때, 
  		붙어 있는 자석은 서로 붙어 있는 날의 자성과 다를 경우에만 
  		인력에 의해 반대 방향으로 1 칸 회전된다.
  
 * 4.	- 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
		- 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
		- 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
		- 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
		
* 5.	4개의 자석의 자성 정보와 자석을 1칸씩 K번 회전시키려고 할 때,
 		K번 자석을 회전시킨 후 획득하는 점수의 총 합을 출력하는 프로그램을 작성하라.
 
* 6.	자석을 회전시키는 방향은 시계방향이 1 로, 반시계 방향이 -1 로 주어진다.
* 
* 7.	각 자석의 날 자성정보는 빨간색 화살표 위치의 날부터 시계방향 순서대로 주어진다.	
* 
* 8.	N=0, S=1
* 
* 9. 	문제를 잘못 이해했다.
* 		돌리기 전 시점에서 다르면 반대방향으로 돌아버리고,
* 		돌리기 전 시점에서 같으면 움직이지 않는다.
 */

public class SWEA_4013_UnusualMagnet {
	
	static int[][] magnets;
	static int[] flag;
	static int[] score = {1,2,4,8};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			magnets = new int[4][8];
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int magnetNum = Integer.parseInt(st.nextToken());
				int rotateDir = Integer.parseInt(st.nextToken());
				flag = new int[4];
				flag[magnetNum-1] = rotateDir; //돌릴 자석 넘버는 dir로, 안돌리면 0
				
				
				for(int i = magnetNum-1; i>0; i--) { //왼쪽으로 가면서 돌릴 자석 확인
					if(magnets[i][6] != magnets[i-1][2]) {
						flag[i-1] = -flag[i];
					}else {
						break;
					}
				}
				
				for(int i = magnetNum-1; i<3; i++) { // 오른쪽으로 가면서 돌릴 자석 확인
					if(magnets[i][2] != magnets[i+1][6]) {
						flag[i+1] = -flag[i];
					}else {
						break;
					}
				}
				
				for(int i=0; i<4; i++) { //돌릴 자석만 돌림
					if(flag[i] != 0) {
						rotateMagnet(i,flag[i]);
					}
				}
			}
			
			int answer =0 ;
			for(int i=0; i<4; i++) {
				answer += magnets[i][0] * score[i];
			}
			
			sb.append(answer).append("\n");
			
		}//tc
		
		System.out.print(sb);

	}//main

	private static void rotateMagnet(int magnetNum, int rotateDir) {
		int[] magnetTemp = new int[8];
		
		if(rotateDir == -1) { //반시계
			for(int i=0; i<7; i++) {
				magnetTemp[i] = magnets[magnetNum][i+1];
			}
			magnetTemp[7] = magnets[magnetNum][0];
			magnets[magnetNum] = Arrays.copyOfRange(magnetTemp, 0, 8);
			
		}else {//시계
			for(int i=1; i<8; i++) {
				magnetTemp[i] = magnets[magnetNum][i-1];
			}
			magnetTemp[0] = magnets[magnetNum][7];
			magnets[magnetNum] = Arrays.copyOfRange(magnetTemp, 0, 8);
		}
	}
	
	

}
