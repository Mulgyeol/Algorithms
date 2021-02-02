package com.ssafy.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		for(int t=0; t<10; t++) {
			
			int result = 0;
			int dump = Integer.parseInt(bf.readLine()); // 덤프 입력
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] arr = new int[100];
			for(int i=0;i<100;i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 배열에 값 입력
			}
			
			for(int k=0; k<dump; k++) {
				int maxIndex = 0; // 최대값의 인덱스
				int minIndex = 0; // 최소값의 인덱스
				int max = Integer.MIN_VALUE; // 최대값을 담을 변수 초기화
				int min = Integer.MAX_VALUE; // 최소값을 담을 변수 초기화
				
				for(int i=0; i<100; i++) { // 100번 반복동안 최대값과 최대값을 찾는다.
					if (arr[i]>max) {
						max = arr[i];
						maxIndex = i;
					}
					if (arr[i]<min) {
						min = arr[i];
						minIndex = i;
					}
				}				
				arr[maxIndex]--; // 최대값은 -1
				arr[minIndex]++; // 최소값은 +1
				
				if((arr[maxIndex]-arr[minIndex])<=1) {
					result = arr[maxIndex]-arr[minIndex];
					sb.append("#"+(t+1)+" "+result+"\n");
					break;
				}
			} // dump만큼 반복한다.
			
			if(result == 0) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				
				for(int i=0; i<100; i++) { //최종적으로 최대값과 최소값을 찾는다.
					if (arr[i]>max) {
						max = arr[i];
					}
					if (arr[i]<min) {
						min = arr[i];
					}
				}
				
				sb.append("#"+(t+1)+" "+(max-min)+"\n"); //출력 형식에 맞춘다.
			}
				
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
