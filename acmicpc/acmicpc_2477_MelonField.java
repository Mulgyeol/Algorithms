package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class acmicpc_2477_MelonField {
	private static boolean flag = false;
	private static int K, answer, dir, length, start, end;
	private static int temp = 0, miniSquare = 1; // temp = 반시계 방향이 맞는지 확인할 변수, 빼줄 작은 사각형 변수
	private static ArrayList<Integer> X = new ArrayList<>();
	private static ArrayList<Integer> Y = new ArrayList<>();
	private static int[] dx = {0,1,-1,0,0}; //동서남북
	private static int[] dy = {0,0,0,1,-1}; //동서남북
	private static int[] dirRoute = {0,4,3,1,2}; //동->북,서->남,남->동,북->서
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		X.add(x);
		Y.add(y);
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir = Integer.parseInt(st.nextToken());
			if(temp == 0) {
				temp = dir;
				length = Integer.parseInt(st.nextToken());
			}
			else if(dirRoute[temp] != dir) { // 방향이 다르면
				temp = dir;
				miniSquare *= length; //직전에 진행한 길이
				length = Integer.parseInt(st.nextToken());	
				miniSquare *= length; //지금 진행한 길이를 곱해준다. (작은 사각형)
				flag = true;
			}else {
				temp = dir;
				length = Integer.parseInt(st.nextToken());
			}
			
			//시작점이 꺾이는 부분일 경우
			if(i==0) start = length;
			if(i==5) end = length;
					
			
			x += dx[dir]*length;
			y += dy[dir]*length;
			
			if(!X.contains(x)) X.add(x);
			if(!Y.contains(y)) Y.add(y);
		}
		
		X.sort((o1,o2)->o1-o2);
		Y.sort((o1,o2)->o1-o2);
		
		if(flag == false) miniSquare = start*end; //시작점이 꺾이는 부분일 경우
		
		int Square = Math.abs(X.get(0)-X.get(X.size()-1)) * Math.abs(Y.get(0)-Y.get(Y.size()-1));
		answer = (Square - miniSquare) * K;
		
		System.out.println(answer);

	}

}
