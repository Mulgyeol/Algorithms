package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_10163_ColoredPaper {
	
	private static int N; // 색종이의 장수
	private static int[][] arr = new int[101][101]; // 전체 배열
	private static int[] answer; // 답을 저장할 배열
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		answer = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for(int y = startY; y<height+startY; y++) {
				for(int x = startX; x<width+startX; x++) {
					if(arr[x][y] != 0) {
						answer[arr[x][y]]--; // 이미 값 있으면 빼기
					}
					arr[x][y] = i;
					answer[i]++; //입력하면서 갯수 세기
				}
			}
			
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(answer[i]);
		}
	}

}
