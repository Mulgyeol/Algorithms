package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class acmicpc_15686_ChickenDelivery {
	
	static int N, M, cityChickdis, answer = Integer.MAX_VALUE;
	static int chickCnt;
	static ArrayList<Home> home = new ArrayList<>();
	static ArrayList<Chicken> chicken = new ArrayList<>();
	
	static class Home{
		int x;
		int y;
		int chickDis;
		
		Home(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Chicken{
		int x;
		int y;
		
		Chicken(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int temp;
				
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if(temp==1) home.add(new Home(i,j));
				else if(temp==2) chicken.add(new Chicken(i,j));
			}
		}
		
		int cnt = 0;
		chickCnt = chicken.size();
		int[] P = new int[chickCnt];
		
		while(++cnt<=M) P[chickCnt-cnt]=1; // 뒤에 R만큼 1 채우기
		
		do{
			cityChickdis = 0;
			for(int i=0; i<home.size(); i++) {
				int min = Integer.MAX_VALUE;
				Home h = home.get(i);
				for(int j=0; j<chickCnt; j++) {
					if(P[j]==1) min = Math.min(min, getdis(h,chicken.get(j)));
				}
				cityChickdis += min;
			}
			answer = Math.min(answer, cityChickdis);
			
		}while(np(P));
		
		System.out.println(answer);

	}
	
	private static int getdis(Home home, Chicken chicken) {
		return Math.abs(home.x-chicken.x) + Math.abs(home.y-chicken.y);
	}

	public static boolean np(int[] arr) {
		//STEP 1
		int i= chickCnt-1; // 맨 뒤부터
		while(i>0 && arr[i-1] >= arr[i]) { // 인접한 두 요소 비교
			--i; // 앞으로
		}
		
		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
		if(i==0) return false;
		
		//STEP 2
		int j= chickCnt-1; // 맨 뒤부터
		// i는 꼭대기
		// i-1은 뚝 떨어진 곳(꼭대기의 바로 앞, 교환위치)
		while(arr[i-1]>= arr[j]) --j; //교환위치보다 큰 수 인지 비교
		// 뚝 떨어진 곳보다 바로 다음 큰수를 찾으면 빠져 나온다.
		
		//STEP 3
		swap(arr,i-1,j);
		
		//STEP 4
		int k= chickCnt-1; // 맨 뒤부터
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

}
