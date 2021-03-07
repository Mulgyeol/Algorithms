package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class acmicpc_2718_FillWithTile {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			list.add(1); // 4*0 추가,
			list.add(1); // 4*1 추가,
			list.add(5); // 4*2 추가,
			list.add(11); // 4*3 추가.
			
			for(int i=4; i<=N; i++) { // 4부터 원하는 값까지 계산.
				int sum = 0;
				for(int j = i-3; j>=0; j -= 2) { // 3단계 전부터 홀수면 2개씩 추가
					sum += list.get(j)*2;
				}
				//	|=  =|  //   |==  ==|
				//  =|  |=  //   ==|  |==
				
				int sum2 = 0;
				for(int j = i-4; j>=0; j -= 2) { //4단계 전부터 짝수면 3개씩 추가
					sum2 += list.get(j)*3;
				}
				
				//ㅡㅡ  |==|  ㅡㅡ
				//|=|   ㅡㅡ  ㅡㅡ
				//ㅡㅡ   ㅡㅡ  |==|
				
				list.add(
					list.get(i-1) // 전 단계에서 하나 추가.
					+list.get(i-2)*4 // 두 단계 전에서 4개 추가.
					+sum
					+sum2
				);
			}
			
			System.out.println(list.get(N));

		}//테스트 케이스
	}

}
