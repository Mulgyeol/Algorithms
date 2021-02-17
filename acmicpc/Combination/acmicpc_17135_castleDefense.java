package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class acmicpc_17135_castleDefense {
	private static int N, M, D;
	private static int[][] board;
	private static int[][] boardTemp;
	private static int[][] target;
	private static int[] position;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		boardTemp = new int[N][M];
		position = new int[M];
		target = new int[3][2];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				boardTemp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(++cnt<=3) position[M-cnt]=1; // 뒤에 R만큼 1 채우기
		int max = 0;
		
		do {
			int count = 0;
			board = arrayCopy();
//			System.out.println("position is" +Arrays.toString(position));
			while(!gameOverCheck()) {
				//게임이 끝날때까지
				cnt = 0;
				for(int i=0; i<M; i++) { // 각각의 타겟을 target 2차 함수에 넣는다.
					if(position[i]==1) {
						target[cnt] = findtarget(i,cnt++);
					}
					if (cnt == 3)
						break;
				}
				
//				System.out.println("kill before");
//				print(board);
				
				for(int i=0; i<3; i++) {
					if(target[i] != null && board[target[i][0]][target[i][1]] == 1) {
						board[target[i][0]][target[i][1]] = 0;
//						System.out.println("archor"+(1+i)+" kill target["+target[i][0]+"]["+target[i][1]+"]");
						count++;
					}
				}
				
//				System.out.println("kill after");
//				print(board);

				//적들이 내려온다.
				comeEnemies();
//				System.out.println("come after");
//				print(board);
			}
			max = Math.max(max, count);
		}while(np(position)); //P를 가지고 np
		System.out.println(max);
	}
	
	private static int[][] arrayCopy() {
		int[][] newBoard = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				newBoard[i][j] = boardTemp[i][j];
			}
		}
		return newBoard;
	}
	
//	private static void print(int[][] array) { //디버그용 출력
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

	private static int[] findtarget(int num, int cnt) {
		int distance = 0;
		int min = Integer.MAX_VALUE;
		int targetPosition[] = new int[2];
		boolean flag = false;
		int x = (N-D < 0) ? 0 : N-D;
		int y = M-1;
		
		for(int i=N-1; i>=x; i--) {
			for(int j=0; j<=y; j++) {
				if(board[i][j] == 1) {
					distance = Math.abs(N-i)+Math.abs(num-j);
					if(distance <= D && distance <= min) {
						if(min == distance && flag == true && targetPosition[1] < j) continue;
						min = distance;
						targetPosition[0] = i;
						targetPosition[1] = j;
						flag = true;
					}
				}
			}
		}
		if (flag == false) return null;
		return targetPosition;
	}

	public static boolean np(int[] arr) { //n개 중에 n개 뽑는 순열만 된다. nPr은 안된다.
		//STEP 1
		int i= M-1; // 맨 뒤부터
		while(i>0 && arr[i-1] >= arr[i]) { // 인접한 두 요소 비교
			--i; // 앞으로
		}
		
		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
		if(i==0) return false;
		
		//STEP 2
		int j= M-1; // 맨 뒤부터
		// i는 꼭대기
		// i-1은 뚝 떨어진 곳(꼭대기의 바로 앞, 교환위치)
		while(arr[i-1]>= arr[j]) --j; //교환위치보다 큰 수 인지 비교
		// 뚝 떨어진 곳보다 바로 다음 큰수를 찾으면 빠져 나온다.
		
		//STEP 3
		swap(arr,i-1,j);
		
		//STEP 4
		int k= M-1; // 맨 뒤부터
		while(i<k) {
			swap(arr, i++,k--);
		}
		
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void comeEnemies() {
		for(int i = N-1; i>=1; i--) {
			for(int j = 0; j<M; j++) {
				board[i][j] = board[i-1][j];
			}
		}
		for(int j = 0; j<M; j++) {
			board[0][j] = 0;
		}
	}
	
	private static boolean gameOverCheck() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1) return false;
			}
		}
		return true;
	}

}
