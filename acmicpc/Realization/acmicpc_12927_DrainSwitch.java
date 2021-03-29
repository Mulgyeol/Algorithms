package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_12927_DrainSwitch {

	static int N, count = 0;
	static char[] arr;
	static boolean isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		N = arr.length;
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 'Y') {
				pushSwitch(i+1);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void pushSwitch(int m) {
		for(int i = m-1; i<N; i += m) {
			if(arr[i] == 'Y') arr[i] = 'N';
			else arr[i] = 'Y';
		}
	}

}
