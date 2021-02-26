package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_1244_SwitchOnOff {

	static int N,S;
	static boolean[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			if(Integer.parseInt(st.nextToken())==0) {
				arr[i] = false;
			}else {
				arr[i] = true;
			}
		}
		
		S = Integer.parseInt(br.readLine());
		
		for(int i=0; i<S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			
			pushSwitch(gender, switchNum);
		}
		
		for(int i=1; i<N+1; i++) {
			if(arr[i] == true)
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
			
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
		
	}
	
	
	public static void pushSwitch(int gender, int switchNum) {
		if (gender == 1) {
			for(int i = switchNum; i<N+1; i+=switchNum) {
				arr[i] = !arr[i];
			}
		}else {
			arr[switchNum] = !arr[switchNum];
			int left = switchNum - 1;
			int right = switchNum + 1;
			
			while(left >=1 && right < N+1 && arr[left] == arr[right]) {
				arr[left] = !arr[left];
				arr[right] = !arr[right];
				
				left -= 1;
				right += 1;
			}
		}
		
		
	}
}
