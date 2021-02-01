package com.my.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		
		for(int i=0;i<num;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int people = Integer.parseInt(br.readLine());
		
		for(int i=0; i<people; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int gender = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				mOnOff(switchNum, arr, num);
			}else {
				arr[switchNum-1] = (arr[switchNum-1]-1) *-1;
				fOnOff(switchNum-1, arr, num, 1);
			}
		}
		
		for(int i=0; i<num; i++) {
			if((i+1)%10 != 0)
				System.out.print(arr[i] + " ");
			else
				System.out.println(arr[i]);
		}
		
	}
	
	private static void mOnOff(int switchNum, int[]arr, int num) {
		for(int i=0; i<num; i++) {
			if((i+1) % switchNum == 0) {
				arr[i] = (arr[i] -= 1) * -1;
			}
		}
	}
	
	private static void fOnOff(int switchNum, int[]arr, int num, int step) {
		if(switchNum-step >=0 && switchNum+step <num && arr[switchNum-step]==arr[switchNum+step]) {
			arr[switchNum-step] = (arr[switchNum-step] -=1 ) * -1;
			arr[switchNum+step] = (arr[switchNum+step] -=1 ) * -1;
			fOnOff(switchNum, arr, num, step+1);
		}else {
			return;
		}
	}
	
	

}
